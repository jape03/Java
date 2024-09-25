import javax.swing.*;
import java.awt.*;

public class Login {

    JFrame frameLogin;
    JTextField fieldDisplayUsername;
    JTextField fieldDisplayPassword; // this jtextfield should hide password, it will show * when the password is
                                     // being typed
    JCheckBox checkSignedIn;

    JButton buttonLogin, buttonClear, buttonCloseButton;

    Font fontDisplay = new Font("Arial", Font.PLAIN, 14);

    public Login() {
        
    }
