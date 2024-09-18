import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration {

    JFrame frameRegistration;
    JTextField fieldDisplayName,fieldDisplayAddress,fieldDisplayEmail,fieldDisplayContact;
    JComboBox fieldCourse,fieldYear;
    JRadioButton fieldGender;
    JButton buttonRegister, buttonClear, buttonExit;

    public Registration(){
        initializeFrame();
    }

    public void initializeFrame() {
        frameRegistration = new JFrame("Registration");
        frameRegistration.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameRegistration.setSize(400, 550);
        frameRegistration.setLayout(null);
       
    }

    public static void main(String[] args) {
        new Registration();
    }
}