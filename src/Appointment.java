public class Appointment {

    private int id;
    private Customer customer;
    private Stylist stylist;
    private ServicePackage service;
    private String date;
    private String time;

    public Appointment(
            int id,
            Customer customer,
            Stylist stylist,
            ServicePackage service,
            String date,
            String time) {

        this.id = id;
        this.customer = customer;
        this.stylist = stylist;
        this.service = service;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Stylist getStylist() {
        return stylist;
    }

    public void setStylist(Stylist stylist) {
        this.stylist = stylist;
    }

    public ServicePackage getService() {
        return service;
    }

    public void setService(ServicePackage service) {
        this.service = service;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return id + " | "
                + customer.getName() + " | "
                + stylist.getName() + " | "
                + service.getServiceName() + " | "
                + date + " | "
                + time + " | ₹"
                + service.getPrice();
    }
}