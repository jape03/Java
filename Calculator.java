import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[6]; // Adjusted size to 6
    JButton addButton, subButton, mulButton, divButton;
    JButton equButton, clrButton;
    JPanel panel;

    Font myFont = new Font("Arial", Font.PLAIN, 24); // Updated Font

    StringBuilder currentExpression = new StringBuilder(); // Store the current expression

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 550);
        frame.setLayout(null);

        // Text field
        textfield = new JTextField();
        textfield.setBounds(30, 25, 340, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setHorizontalAlignment(JTextField.RIGHT);
        textfield.setText("0"); // Initialize with 0

        // Function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        clrButton = new JButton("C"); // Clear button

        // Assign function buttons to array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;
        functionButtons[5] = clrButton;

        // Style function buttons
        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // Style number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Panel layout for number and operation buttons
        panel = new JPanel();
        panel.setBounds(30, 100, 340, 340);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Adding buttons to the panel in order
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(clrButton);
        panel.add(divButton);

        // Adding components to the frame
        frame.add(panel);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                if (textfield.getText().equals("0")) { // Clear if the initial value is 0
                    textfield.setText("");
                    currentExpression.setLength(0); // Reset the expression
                }
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
                currentExpression.append(i); // Append the number to the current expression
            }
        }

        if (e.getSource() == addButton) {
            handleOperator('+');
        } else if (e.getSource() == subButton) {
            handleOperator('-');
        } else if (e.getSource() == mulButton) {
            handleOperator('*');
        } else if (e.getSource() == divButton) {
            handleOperator('/');
        }

        if (e.getSource() == equButton) {
            try {
                double result = evaluateExpression(currentExpression.toString());
                textfield.setText(String.valueOf(result));
                currentExpression.setLength(0); // Reset expression after showing the result
                currentExpression.append(result); // Store the result for the next calculation
            } catch (Exception ex) {
                textfield.setText("Error");
                currentExpression.setLength(0); // Reset the expression on error
            }
        }

        if (e.getSource() == clrButton) {
            textfield.setText("0");
            currentExpression.setLength(0); // Clear the expression
        }
    }

    private void handleOperator(char operator) {
        if (currentExpression.length() > 0 && !isOperator(currentExpression.charAt(currentExpression.length() - 1))) {
            textfield.setText(textfield.getText() + operator);
            currentExpression.append(operator); // Append operator to the expression
        }
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private double evaluateExpression(String expression) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ')
                    nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expression.length())
                    throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+'))
                        x += parseTerm(); // Addition
                    else if (eat('-'))
                        x -= parseTerm(); // Subtraction
                    else
                        return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*'))
                        x *= parseFactor(); // Multiplication
                    else if (eat('/'))
                        x /= parseFactor(); // Division
                    else
                        return x;
                }
            }

            double parseFactor() {
                if (eat('+'))
                    return parseFactor(); // Unary plus
                if (eat('-'))
                    return -parseFactor(); // Unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // Parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // Numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.')
                        nextChar();
                    x = Double.parseDouble(expression.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                return x;
            }
        }.parse();
    }
}
