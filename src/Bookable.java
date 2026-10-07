public interface Bookable {

    void bookAppointment(Appointment appointment);

    void updateAppointment(
            int id,
            Customer customer,
            Stylist stylist,
            ServicePackage service,
            String date,
            String time);

    void cancelAppointment(int id);
}