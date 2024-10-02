import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

public class PasswordCreation {

    JFrame framePasswordCreation;
    JPasswordField fieldDisplayPassword;
    JButton buttonPasswordCreation, buttonClear, buttonCloseButton, buttonLogout, buttonPanel;
    Font fontDisplay = new Font("Arial", Font.PLAIN, 16);
    Preferences preferences = Preferences.userRoot().node(this.getClass().getName());

    public PasswordCreation() {
        // user is already logged in
        if (isPasswordSaved()) {

            buttonLogout = new JButton("LOGOUT");
            buttonLogout.setPreferredSize(new Dimension(110, 30));
            buttonLogout.setBackground(new Color(220, 20, 60));
            buttonLogout.setForeground(Color.WHITE);
            buttonLogout.setFocusPainted(false);

            buttonLogout.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // clearPasswordCreation(); must be fixed, cause of error
                    JOptionPane.showMessageDialog(framePasswordCreation, "Logged out.");
                    framePasswordCreation.dispose();
                    new PasswordCreation();
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(60, 63, 65));
            buttonPanel.add(buttonLogout);

            framePasswordCreation.add(buttonPanel, BorderLayout.SOUTH);

            framePasswordCreation.setLocationRelativeTo(null);
            framePasswordCreation.setVisible(true);

            return;
        }

        framePasswordCreation = new JFrame("PasswordCreation");
        framePasswordCreation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePasswordCreation.setSize(400, 300);
        framePasswordCreation.getContentPane().setBackground(new Color(60, 63, 65));
        framePasswordCreation.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(60, 63, 65));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        fieldDisplayPassword = new JPasswordField();

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBackground(new Color(60, 63, 65));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        buttonPasswordCreation = new JButton("SAVE");
        buttonPasswordCreation.setPreferredSize(new Dimension(110, 30));
        buttonPasswordCreation.setBackground(new Color(30, 144, 255));
        buttonPasswordCreation.setForeground(Color.WHITE);
        buttonPasswordCreation.setFocusPainted(false);

        buttonClear = new JButton("RESET");
        buttonClear.setPreferredSize(new Dimension(110, 30));
        buttonClear.setBackground(new Color(30, 144, 255));
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setFocusPainted(false);

        buttonCloseButton = new JButton("EXIT");
        buttonCloseButton.setPreferredSize(new Dimension(110, 30));
        buttonCloseButton.setBackground(new Color(220, 20, 60));
        buttonCloseButton.setForeground(Color.WHITE);
        buttonCloseButton.setFocusPainted(false);

        buttonPanel.add(buttonPasswordCreation);
        buttonPanel.add(buttonClear);
        buttonPanel.add(buttonCloseButton);

        // This comment should be a try catch instead of an if else
        /*
         * buttonPasswordCreation.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * 
         * String username = fieldDisplayUsername.getText();
         * String password = new String(fieldDisplayPassword.getPassword());
         * 
         * if (checkUser(username) && checkPassword(password)) {
         * JOptionPane.showMessageDialog(framePasswordCreation,
         * "PasswordCreation successful");
         * 
         * if (checkSignedIn.isSelected()) {
         * checkedPasswordCreation(username);
         * }
         * 
         * framePasswordCreation.dispose();
         * } else if (!checkUser(username)) {
         * JOptionPane.showMessageDialog(framePasswordCreation,
         * "Invalid username format. Username format: Initial of First Name, Initial of Middle Name and complete Last Name ex. ADAquino"
         * );
         * } else if (!checkPassword(password)) {
         * JOptionPane.showMessageDialog(framePasswordCreation,
         * "Invalid password. The password must have at least 8 characters, must have at least one char both lower and uppercase, one number and one special character."
         * );
         * }
         * }
         * });
         */

        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                fieldDisplayPassword.setText("");

                // clearPasswordCreation(); must be fixed also, caused of error
            }
        });

        buttonCloseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                framePasswordCreation.dispose();
            }
        });

        mainPanel.add(formPanel);
        mainPanel.add(buttonPanel);

        framePasswordCreation.add(mainPanel, BorderLayout.CENTER);

        framePasswordCreation.setLocationRelativeTo(null);
        framePasswordCreation.setVisible(true);
    }

    // Validate password
    public boolean checkPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[a-z].*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    // Check if the user is logged in
    public boolean isPasswordSaved() {
        return preferences.getBoolean("loggedIn", false);
    }

    public static void main(String[] args) {
        new PasswordCreation();
    }
}
