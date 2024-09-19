import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration {

    JFrame frameRegistration;
    JTextField fieldDisplayName, fieldDisplayAddress, fieldDisplayEmail, fieldDisplayContact;
    JComboBox<String> fieldCourse, fieldYear;
    JRadioButton radioMale, radioFemale;
    JButton buttonRegister, buttonClear, buttonExit;
    ButtonGroup genderGroup;

    public Registration() {
        initializeFrame();
    }

    public void initializeFrame() {
        frameRegistration = new JFrame("Registration Form");
        frameRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistration.setSize(400, 400);
        frameRegistration.setLayout(null);

        // Name
        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(30, 30, 100, 30);
        frameRegistration.add(labelName);

        fieldDisplayName = new JTextField();
        fieldDisplayName.setBounds(140, 30, 200, 30);
        frameRegistration.add(fieldDisplayName);

        // Course
        JLabel labelCourse = new JLabel("Course:");
        labelCourse.setBounds(30, 70, 100, 30);
        frameRegistration.add(labelCourse);

        String[] courses = { "BSCS-SE", "BSIT", "BSEE", "BSME" };
        fieldCourse = new JComboBox<>(courses);
        fieldCourse.setBounds(140, 70, 200, 30);
        frameRegistration.add(fieldCourse);

        // Year
        JLabel labelYear = new JLabel("Year:");
        labelYear.setBounds(30, 110, 100, 30);
        frameRegistration.add(labelYear);

        String[] years = { "1", "2", "3", "4" };
        fieldYear = new JComboBox<>(years);
        fieldYear.setBounds(140, 110, 200, 30);
        frameRegistration.add(fieldYear);

        // Gender
        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(30, 150, 100, 30);
        frameRegistration.add(labelGender);

        radioMale = new JRadioButton("Male");
        radioMale.setBounds(140, 150, 80, 30);
        radioFemale = new JRadioButton("Female");
        radioFemale.setBounds(230, 150, 80, 30);

        // Group for radio buttons
        genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);

        frameRegistration.add(radioMale);
        frameRegistration.add(radioFemale);

        // Address
        JLabel labelAddress = new JLabel("Address:");
        labelAddress.setBounds(30, 190, 100, 30);
        frameRegistration.add(labelAddress);

        fieldDisplayAddress = new JTextField();
        fieldDisplayAddress.setBounds(140, 190, 200, 30);
        frameRegistration.add(fieldDisplayAddress);

        // Email
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(30, 230, 100, 30);
        frameRegistration.add(labelEmail);

        fieldDisplayEmail = new JTextField();
        fieldDisplayEmail.setBounds(140, 230, 200, 30);
        frameRegistration.add(fieldDisplayEmail);

        // Contact Number
        JLabel labelContact = new JLabel("Contact Number:");
        labelContact.setBounds(30, 270, 120, 30);
        frameRegistration.add(labelContact);

        fieldDisplayContact = new JTextField();
        fieldDisplayContact.setBounds(140, 270, 200, 30);
        frameRegistration.add(fieldDisplayContact);

        // Buttons
        buttonRegister = new JButton("REGISTER");
        buttonRegister.setBounds(50, 320, 100, 30);
        frameRegistration.add(buttonRegister);

        buttonClear = new JButton("CLEAR");
        buttonClear.setBounds(160, 320, 100, 30);
        frameRegistration.add(buttonClear);

        buttonExit = new JButton("EXIT");
        buttonExit.setBounds(270, 320, 100, 30);
        frameRegistration.add(buttonExit);

        // Action Listeners
        buttonExit.addActionListener(e -> System.exit(0));
        buttonClear.addActionListener(e -> clearFields());

        // Register Button functionality
        buttonRegister.addActionListener(e -> registerUser());

        frameRegistration.setVisible(true);
    }

    private void clearFields() {
        fieldDisplayName.setText("");
        fieldCourse.setSelectedIndex(0);
        fieldYear.setSelectedIndex(0);
        genderGroup.clearSelection();
        fieldDisplayAddress.setText("");
        fieldDisplayEmail.setText("");
        fieldDisplayContact.setText("");
    }

    private void registerUser() {
        // Gather data from form
        String name = fieldDisplayName.getText();
        String course = (String) fieldCourse.getSelectedItem();
        String year = (String) fieldYear.getSelectedItem();
        String gender = radioMale.isSelected() ? "Male" : radioFemale.isSelected() ? "Female" : "Not selected";
        String address = fieldDisplayAddress.getText();
        String email = fieldDisplayEmail.getText();
        String contact = fieldDisplayContact.getText();

        // Create a new JFrame to display the registration details
        JFrame frameDetails = new JFrame("Registration Details");
        frameDetails.setSize(300, 400);
        frameDetails.setLayout(null);

        // Display labels for each field
        JLabel labelDetails = new JLabel("Registration Details:");
        labelDetails.setBounds(50, 10, 200, 30);
        frameDetails.add(labelDetails);

        JLabel labelNameDetails = new JLabel("Name: " + name);
        labelNameDetails.setBounds(50, 50, 200, 30);
        frameDetails.add(labelNameDetails);

        JLabel labelCourseDetails = new JLabel("Course: " + course);
        labelCourseDetails.setBounds(50, 90, 200, 30);
        frameDetails.add(labelCourseDetails);

        JLabel labelYearDetails = new JLabel("Year: " + year);
        labelYearDetails.setBounds(50, 130, 200, 30);
        frameDetails.add(labelYearDetails);

        JLabel labelGenderDetails = new JLabel("Gender: " + gender);
        labelGenderDetails.setBounds(50, 170, 200, 30);
        frameDetails.add(labelGenderDetails);

        JLabel labelAddressDetails = new JLabel("Address: " + address);
        labelAddressDetails.setBounds(50, 210, 200, 30);
        frameDetails.add(labelAddressDetails);

        JLabel labelEmailDetails = new JLabel("Email: " + email);
        labelEmailDetails.setBounds(50, 250, 200, 30);
        frameDetails.add(labelEmailDetails);

        JLabel labelContactDetails = new JLabel("Contact: " + contact);
        labelContactDetails.setBounds(50, 290, 200, 30);
        frameDetails.add(labelContactDetails);

        // Show the details frame
        frameDetails.setVisible(true);
    }

    public static void main(String[] args) {
        new Registration();
    }
}
