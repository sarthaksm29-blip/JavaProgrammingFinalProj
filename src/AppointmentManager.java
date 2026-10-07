import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class AppointmentManager implements Bookable {

    private final Map<Integer, Appointment> appointments;
    private final Map<String, Appointment> timeMap;
    private final List<String> serviceHistory;

    private int nextId = 2001;

    private final DateTimeFormatter dateFormatter =
            DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH);

    private final DateTimeFormatter timeFormatter =
            DateTimeFormatter.ofPattern("h:mm a", Locale.ENGLISH);

    public AppointmentManager() {
        appointments = new HashMap<>();
        timeMap = new HashMap<>();
        serviceHistory = new ArrayList<>();
    }

    // =========================================================
    // BOOK APPOINTMENT
    // =========================================================

    @Override
    public void bookAppointment(Appointment appointment) {

        if (appointment == null) {
            return;
        }

        String key = createKey(
                appointment.getStylist().getName(),
                appointment.getDate(),
                appointment.getTime()
        );

        if (timeMap.containsKey(key)) {

            throw new RuntimeException(
                    "Stylist "
                            + appointment.getStylist().getName()
                            + " is already booked for "
                            + appointment.getDate()
                            + " at "
                            + appointment.getTime()
                            + "."
            );
        }

        int id = appointment.getId();

        if (id <= 0) {
            id = generateId();
            appointment.setId(id);
        }

        appointments.put(id, appointment);
        timeMap.put(key, appointment);

        serviceHistory.add(
                appointment.getService().getServiceName()
        );

        System.out.println("Appointment booked successfully!");
    }

    // =========================================================
    // DISPLAY APPOINTMENTS
    // =========================================================

    public void displayAppointments() {

        System.out.println("\n--- ALL APPOINTMENTS ---");

        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        List<Appointment> list =
                new ArrayList<>(appointments.values());

        list.sort(Comparator.comparingInt(Appointment::getId));

        for (Appointment appointment : list) {
            System.out.println(appointment);
        }
    }

    // =========================================================
    // SEARCH APPOINTMENT
    // =========================================================

    public Appointment searchAppointment(int id) {

        Appointment appointment = appointments.get(id);

        if (appointment == null) {
            System.out.println("Appointment not found!");
            return null;
        }

        System.out.println("\n--- APPOINTMENT FOUND ---");
        System.out.println(appointment);

        return appointment;
    }

    // =========================================================
    // UPDATE APPOINTMENT
    // =========================================================

    @Override
    public void updateAppointment(
            int id,
            Customer customer,
            Stylist stylist,
            ServicePackage service,
            String date,
            String time) {

        Appointment appointment = appointments.get(id);

        if (appointment == null) {
            throw new RuntimeException("Appointment not found!");
        }

        String oldKey = createKey(
                appointment.getStylist().getName(),
                appointment.getDate(),
                appointment.getTime()
        );

        String newKey = createKey(
                stylist.getName(),
                date,
                time
        );

        Appointment existing = timeMap.get(newKey);

        if (existing != null && existing.getId() != id) {

            throw new RuntimeException(
                    "Stylist "
                            + stylist.getName()
                            + " is already booked for "
                            + date
                            + " at "
                            + time
                            + "."
            );
        }

        // Remove old booking key
        timeMap.remove(oldKey);

        // Update appointment
        appointment.setCustomer(customer);
        appointment.setStylist(stylist);
        appointment.setService(service);
        appointment.setDate(date);
        appointment.setTime(time);

        // Add new booking key
        timeMap.put(newKey, appointment);

        serviceHistory.add(
                service.getServiceName()
        );

        System.out.println("Appointment updated successfully!");
    }

    // =========================================================
    // CANCEL APPOINTMENT
    // =========================================================

    @Override
    public void cancelAppointment(int id) {

        Appointment appointment = appointments.get(id);

        if (appointment == null) {
            System.out.println("Appointment not found!");
            return;
        }

        String key = createKey(
                appointment.getStylist().getName(),
                appointment.getDate(),
                appointment.getTime()
        );

        appointments.remove(id);
        timeMap.remove(key);

        System.out.println("Appointment cancelled successfully!");
    }

    // =========================================================
    // SEARCH BY CUSTOMER
    // =========================================================

    public List<Appointment> searchByCustomer(String customerName) {

        List<Appointment> result = new ArrayList<>();

        for (Appointment appointment : appointments.values()) {

            if (appointment.getCustomer()
                    .getName()
                    .equalsIgnoreCase(customerName)) {

                result.add(appointment);
            }
        }

        return result;
    }

    // =========================================================
    // SEARCH BY STYLIST
    // =========================================================

    public List<Appointment> searchByStylist(String stylistName) {

        List<Appointment> result = new ArrayList<>();

        for (Appointment appointment : appointments.values()) {

            if (appointment.getStylist()
                    .getName()
                    .equalsIgnoreCase(stylistName)) {

                result.add(appointment);
            }
        }

        return result;
    }

    // =========================================================
    // SORT BY PRICE
    // =========================================================

    public List<Appointment> sortByPrice() {

        List<Appointment> result =
                new ArrayList<>(appointments.values());

        result.sort(
                Comparator.comparingDouble(
                        a -> a.getService().getPrice()
                )
        );

        return result;
    }

    // =========================================================
    // SORT BY DATE AND TIME
    // =========================================================

    public List<Appointment> sortByDateTime() {

        List<Appointment> result =
                new ArrayList<>(appointments.values());

        result.sort(
                Comparator.comparing(
                        this::getDateTime
                )
        );

        return result;
    }

    private LocalDateTime getDateTime(Appointment appointment) {

        LocalDate date =
                LocalDate.parse(
                        appointment.getDate(),
                        dateFormatter
                );

        LocalTime time =
                LocalTime.parse(
                        appointment.getTime(),
                        timeFormatter
                );

        return LocalDateTime.of(date, time);
    }

    // =========================================================
    // SERVICE HISTORY
    // =========================================================

    public void displayServiceHistory() {

        System.out.println("\n--- SERVICE HISTORY ---");

        if (serviceHistory.isEmpty()) {
            System.out.println("No service history.");
            return;
        }

        for (String service : serviceHistory) {
            System.out.println(service);
        }
    }

    // =========================================================
    // APPOINTMENTS BY TIME
    // =========================================================

    public void displayAppointmentsByTime() {

        System.out.println("\n--- APPOINTMENTS BY TIME ---");

        List<Appointment> list =
                sortByDateTime();

        int count = 1;

        for (Appointment appointment : list) {

            System.out.println(
                    count
                            + "_"
                            + appointment.getDate()
                            + "_"
                            + appointment.getTime()
                            + " -> "
                            + appointment
            );

            count++;
        }
    }

    // =========================================================
    // GENERATE ID
    // =========================================================

    public int generateId() {
        return nextId++;
    }

    // =========================================================
    // CREATE KEY
    // =========================================================

    private String createKey(
            String stylist,
            String date,
            String time) {

        return stylist.toLowerCase()
                + "_"
                + date
                + "_"
                + time;
    }

    // =========================================================
    // GET ALL APPOINTMENTS
    // =========================================================

    public List<Appointment> getAppointments() {

        return new ArrayList<>(
                appointments.values()
        );
    }
}