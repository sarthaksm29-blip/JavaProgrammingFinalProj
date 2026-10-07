import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SalonGUI extends JFrame {

    // =========================================================
    // COLORS
    // =========================================================

    private static final Color BACKGROUND =
            new Color(250, 247, 249);

    private static final Color CARD =
            Color.WHITE;

    private static final Color PRIMARY =
            new Color(90, 45, 75);

    private static final Color PRIMARY_LIGHT =
            new Color(125, 75, 105);

    private static final Color BORDER =
            new Color(220, 210, 218);

    private static final Color TEXT =
            new Color(45, 40, 45);

    private static final Color MUTED =
            new Color(110, 100, 110);

    // =========================================================
    // MANAGER
    // =========================================================

    private final AppointmentManager manager =
            new AppointmentManager();

    // =========================================================
    // FIELDS
    // =========================================================

    private JTextField customerField;
    private JTextField phoneField;

    private JComboBox<String> stylistCombo;
    private JComboBox<String> serviceCombo;

    private JLabel specialtyLabel;

    private JTextField dateField;
    private JTextField timeField;

    private JTextField appointmentIdField;

    private JTable appointmentTable;
    private DefaultTableModel tableModel;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public SalonGUI() {

        setTitle("Salon & Spa Appointment Booking System");

        setSize(1200, 720);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        setLocationRelativeTo(null);

        getContentPane().setBackground(BACKGROUND);

        initializeUI();
    }

    // =========================================================
    // INITIALIZE UI
    // =========================================================

    private void initializeUI() {

        setLayout(new BorderLayout(0, 10));

        // =====================================================
        // HEADER
        // =====================================================

        JPanel headerPanel =
                new JPanel();

        headerPanel.setBackground(BACKGROUND);

        headerPanel.setLayout(
                new BoxLayout(
                        headerPanel,
                        BoxLayout.Y_AXIS
                )
        );

        headerPanel.setBorder(
                new EmptyBorder(
                        20,
                        20,
                        5,
                        20
                )
        );

        JLabel title =
                new JLabel(
                        "SALON & SPA",
                        SwingConstants.CENTER
                );

        title.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        30
                )
        );

        title.setForeground(PRIMARY);

        JLabel subtitle =
                new JLabel(
                        "APPOINTMENT BOOKING SYSTEM",
                        SwingConstants.CENTER
                );

        subtitle.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        subtitle.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        15
                )
        );

        subtitle.setForeground(MUTED);

        headerPanel.add(title);
        headerPanel.add(
                Box.createVerticalStrut(5)
        );
        headerPanel.add(subtitle);

        add(
                headerPanel,
                BorderLayout.NORTH
        );

        // =====================================================
        // MAIN CENTER PANEL
        // =====================================================

        JPanel centerPanel =
                new JPanel(
                        new BorderLayout(0, 12)
                );

        centerPanel.setBackground(
                BACKGROUND
        );

        centerPanel.setBorder(
                new EmptyBorder(
                        0,
                        20,
                        0,
                        20
                )
        );

        // =====================================================
        // BOOKING CARD
        // =====================================================

        JPanel bookingCard =
                new JPanel(
                        new BorderLayout(0, 12)
                );

        bookingCard.setBackground(CARD);

        bookingCard.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(
                                BORDER,
                                1
                        ),
                        new EmptyBorder(
                                18,
                                20,
                                18,
                                20
                        )
                )
        );

        JLabel bookingTitle =
                new JLabel(
                        "BOOK AN APPOINTMENT"
                );

        bookingTitle.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        bookingTitle.setForeground(
                PRIMARY
        );

        bookingCard.add(
                bookingTitle,
                BorderLayout.NORTH
        );

        // =====================================================
        // FORM
        // =====================================================

        JPanel formPanel =
                new JPanel(
                        new GridLayout(
                                5,
                                4,
                                12,
                                10
                        )
                );

        formPanel.setBackground(CARD);

        // Customer Name
        formPanel.add(
                createLabel("Customer Name:")
        );

        customerField =
                new JTextField();

        styleTextField(customerField);

        formPanel.add(customerField);

        // Phone
        formPanel.add(
                createLabel("Phone:")
        );

        phoneField =
                new JTextField();

        styleTextField(phoneField);

        formPanel.add(phoneField);

        // Stylist
        formPanel.add(
                createLabel("Stylist:")
        );

        stylistCombo =
                new JComboBox<>(
                        new String[]{
                                "Rahul",
                                "Priya",
                                "Amit",
                                "Neha"
                        }
                );

        styleComboBox(stylistCombo);

        formPanel.add(stylistCombo);

        // Service
        formPanel.add(
                createLabel("Service:")
        );

        serviceCombo =
                new JComboBox<>(
                        new String[]{
                                "Premium Haircut",
                                "Hair Spa",
                                "Luxury Facial",
                                "Full Body Massage"
                        }
                );

        styleComboBox(serviceCombo);

        formPanel.add(serviceCombo);

        // Specialty
        formPanel.add(
                createLabel("Specialty:")
        );

        specialtyLabel =
                new JLabel();

        specialtyLabel.setFont(
                new Font(
                        "Arial",
                        Font.ITALIC,
                        14
                )
        );

        specialtyLabel.setForeground(
                PRIMARY_LIGHT
        );

        formPanel.add(
                specialtyLabel
        );

        // Date
        formPanel.add(
                createLabel("Date:")
        );

        dateField =
                new JTextField(
                        "01/10/2026"
                );

        styleTextField(dateField);

        formPanel.add(dateField);

        // Time
        formPanel.add(
                createLabel("Time:")
        );

        timeField =
                new JTextField(
                        "8:00 PM"
                );

        styleTextField(timeField);

        formPanel.add(timeField);

        // Empty cells
        formPanel.add(
                new JLabel("")
        );

        formPanel.add(
                new JLabel("")
        );

        // Book button
        JButton bookButton =
                createButton(
                        "Book Appointment",
                        PRIMARY
                );

        // Clear button
        JButton clearButton =
                createButton(
                        "Clear",
                        new Color(
                                245,
                                238,
                                243
                        )
                );

        clearButton.setForeground(
                PRIMARY
        );

        formPanel.add(bookButton);
        formPanel.add(clearButton);

        bookingCard.add(
                formPanel,
                BorderLayout.CENTER
        );

        centerPanel.add(
                bookingCard,
                BorderLayout.NORTH
        );

        // =====================================================
        // TABLE
        // =====================================================

        String[] columns = {
                "ID",
                "Customer",
                "Stylist",
                "Service",
                "Date",
                "Time",
                "Price"
        };

        tableModel =
                new DefaultTableModel(
                        columns,
                        0
                ) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column) {

                        return false;
                    }
                };

        appointmentTable =
                new JTable(tableModel);

        appointmentTable.setRowHeight(30);

        appointmentTable.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        13
                )
        );

        appointmentTable.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        appointmentTable
                .getTableHeader()
                .setFont(
                        new Font(
                                "Arial",
                                Font.BOLD,
                                14
                        )
                );

        appointmentTable
                .getTableHeader()
                .setBackground(
                        PRIMARY
                );

        appointmentTable
                .getTableHeader()
                .setForeground(
                        Color.WHITE
                );

        appointmentTable.setGridColor(
                BORDER
        );

        JScrollPane scrollPane =
                new JScrollPane(
                        appointmentTable
                );

        scrollPane.setBorder(
                new LineBorder(
                        BORDER,
                        1
                )
        );

        centerPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        add(
                centerPanel,
                BorderLayout.CENTER
        );

        // =====================================================
        // BOTTOM PANEL
        // =====================================================

        JPanel bottomPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.CENTER,
                                12,
                                12
                        )
                );

        bottomPanel.setBackground(CARD);

        bottomPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(
                                BORDER,
                                1
                        ),
                        new EmptyBorder(
                                6,
                                10,
                                6,
                                10
                        )
                )
        );

        bottomPanel.add(
                createLabel("Appointment ID:")
        );

        appointmentIdField =
                new JTextField(8);

        styleTextField(
                appointmentIdField
        );

        bottomPanel.add(
                appointmentIdField
        );

        JButton searchButton =
                createButton(
                        "Search",
                        PRIMARY
                );

        JButton updateButton =
                createButton(
                        "Update",
                        PRIMARY
                );

        JButton cancelButton =
                createButton(
                        "Cancel",
                        new Color(
                                250,
                                235,
                                238
                        )
                );

        cancelButton.setForeground(
                new Color(
                        170,
                        45,
                        55
                )
        );

        bottomPanel.add(searchButton);
        bottomPanel.add(updateButton);
        bottomPanel.add(cancelButton);

        add(
                bottomPanel,
                BorderLayout.SOUTH
        );

        // =====================================================
        // STYLIST CHANGE
        // =====================================================

        stylistCombo.addActionListener(
                e -> {

                    updateSpecialty();

                    updateService();
                }
        );

        // Set initial values
        updateSpecialty();
        updateService();

        // =====================================================
        // BUTTON ACTIONS
        // =====================================================

        bookButton.addActionListener(
                e -> bookAppointment()
        );

        clearButton.addActionListener(
                e -> clearFields()
        );

        searchButton.addActionListener(
                e -> searchAppointment()
        );

        updateButton.addActionListener(
                e -> updateAppointment()
        );

        cancelButton.addActionListener(
                e -> cancelAppointment()
        );

        // =====================================================
        // DOUBLE CLICK TABLE ROW
        // =====================================================

        appointmentTable.addMouseListener(
                new java.awt.event.MouseAdapter() {

                    @Override
                    public void mouseClicked(
                            java.awt.event.MouseEvent e) {

                        if (e.getClickCount() == 2) {

                            int row =
                                    appointmentTable
                                            .getSelectedRow();

                            if (row >= 0) {

                                loadSelectedAppointment(
                                        row
                                );
                            }
                        }
                    }
                }
        );
    }

    // =========================================================
    // CREATE LABEL
    // =========================================================

    private JLabel createLabel(
            String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        label.setForeground(TEXT);

        return label;
    }

    // =========================================================
    // STYLE TEXT FIELD
    // =========================================================

    private void styleTextField(
            JTextField field) {

        field.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        new LineBorder(
                                BORDER,
                                1
                        ),
                        new EmptyBorder(
                                6,
                                8,
                                6,
                                8
                        )
                )
        );
    }

    // =========================================================
    // STYLE COMBO BOX
    // =========================================================

    private void styleComboBox(
            JComboBox<String> combo) {

        combo.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        combo.setBackground(
                Color.WHITE
        );

        combo.setBorder(
                new LineBorder(
                        BORDER,
                        1
                )
        );
    }

    // =========================================================
    // CREATE BUTTON
    // =========================================================

    private JButton createButton(
            String text,
            Color background) {

        JButton button =
                new JButton(text);

        button.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        13
                )
        );

        button.setBackground(
                background
        );

        button.setForeground(
                Color.WHITE
        );

        button.setFocusPainted(false);

        button.setBorder(
                new EmptyBorder(
                        8,
                        15,
                        8,
                        15
                )
        );

        return button;
    }

    // =========================================================
    // UPDATE SPECIALTY
    // =========================================================

    private void updateSpecialty() {

        String stylist =
                (String) stylistCombo
                        .getSelectedItem();

        if (stylist == null) {

            specialtyLabel.setText("");

            return;
        }

        switch (stylist) {

            case "Rahul":
                specialtyLabel.setText(
                        "Haircut & Styling"
                );
                break;

            case "Priya":
                specialtyLabel.setText(
                        "Facial & Skin Care"
                );
                break;

            case "Amit":
                specialtyLabel.setText(
                        "Massage & Wellness"
                );
                break;

            case "Neha":
                specialtyLabel.setText(
                        "Hair Spa & Treatments"
                );
                break;

            default:
                specialtyLabel.setText(
                        "General Services"
                );
        }
    }

    // =========================================================
    // UPDATE SERVICE BASED ON STYLIST
    // =========================================================

    private void updateService() {

        String stylist =
                (String) stylistCombo
                        .getSelectedItem();

        if (stylist == null) {
            return;
        }

        switch (stylist) {

            case "Rahul":

                serviceCombo.setSelectedItem(
                        "Premium Haircut"
                );

                break;

            case "Priya":

                serviceCombo.setSelectedItem(
                        "Luxury Facial"
                );

                break;

            case "Amit":

                serviceCombo.setSelectedItem(
                        "Full Body Massage"
                );

                break;

            case "Neha":

                serviceCombo.setSelectedItem(
                        "Hair Spa"
                );

                break;
        }
    }

    // =========================================================
    // CREATE STYLIST
    // =========================================================

    private Stylist createStylist(
            String stylistName) {

        String specialty;

        switch (stylistName) {

            case "Rahul":
                specialty =
                        "Haircut & Styling";
                break;

            case "Priya":
                specialty =
                        "Facial & Skin Care";
                break;

            case "Amit":
                specialty =
                        "Massage & Wellness";
                break;

            case "Neha":
                specialty =
                        "Hair Spa & Treatments";
                break;

            default:
                specialty =
                        "General Services";
        }

        return new Stylist(
                stylistName,
                specialty
        );
    }

    // =========================================================
    // CREATE SERVICE
    // =========================================================

    private ServicePackage createService(
            String serviceName) {

        switch (serviceName) {

            case "Premium Haircut":

                return new ServicePackage(
                        "Premium Haircut",
                        500.0
                );

            case "Hair Spa":

                return new ServicePackage(
                        "Hair Spa",
                        800.0
                );

            case "Luxury Facial":

                return new ServicePackage(
                        "Luxury Facial",
                        1200.0
                );

            case "Full Body Massage":

                return new ServicePackage(
                        "Full Body Massage",
                        1800.0
                );

            default:

                return new ServicePackage(
                        serviceName,
                        500.0
                );
        }
    }

    // =========================================================
    // BOOK APPOINTMENT
    // =========================================================

    private void bookAppointment() {

        String customerName =
                customerField
                        .getText()
                        .trim();

        String phone =
                phoneField
                        .getText()
                        .trim();

        String stylistName =
                stylistCombo
                        .getSelectedItem()
                        .toString();

        String serviceName =
                serviceCombo
                        .getSelectedItem()
                        .toString();

        String date =
                dateField
                        .getText()
                        .trim();

        String time =
                timeField
                        .getText()
                        .trim();

        if (customerName.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter customer name."
            );

            return;
        }

        if (phone.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter phone number."
            );

            return;
        }

        if (date.isEmpty()
                || time.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please enter date and time."
            );

            return;
        }

        Customer customer =
                new Customer(
                        customerName,
                        phone
                );

        Stylist stylist =
                createStylist(
                        stylistName
                );

        ServicePackage service =
                createService(
                        serviceName
                );

        Appointment appointment =
                new Appointment(
                        manager.generateId(),
                        customer,
                        stylist,
                        service,
                        date,
                        time
                );

        try {

            manager.bookAppointment(
                    appointment
            );

            refreshTable();

            JOptionPane.showMessageDialog(
                    this,
                    "Appointment booked successfully!"
            );

            clearFields();

        } catch (RuntimeException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Booking Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // SEARCH APPOINTMENT
    // =========================================================

    private void searchAppointment() {

        String idText =
                appointmentIdField
                        .getText()
                        .trim();

        if (idText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter Appointment ID."
            );

            return;
        }

        try {

            int id =
                    Integer.parseInt(idText);

            Appointment appointment =
                    manager.searchAppointment(id);

            if (appointment == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Appointment not found."
                );

                return;
            }

            loadAppointment(
                    appointment
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Appointment ID must be a number."
            );
        }
    }

    // =========================================================
    // UPDATE APPOINTMENT
    // =========================================================

    private void updateAppointment() {

        String idText =
                appointmentIdField
                        .getText()
                        .trim();

        if (idText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter Appointment ID."
            );

            return;
        }

        try {

            int id =
                    Integer.parseInt(idText);

            Appointment existing =
                    manager.searchAppointment(id);

            if (existing == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Appointment not found."
                );

                return;
            }

            String customerName =
                    customerField
                            .getText()
                            .trim();

            String phone =
                    phoneField
                            .getText()
                            .trim();

            String stylistName =
                    stylistCombo
                            .getSelectedItem()
                            .toString();

            String serviceName =
                    serviceCombo
                            .getSelectedItem()
                            .toString();

            String date =
                    dateField
                            .getText()
                            .trim();

            String time =
                    timeField
                            .getText()
                            .trim();

            if (customerName.isEmpty()
                    || phone.isEmpty()
                    || date.isEmpty()
                    || time.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please fill all required fields."
                );

                return;
            }

            Customer customer =
                    new Customer(
                            customerName,
                            phone
                    );

            Stylist stylist =
                    createStylist(
                            stylistName
                    );

            ServicePackage service =
                    createService(
                            serviceName
                    );

            manager.updateAppointment(
                    id,
                    customer,
                    stylist,
                    service,
                    date,
                    time
            );

            refreshTable();

            JOptionPane.showMessageDialog(
                    this,
                    "Appointment updated successfully!"
            );

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Appointment ID must be a number."
            );

        } catch (RuntimeException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Update Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================================================
    // CANCEL APPOINTMENT
    // =========================================================

    private void cancelAppointment() {

        String idText =
                appointmentIdField
                        .getText()
                        .trim();

        if (idText.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Enter Appointment ID."
            );

            return;
        }

        try {

            int id =
                    Integer.parseInt(idText);

            Appointment appointment =
                    manager.searchAppointment(id);

            if (appointment == null) {

                JOptionPane.showMessageDialog(
                        this,
                        "Appointment not found."
                );

                return;
            }

            int choice =
                    JOptionPane.showConfirmDialog(
                            this,
                            "Cancel appointment "
                                    + id
                                    + "?",
                            "Confirm Cancellation",
                            JOptionPane.YES_NO_OPTION
                    );

            if (choice
                    == JOptionPane.YES_OPTION) {

                manager.cancelAppointment(id);

                refreshTable();

                JOptionPane.showMessageDialog(
                        this,
                        "Appointment cancelled successfully!"
                );

                clearFields();
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Appointment ID must be a number."
            );
        }
    }

    // =========================================================
    // LOAD APPOINTMENT
    // =========================================================

    private void loadAppointment(
            Appointment appointment) {

        appointmentIdField.setText(
                String.valueOf(
                        appointment.getId()
                )
        );

        customerField.setText(
                appointment
                        .getCustomer()
                        .getName()
        );

        phoneField.setText(
                appointment
                        .getCustomer()
                        .getPhone()
        );

        stylistCombo.setSelectedItem(
                appointment
                        .getStylist()
                        .getName()
        );

        updateSpecialty();

        serviceCombo.setSelectedItem(
                appointment
                        .getService()
                        .getServiceName()
        );

        dateField.setText(
                appointment.getDate()
        );

        timeField.setText(
                appointment.getTime()
        );
    }

    // =========================================================
    // LOAD SELECTED TABLE ROW
    // =========================================================

    private void loadSelectedAppointment(
            int row) {

        int id =
                Integer.parseInt(
                        tableModel
                                .getValueAt(
                                        row,
                                        0
                                )
                                .toString()
                );

        Appointment appointment =
                manager.searchAppointment(id);

        if (appointment != null) {

            loadAppointment(
                    appointment
            );
        }
    }

    // =========================================================
    // REFRESH TABLE
    // =========================================================

    private void refreshTable() {

        tableModel.setRowCount(0);

        for (Appointment appointment :
                manager.getAppointments()) {

            tableModel.addRow(
                    new Object[]{
                            appointment.getId(),

                            appointment
                                    .getCustomer()
                                    .getName(),

                            appointment
                                    .getStylist()
                                    .getName(),

                            appointment
                                    .getService()
                                    .getServiceName(),

                            appointment.getDate(),

                            appointment.getTime(),

                            "₹"
                                    + appointment
                                    .getService()
                                    .getPrice()
                    }
            );
        }
    }

    // =========================================================
    // CLEAR FIELDS
    // =========================================================

    private void clearFields() {

        customerField.setText("");

        phoneField.setText("");

        stylistCombo.setSelectedIndex(0);

        updateSpecialty();

        updateService();

        dateField.setText(
                "01/10/2026"
        );

        timeField.setText(
                "8:00 PM"
        );

        appointmentIdField.setText("");
    }

    // =========================================================
    // MAIN
    // =========================================================

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                () -> {

                    SalonGUI gui =
                            new SalonGUI();

                    gui.setVisible(true);
                }
        );
    }
}