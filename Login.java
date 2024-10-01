import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

public class Login {

    JFrame frameLogin;
    JTextField fieldDisplayUsername;
    JPasswordField fieldDisplayPassword;
    JCheckBox checkSignedIn;
    JButton buttonLogin, buttonClear, buttonCloseButton, buttonLogout;
    Font fontDisplay = new Font("Arial", Font.PLAIN, 16);
    Preferences preferences = Preferences.userRoot().node(this.getClass().getName());

    public Login() {
        // user is already logged in
        if (isUserLoggedIn()) {

            frameLogin = new JFrame("Welcome");
            frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frameLogin.setSize(400, 200);
            frameLogin.getContentPane().setBackground(new Color(60, 63, 65));
            frameLogin.setLayout(new BorderLayout());

            JLabel welcome = new JLabel("Welcome back, " + preferences.get("username", "") + "!", JLabel.CENTER);
            welcome.setFont(new Font("Arial", Font.BOLD, 16));
            welcome.setForeground(Color.WHITE);

            buttonLogout = new JButton("LOGOUT");
            buttonLogout.setPreferredSize(new Dimension(110, 30));
            buttonLogout.setBackground(new Color(220, 20, 60));
            buttonLogout.setForeground(Color.WHITE);
            buttonLogout.setFocusPainted(false);

            buttonLogout.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    clearLogin();
                    JOptionPane.showMessageDialog(frameLogin, "Logged out.");
                    frameLogin.dispose();
                    new Login();
                }
            });

            JPanel buttonPanel = new JPanel();
            buttonPanel.setBackground(new Color(60, 63, 65));
            buttonPanel.add(buttonLogout);

            frameLogin.add(welcome, BorderLayout.CENTER);
            frameLogin.add(buttonPanel, BorderLayout.SOUTH);

            frameLogin.setLocationRelativeTo(null);
            frameLogin.setVisible(true);

            return;
        }

        frameLogin = new JFrame("Login");
        frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameLogin.setSize(400, 300);
        frameLogin.getContentPane().setBackground(new Color(60, 63, 65));
        frameLogin.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(60, 63, 65));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        fieldDisplayUsername = new JTextField();
        fieldDisplayPassword = new JPasswordField();
        checkSignedIn = new JCheckBox("Stay signed in");
        checkSignedIn.setForeground(Color.WHITE);
        checkSignedIn.setBackground(new Color(60, 63, 65));

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        formPanel.setBackground(new Color(60, 63, 65));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        JLabel passLabel = new JLabel("Password:");
        passLabel.setForeground(Color.WHITE);

        formPanel.add(userLabel);
        formPanel.add(fieldDisplayUsername);
        formPanel.add(passLabel);
        formPanel.add(fieldDisplayPassword);
        formPanel.add(checkSignedIn);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(60, 63, 65));

        buttonLogin = new JButton("LOGIN");
        buttonLogin.setPreferredSize(new Dimension(110, 30));
        buttonLogin.setBackground(new Color(30, 144, 255));
        buttonLogin.setForeground(Color.WHITE);
        buttonLogin.setFocusPainted(false);

        buttonClear = new JButton("CLEAR");
        buttonClear.setPreferredSize(new Dimension(110, 30));
        buttonClear.setBackground(new Color(30, 144, 255));
        buttonClear.setForeground(Color.WHITE);
        buttonClear.setFocusPainted(false);

        buttonCloseButton = new JButton("CLOSE");
        buttonCloseButton.setPreferredSize(new Dimension(110, 30));
        buttonCloseButton.setBackground(new Color(220, 20, 60));
        buttonCloseButton.setForeground(Color.WHITE);
        buttonCloseButton.setFocusPainted(false);

        buttonPanel.add(buttonLogin);
        buttonPanel.add(buttonClear);
        buttonPanel.add(buttonCloseButton);

        buttonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String username = fieldDisplayUsername.getText();
                String password = new String(fieldDisplayPassword.getPassword());

                if (checkUser(username) && checkPassword(password)) {
                    JOptionPane.showMessageDialog(frameLogin, "Login successful");

                    if (checkSignedIn.isSelected()) {
                        checkedLogin(username);
                    }

                    frameLogin.dispose();
                } else if (!checkUser(username)) {
                    JOptionPane.showMessageDialog(frameLogin,
                            "Invalid username format. Username format: Initial of First Name, Initial of Middle Name and complete Last Name ex. ADAquino");
                } else if (!checkPassword(password)) {
                    JOptionPane.showMessageDialog(frameLogin,
                            "Invalid password. The password must have at least 8 characters, must have at least one char both lower and uppercase, one number and one special character.");
                }
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                fieldDisplayUsername.setText("");
                fieldDisplayPassword.setText("");
                checkSignedIn.setSelected(false);

                clearLogin();
            }
        });

        buttonCloseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frameLogin.dispose();
            }
        });

        mainPanel.add(formPanel);
        mainPanel.add(buttonPanel);

        frameLogin.add(mainPanel, BorderLayout.CENTER);

        frameLogin.setLocationRelativeTo(null);
        frameLogin.setVisible(true);
    }

    // Validate username
    public boolean checkUser(String username) {
        return username.matches("[A-Z]{2}[A-Z][a-zA-Z]+");
    }

    // Validate password
    public boolean checkPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[a-z].*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    // Preferences
    public void checkedLogin(String username) {
        preferences.putBoolean("loggedIn", true);
        preferences.put("username", username);
    }

    // Check if the user is logged in
    public boolean isUserLoggedIn() {
        return preferences.getBoolean("loggedIn", false);
    }

    // Clear login
    public void clearLogin() {
        preferences.putBoolean("loggedIn", false);
        preferences.remove("username");
    }

    public static void main(String[] args) {
        new Login();
    }
}
