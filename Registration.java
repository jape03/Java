import javax.swing.*;
import java.awt.*;

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
        frameRegistration.getContentPane().setBackground(Color.DARK_GRAY);
        frameRegistration.setLayout(null);

        // Set a minimalist font
        Font minimalistFont = new Font("Arial", Font.PLAIN, 14);

        // Name
        JLabel labelName = new JLabel("Name:");
        labelName.setBounds(30, 30, 100, 30);
        labelName.setForeground(Color.WHITE);
        labelName.setFont(minimalistFont);
        frameRegistration.add(labelName);

        fieldDisplayName = new JTextField();
        fieldDisplayName.setBounds(140, 30, 200, 30);
        fieldDisplayName.setBackground(Color.GRAY);
        fieldDisplayName.setForeground(Color.WHITE);
        fieldDisplayName.setFont(minimalistFont);
        fieldDisplayName.setBorder(BorderFactory.createEmptyBorder());
        frameRegistration.add(fieldDisplayName);

        // Course
        JLabel labelCourse = new JLabel("Course:");
        labelCourse.setBounds(30, 70, 100, 30);
        labelCourse.setForeground(Color.WHITE);
        labelCourse.setFont(minimalistFont);
        frameRegistration.add(labelCourse);

        String[] courses = { "BSCSSE", "BSCSDS", "BSCSAI", "BSIT" };
        fieldCourse = new JComboBox<>(courses);
        fieldCourse.setBounds(140, 70, 200, 30);
        fieldCourse.setBackground(Color.GRAY);
        fieldCourse.setForeground(Color.WHITE);
        fieldCourse.setFont(minimalistFont);
        fieldCourse.setBorder(BorderFactory.createEmptyBorder());
        frameRegistration.add(fieldCourse);

        // Year
        JLabel labelYear = new JLabel("Year:");
        labelYear.setBounds(30, 110, 100, 30);
        labelYear.setForeground(Color.WHITE);
        labelYear.setFont(minimalistFont);
        frameRegistration.add(labelYear);

        String[] years = { "1st", "2nd", "3rd", "4th" };
        fieldYear = new JComboBox<>(years);
        fieldYear.setBounds(140, 110, 200, 30);
        fieldYear.setBackground(Color.GRAY);
        fieldYear.setForeground(Color.WHITE);
        fieldYear.setFont(minimalistFont);
        fieldYear.setBorder(BorderFactory.createEmptyBorder());
        frameRegistration.add(fieldYear);

        // Gender
        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(30, 150, 100, 30);
        labelGender.setForeground(Color.WHITE);
        labelGender.setFont(minimalistFont);
        frameRegistration.add(labelGender);

        radioMale = new JRadioButton("Male");
        radioMale.setBounds(140, 150, 80, 30);
        radioMale.setBackground(Color.DARK_GRAY);
        radioMale.setForeground(Color.WHITE);
        radioMale.setFont(minimalistFont);

        radioFemale = new JRadioButton("Female");
        radioFemale.setBounds(230, 150, 80, 30);
        radioFemale.setBackground(Color.DARK_GRAY);
        radioFemale.setForeground(Color.WHITE);
        radioFemale.setFont(minimalistFont);

        // Group for radio buttons
        genderGroup = new ButtonGroup();
        genderGroup.add(radioMale);
        genderGroup.add(radioFemale);

        frameRegistration.add(radioMale);
        frameRegistration.add(radioFemale);

        // Address
        JLabel labelAddress = new JLabel("Address:");
        labelAddress.setBounds(30, 190, 100, 30);
        labelAddress.setForeground(Color.WHITE);
        labelAddress.setFont(minimalistFont);
        frameRegistration.add(labelAddress);

        fieldDisplayAddress = new JTextField();
        fieldDisplayAddress.setBounds(140, 190, 200, 30);
        fieldDisplayAddress.setBackground(Color.GRAY);
        fieldDisplayAddress.setForeground(Color.WHITE);
        fieldDisplayAddress.setFont(minimalistFont);
        fieldDisplayAddress.setBorder(BorderFactory.createEmptyBorder());
        frameRegistration.add(fieldDisplayAddress);

        // Email
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(30, 230, 100, 30);
        labelEmail.setForeground(Color.WHITE);
        labelEmail.setFont(minimalistFont);
        frameRegistration.add(labelEmail);

        fieldDisplayEmail = new JTextField();
        fieldDisplayEmail.setBounds(140, 230, 200, 30);
        fieldDisplayEmail.setBackground(Color.GRAY);
        fieldDisplayEmail.setForeground(Color.WHITE);
        fieldDisplayEmail.setFont(minimalistFont);
        fieldDisplayEmail.setBorder(BorderFactory.createEmptyBorder());
        frameRegistration.add(fieldDisplayEmail);

        // Contact Number
        JLabel labelContact = new JLabel("Contact Number:");
        labelContact.setBounds(30, 270, 120, 30);
        labelContact.setForeground(Color.WHITE);
        labelContact.setFont(minimalistFont);
        frameRegistration.add(labelContact);

        fieldDisplayContact = new JTextField();
        fieldDisplayContact.setBounds(140, 270, 200, 30);
        fieldDisplayContact.setBackground(Color.GRAY);
        fieldDisplayContact.setForeground(Color.WHITE);
        fieldDisplayContact.setFont(minimalistFont);
        fieldDisplayContact.setBorder(BorderFactory.createEmptyBorder());
        frameRegistration.add(fieldDisplayContact);

        // Buttons
        buttonRegister = new JButton("REGISTER");
        buttonRegister.setBounds(50, 320, 110, 30);
        buttonRegister.setBackground(Color.BLUE);
        buttonRegister.setForeground(Color.WHITE);
        buttonRegister.setFont(minimalistFont);
        frameRegistration.add(buttonRegister);

        buttonClear = new JButton("CLEAR");
        buttonClear.setBounds(160, 320, 110, 30);
        buttonClear.setBackground(Color.BLUE);
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setFont(minimalistFont);
        frameRegistration.add(buttonClear);

        buttonExit = new JButton("EXIT");
        buttonExit.setBounds(270, 320, 100, 30);
        buttonExit.setBackground(Color.BLUE);
        buttonExit.setForeground(Color.WHITE);
        buttonExit.setFont(minimalistFont);
        frameRegistration.add(buttonExit);

        // Action Listeners
        buttonExit.addActionListener(e -> System.exit(0));
        buttonClear.addActionListener(e -> clearFields());

        // Register Button functionality
        buttonRegister.addActionListener(e -> registerUser());

        frameRegistration.setVisible(true);
    }

    public void clearFields() {
        fieldDisplayName.setText("");
        fieldCourse.setSelectedIndex(0);
        fieldYear.setSelectedIndex(0);
        genderGroup.clearSelection();
        fieldDisplayAddress.setText("");
        fieldDisplayEmail.setText("");
        fieldDisplayContact.setText("");
    }

    public void registerUser() {
        // Gather data from form
        String name = fieldDisplayName.getText();
        String course = (String) fieldCourse.getSelectedItem();
        String year = (String) fieldYear.getSelectedItem();
        String address = fieldDisplayAddress.getText();
        String email = fieldDisplayEmail.getText();
        String contact = fieldDisplayContact.getText();

        String gender = "";
        if (radioMale.isSelected()) {
            gender = "Male";
        } else if (radioFemale.isSelected()) {
            gender = "Female";
        }

        // Input validation
        if (name.isEmpty() || course.isEmpty() || year.isEmpty() || gender.isEmpty() || address.isEmpty()
                || email.isEmpty() || contact.isEmpty()) {
            JOptionPane.showMessageDialog(frameRegistration, "Please, fill out all the details", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Ensure contact number is numeric
        if (!contact.matches("\\d+")) {
            JOptionPane.showMessageDialog(frameRegistration, "Contact number must be a number", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a new JFrame to display the registration details
        JFrame frameDetails = new JFrame("Registration Details");
        frameDetails.setSize(300, 400);
        frameDetails.getContentPane().setBackground(Color.DARK_GRAY);
        frameDetails.setLayout(null);

        // Display labels for each field
        JLabel labelDetails = new JLabel("Registration Details:");
        labelDetails.setBounds(50, 10, 200, 30);
        labelDetails.setForeground(Color.WHITE);
        frameDetails.add(labelDetails);

        JLabel labelNameDetails = new JLabel("Name: " + name);
        labelNameDetails.setBounds(50, 50, 200, 30);
        labelNameDetails.setForeground(Color.WHITE);
        frameDetails.add(labelNameDetails);

        JLabel labelCourseDetails = new JLabel("Course: " + course);
        labelCourseDetails.setBounds(50, 90, 200, 30);
        labelCourseDetails.setForeground(Color.WHITE);
        frameDetails.add(labelCourseDetails);

        JLabel labelYearDetails = new JLabel("Year: " + year);
        labelYearDetails.setBounds(50, 130, 200, 30);
        labelYearDetails.setForeground(Color.WHITE);
        frameDetails.add(labelYearDetails);

        JLabel labelGenderDetails = new JLabel("Gender: " + gender);
        labelGenderDetails.setBounds(50, 170, 200, 30);
        labelGenderDetails.setForeground(Color.WHITE);
        frameDetails.add(labelGenderDetails);

        JLabel labelAddressDetails = new JLabel("Address: " + address);
        labelAddressDetails.setBounds(50, 210, 200, 30);
        labelAddressDetails.setForeground(Color.WHITE);
        frameDetails.add(labelAddressDetails);

        JLabel labelEmailDetails = new JLabel("Email: " + email);
        labelEmailDetails.setBounds(50, 250, 200, 30);
        labelEmailDetails.setForeground(Color.WHITE);
        frameDetails.add(labelEmailDetails);

        JLabel labelContactDetails = new JLabel("Contact: " + contact);
        labelContactDetails.setBounds(50, 290, 200, 30);
        labelContactDetails.setForeground(Color.WHITE);
        frameDetails.add(labelContactDetails);

        // Show the details frame
        frameDetails.setVisible(true);
    }

    public static void main(String[] args) {
        new Registration();
    }
}
