import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    // GUI components
    private JFrame frameCalculator; // Main frame for the calculator
    private JTextField fieldDisplay; // Display field for showing input and results
    private JButton[] buttonsDigits = new JButton[10]; // Digit buttons (0-9)
    private JButton buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonEquals, buttonClear; // Operation
                                                                                                        // buttons
    private JPanel panelButtons; // Panel to hold buttons
    private Font fontDisplay = new Font("Arial", Font.BOLD, 24); // Font for display and buttons
    private StringBuilder expressionInput = new StringBuilder(); // To store the current expression

    // Color scheme for the calculator
    private Color backgroundColor = new Color(30, 30, 30); // Background color for frame and panel
    private Color buttonColor = new Color(60, 60, 60); // Color for digit and operation buttons
    private Color equalsButtonColor = new Color(0, 122, 204); // Color for equals button
    private Color textColor = Color.WHITE; // Text color for buttons

    public Calculator() {
        // Initialize components and show the frame
        initializeFrame();
        initializeDisplay();
        initializeButtons();
        initializePanel();

        frameCalculator.setVisible(true); // Make the frame visible
    }

    // Initialize the main frame
    private void initializeFrame() {
        frameCalculator = new JFrame("Calculator");
        frameCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameCalculator.setSize(400, 550);
        frameCalculator.setLayout(null); // Use no layout manager
        frameCalculator.getContentPane().setBackground(backgroundColor); // Set background color
    }

    // Initialize the display field
    private void initializeDisplay() {
        fieldDisplay = new JTextField("0"); // Default display value is 0
        fieldDisplay.setBounds(30, 25, 340, 50); // Set position and size
        fieldDisplay.setFont(fontDisplay); // Set font
        fieldDisplay.setEditable(false); // Display is not editable directly
        fieldDisplay.setHorizontalAlignment(JTextField.RIGHT); // Align text to the right
        fieldDisplay.setBackground(Color.WHITE); // Background color of display
        fieldDisplay.setForeground(Color.BLACK); // Text color of display
        fieldDisplay.setBorder(BorderFactory.createEmptyBorder()); // Remove border
        frameCalculator.add(fieldDisplay); // Add display to frame
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
        buttonEquals.setBackground(equalsButtonColor); // Set specific color for equals button

        // Create digit buttons (0-9)
        for (int i = 0; i < 10; i++) {
            buttonsDigits[i] = createButton(String.valueOf(i));
        }
    }

    // Initialize the panel to hold all buttons
    private void initializePanel() {
        panelButtons = new JPanel();
        panelButtons.setBounds(30, 100, 340, 340); // Set position and size of the panel
        panelButtons.setLayout(new GridLayout(4, 4, 10, 10)); // Grid layout for buttons
        panelButtons.setBackground(backgroundColor); // Set panel background color

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

        frameCalculator.add(panelButtons); // Add the panel to the frame
    }

    // Helper method to create a button with specified text and styling
    private JButton createButton(String text) {
        JButton button = new JButton(text); // Create button with text
        button.setFont(fontDisplay); // Set font for button
        button.setFocusable(false); // Remove focus border on click
        button.setBackground(buttonColor); // Set button background color
        button.setForeground(textColor); // Set button text color
        button.setBorder(BorderFactory.createLineBorder(buttonColor)); // Minimalist border
        button.addActionListener(this); // Register this class as the listener for button actions
        return button;
    }

    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if a digit button was clicked
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == buttonsDigits[i]) {
                appendDigit(i); // Append the digit to the current expression
                return; // Exit method after handling digit input
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
            calculateResult(); // Calculate the result of the current expression
        } else if (e.getSource() == buttonClear) {
            clearDisplay(); // Clear the display and reset the expression
        }
    }

    // Append a digit to the current input
    private void appendDigit(int digit) {
        if (fieldDisplay.getText().equals("0")) { // If current display is 0, replace it
            fieldDisplay.setText("");
            expressionInput.setLength(0); // Clear the stored expression
        }
        fieldDisplay.setText(fieldDisplay.getText() + digit); // Update display with new digit
        expressionInput.append(digit); // Append digit to the expression
    }

    // Append an operator to the current input
    private void appendOperator(char operator) {
        // Append operator only if the last character is not already an operator
        if (expressionInput.length() > 0 && !isOperator(expressionInput.charAt(expressionInput.length() - 1))) {
            fieldDisplay.setText(fieldDisplay.getText() + operator); // Update display with operator
            expressionInput.append(operator); // Append operator to the expression
        }
    }

    // Check if a character is an operator
    private boolean isOperator(char character) {
        return character == '+' || character == '-' || character == '*' || character == '/';
    }

    // Calculate the result of the current expression
    private void calculateResult() {
        try {
            double result = evaluateExpression(expressionInput.toString()); // Evaluate the expression
            fieldDisplay.setText(formatResult(result)); // Display formatted result
            expressionInput.setLength(0); // Reset expression after showing the result
            expressionInput.append(result); // Store the result for further calculations
        } catch (Exception ex) {
            fieldDisplay.setText("Error"); // Display error message on exception
            expressionInput.setLength(0); // Clear the expression on error
        }
    }

    // Clear the display and reset the expression
    private void clearDisplay() {
        fieldDisplay.setText("0"); // Reset display to 0
        expressionInput.setLength(0); // Clear the stored expression
    }

    // Evaluate a mathematical expression represented as a string
    private double evaluateExpression(String expression) {
        return new Object() { // Anonymous class for parsing and evaluating the expression
            int index = -1, currentCharacter;

            void nextCharacter() {
                currentCharacter = (++index < expression.length()) ? expression.charAt(index) : -1; // Get next
                                                                                                    // character
            }

            boolean consume(int characterToEat) {
                while (currentCharacter == ' ')
                    nextCharacter(); // Skip spaces
                if (currentCharacter == characterToEat) { // Check if the character matches
                    nextCharacter();
                    return true;
                }
                return false;
            }

            double parse() { // Main parse method to evaluate the expression
                nextCharacter();
                double value = parseExpression(); // Parse the expression recursively
                if (index < expression.length())
                    throw new RuntimeException("Unexpected: " + (char) currentCharacter); // Error if there are
                                                                                          // unexpected characters
                return value;
            }

            double parseExpression() {
                double value = parseTerm();
                for (;;) { // Handle addition and subtraction
                    if (consume('+'))
                        value += parseTerm(); // Addition
                    else if (consume('-'))
                        value -= parseTerm(); // Subtraction
                    else
                        return value; // End of expression
                }
            }

            double parseTerm() {
                double value = parseFactor();
                for (;;) { // Handle multiplication and division
                    if (consume('*'))
                        value *= parseFactor(); // Multiplication
                    else if (consume('/'))
                        value /= parseFactor(); // Division
                    else
                        return value; // End of term
                }
            }

            double parseFactor() { // Handle numbers and parentheses
                if (consume('+'))
                    return parseFactor(); // Unary plus
                if (consume('-'))
                    return -parseFactor(); // Unary minus

                double value;
                int startIndex = this.index;
                if (consume('(')) { // Parentheses
                    value = parseExpression();
                    consume(')');
                } else if ((currentCharacter >= '0' && currentCharacter <= '9') || currentCharacter == '.') { // Numbers
                    while ((currentCharacter >= '0' && currentCharacter <= '9') || currentCharacter == '.')
                        nextCharacter();
                    value = Double.parseDouble(expression.substring(startIndex, this.index)); // Parse number
                } else {
                    throw new RuntimeException("Unexpected: " + (char) currentCharacter); // Error for unexpected
                                                                                          // character
                }
                return value;
            }
        }.parse(); // Start parsing
    }

    // Format the result for display, removing decimal if it's a whole number
    private String formatResult(double result) {
        return (result == (int) result) ? String.valueOf((int) result) : String.valueOf(result);
    }

    // Main method to launch the calculator
    public static void main(String[] args) {
        new Calculator(); // Create a new Calculator instance
    }
}
