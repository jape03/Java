import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    // GUI components
    private JFrame frameCalculator;
    private JTextField fieldDisplay;
    private JButton[] buttonsDigits = new JButton[10];
    private JButton buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEquals, buttonClear;
    private JPanel panelButtons;
    private Font fontDisplay = new Font("Arial", Font.BOLD, 24);
    private StringBuilder expressionInput = new StringBuilder();

    // Color scheme for the calculator
    private Color backgroundColor = new Color(30, 30, 30);
    private Color buttonColor = new Color(60, 60, 60);
    private Color equalsButtonColor = new Color(0, 122, 204);
    private Color textColor = Color.WHITE;

    public Calculator() {
        // Initialize components and show the frame
        initializeFrame();
        initializeDisplay();
        initializeButtons();
        initializePanel();

        frameCalculator.setVisible(true); //
    }

    // Initialize the main frame
    private void initializeFrame() {
        frameCalculator = new JFrame("Calculator");
        frameCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCalculator.setSize(400, 550);
        frameCalculator.setLayout(null);
        frameCalculator.getContentPane().setBackground(backgroundColor);
    }

    // Initialize the display field
    private void initializeDisplay() {
        fieldDisplay = new JTextField("0");
        fieldDisplay.setBounds(30, 25, 340, 50);
        fieldDisplay.setFont(fontDisplay);
        fieldDisplay.setEditable(false);
        fieldDisplay.setHorizontalAlignment(JTextField.RIGHT);
        fieldDisplay.setBackground(Color.WHITE);
        fieldDisplay.setForeground(Color.BLACK);
        fieldDisplay.setBorder(BorderFactory.createEmptyBorder());
        frameCalculator.add(fieldDisplay);
    }

    // Initialize all buttons (digits and operations)
    private void initializeButtons() {
        // Create operation buttons
        buttonAdd = createButton("+");
        buttonSubtract = createButton("-");
        buttonMultiply = createButton("*");
        buttonDivide = createButton("/");
        buttonEquals = createButton("=");
        buttonClear = createButton("C");
        buttonEquals.setBackground(equalsButtonColor);

        // Create digit buttons (0-9)
        for (int i = 0; i < 10; i++) {
            buttonsDigits[i] = createButton(String.valueOf(i));
        }
    }

    // Initialize the panel to hold all buttons
    private void initializePanel() {
        panelButtons = new JPanel();
        panelButtons.setBounds(30, 100, 340, 340);
        panelButtons.setLayout(new GridLayout(4, 4, 10, 10));
        panelButtons.setBackground(backgroundColor);

        // Add buttons to the panel in order
        panelButtons.add(buttonsDigits[1]);
        panelButtons.add(buttonsDigits[2]);
        panelButtons.add(buttonsDigits[3]);
        panelButtons.add(buttonAdd);
        panelButtons.add(buttonsDigits[4]);
        panelButtons.add(buttonsDigits[5]);
        panelButtons.add(buttonsDigits[6]);
        panelButtons.add(buttonSubtract);
        panelButtons.add(buttonsDigits[7]);
        panelButtons.add(buttonsDigits[8]);
        panelButtons.add(buttonsDigits[9]);
        panelButtons.add(buttonMultiply);
        panelButtons.add(buttonsDigits[0]);
        panelButtons.add(buttonEquals);
        panelButtons.add(buttonClear);
        panelButtons.add(buttonDivide);

        frameCalculator.add(panelButtons);
    }

    // Helper method to create a button with specified text and styling
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(fontDisplay);
        button.setFocusable(false);
        button.setBackground(buttonColor);
        button.setForeground(textColor);
        button.setBorder(BorderFactory.createLineBorder(buttonColor));
        button.addActionListener(this);
        return button;
    }

    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if a digit button was clicked
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == buttonsDigits[i]) {
                appendDigit(i);
                return;
            }
        }

        // Check if an operator button was clicked
        if (e.getSource() == buttonAdd) {
            appendOperator('+');
        } else if (e.getSource() == buttonSubtract) {
            appendOperator('-');
        } else if (e.getSource() == buttonMultiply) {
            appendOperator('*');
        } else if (e.getSource() == buttonDivide) {
            appendOperator('/');
        } else if (e.getSource() == buttonEquals) {
            calculateResult();
        } else if (e.getSource() == buttonClear) {
            clearDisplay();
        }
    }

    // Append a digit to the current input
    private void appendDigit(int digit) {
        if (fieldDisplay.getText().equals("0")) {
            fieldDisplay.setText("");
            expressionInput.setLength(0);
        }
        fieldDisplay.setText(fieldDisplay.getText() + digit);
        expressionInput.append(digit);
    }

    // Append an operator to the current input
    private void appendOperator(char operator) {
        // Check if there is any input
        if (expressionInput.length() > 0) {
            // Check if the last character is not an operator
            if (!isOperator(expressionInput.charAt(expressionInput.length() - 1))) {
                // Append the operator to the display and the input
                fieldDisplay.setText(fieldDisplay.getText() + operator);
                expressionInput.append(operator);
            }
        }
    }

    // Check if a character is an operator
    private boolean isOperator(char character) {
        return character == '+' || character == '-' || character == '*' || character == '/';
    }

    // Calculate the result of the current expression
    private void calculateResult() {
        try {
            double result = evaluateExpression(expressionInput.toString());
            fieldDisplay.setText(formatResult(result));
            expressionInput.setLength(0);
            expressionInput.append(result);
        } catch (Exception ex) {
            fieldDisplay.setText("Error");
            expressionInput.setLength(0);
        }
    }

    // Clear the display and reset the expression
    private void clearDisplay() {
        fieldDisplay.setText("0");
        expressionInput.setLength(0);
    }

    // Evaluate a mathematical expression represented as a string
    private double evaluateExpression(String expression) {
        return new Object() {
            int index = -1, currentCharacter;

            void nextCharacter() {
                index++;
                if (index < expression.length()) {
                    currentCharacter = expression.charAt(index);
                } else {
                    currentCharacter = -1;
                }
            }

            boolean consume(int characterToEat) {
                while (currentCharacter == ' ')
                    nextCharacter();
                if (currentCharacter == characterToEat) {
                    nextCharacter();
                    return true;
                }
                return false;
            }

            double parse() { // Main parse method to evaluate the expression
                nextCharacter();
                double value = parseExpression();
                if (index < expression.length())
                    throw new RuntimeException("Unexpected: " + (char) currentCharacter);
                return value;
            }

            double parseExpression() {
                double value = parseTerm();
                while (true) {
                    if (consume('+'))
                        value += parseTerm();
                    else if (consume('-'))
                        value -= parseTerm();
                    else
                        break;
                }
                return value;
            }

            double parseTerm() {
                double value = parseFactor();
                while (true) {
                    if (consume('*'))
                        value *= parseFactor();
                    else if (consume('/'))
                        value /= parseFactor();
                    else
                        break;
                }
                return value;
            }

            double parseFactor() { // Handle numbers and parentheses
                if (consume('+'))
                    return parseFactor();
                if (consume('-'))
                    return -parseFactor();

                double value;
                int startIndex = this.index;
                if (consume('(')) {
                    value = parseExpression();
                    consume(')');
                } else if ((currentCharacter >= '0' && currentCharacter <= '9') || currentCharacter == '.') {
                    while ((currentCharacter >= '0' && currentCharacter <= '9') || currentCharacter == '.')
                        nextCharacter();
                    value = Double.parseDouble(expression.substring(startIndex, this.index));
                } else {
                    throw new RuntimeException("Unexpected: " + (char) currentCharacter);

                }
                return value;
            }
        }.parse();
    }

    // Format the result for display, removing decimal if it's a whole number
    private String formatResult(double result) {
        if (result == (int) result) {
            return String.valueOf((int) result);
        } else {
            return String.valueOf(result);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
