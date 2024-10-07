import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.Preferences;

public class PasswordCreation {

    JFrame framePasswordCreation;
    JPasswordField fieldNewPassword, fieldConfirmPassword;
    JButton buttonPasswordCreation, buttonClear, buttonCloseButton;
    Font fontDisplay = new Font("Arial", Font.PLAIN, 16);
    Preferences preferences = Preferences.userRoot().node(this.getClass().getName());

    public PasswordCreation() {
        framePasswordCreation = new JFrame("Password Creation");
        framePasswordCreation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePasswordCreation.setSize(400, 300);
        framePasswordCreation.getContentPane().setBackground(new Color(60, 63, 65));
        framePasswordCreation.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(60, 63, 65));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        fieldNewPassword = new JPasswordField();
        fieldConfirmPassword = new JPasswordField();

        fieldNewPassword.setForeground(Color.WHITE);
        fieldNewPassword.setBackground(new Color(40, 40, 40));
        fieldConfirmPassword.setForeground(Color.WHITE);
        fieldConfirmPassword.setBackground(new Color(40, 40, 40));

        fieldNewPassword.setCaretColor(Color.WHITE);
        fieldConfirmPassword.setCaretColor(Color.WHITE);

        JLabel labelNewPassword = new JLabel("New Password:");
        JLabel labelConfirmPassword = new JLabel("Confirm Password:");
        labelNewPassword.setForeground(Color.WHITE);
        labelConfirmPassword.setForeground(Color.WHITE);

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBackground(new Color(60, 63, 65));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(labelNewPassword);
        formPanel.add(fieldNewPassword);
        formPanel.add(labelConfirmPassword);
        formPanel.add(fieldConfirmPassword);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(60, 63, 65));

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

        buttonPasswordCreation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newPassword = new String(fieldNewPassword.getPassword());
                String confirmPassword = new String(fieldConfirmPassword.getPassword());
                String savedPassword = preferences.get("savedPassword", "");

                try {
                    validatePasswords(newPassword, confirmPassword, savedPassword);
                    preferences.put("savedPassword", newPassword);
                    JOptionPane.showMessageDialog(framePasswordCreation, "Password saved successfully.");
                    preferences.putBoolean("loggedIn", true);
                    framePasswordCreation.dispose();
                    new PasswordCreation();
                } catch (PasswordMatch exception) {
                    JOptionPane.showMessageDialog(framePasswordCreation, exception.getMessage());
                } catch (PasswordCriteria exception) {
                    JOptionPane.showMessageDialog(framePasswordCreation, exception.getMessage());
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(framePasswordCreation, "Error: " + exception.getMessage());
                }
            }
        });

        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearPasswordCreation();
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

    class PasswordMatch extends Exception {
        public PasswordMatch(String message) {
            super(message);
        }
    }

    class PasswordCriteria extends Exception {
        public PasswordCriteria(String message) {
            super(message);
        }
    }

    // password with exceptions
    public void validatePasswords(String newPassword, String confirmPassword, String savedPassword)
            throws PasswordMatch, PasswordCriteria {

        if (!newPassword.equals(confirmPassword)) {
            throw new PasswordMatch("Passwords do not match. Try again.");
        }

        if (newPassword.equals(savedPassword)) {
            throw new PasswordMatch(
                    "The new password cannot be the same as the current password. Please try a different password.");
        }

        if (!checkPassword(newPassword)) {
            throw new PasswordCriteria(
                    "Invalid password. Password must be at least 8 characters, must have at least one char both lower and uppercase, one number, and one special character.");
        }
    }

    // password criteria
    public boolean checkPassword(String password) {
        return password.length() >= 8 &&
                password.matches(".*[a-z].*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*[0-9].*") &&
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
    }

    public void clearPasswordCreation() {
        fieldNewPassword.setText("");
        fieldConfirmPassword.setText("");
    }

    public static void main(String[] args) {
        new PasswordCreation();
    }
}
