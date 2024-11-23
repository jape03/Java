import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.geom.RoundRectangle2D;

public class GradingSystem_T5 extends JFrame implements ActionListener {
    private JPanel contentPanel;
    private JScrollPane scrollPane;
    private JLabel titleLabel, lectureLabel, finalLabel, classStandingLabel, longquizLabel, longquizLabel_1,
            longquizLabel_2, longquizLabel_3, LQAverageLabel,
            teacherEvalLabel, classParticipationLabel, classParticipationAverageLabel, seatworkLabel, assignmentLabel,
            shortquizLabel, recitationLabel, labActLabel,
            LabExLabel, machineProbLabel, practicalLabel, projectLabel, labActAverageLabel, midtermExamLabel,
            finalExamLabel;

    private JButton computeButton, clearButton, exitButton;

    private JTextField longquizField_1, longquizTotal_1, longquizField_2, longquizTotal_2, longquizField_3,
            longquizTotal_3, LQAverageField, teacherEvalField, teacherEvalTotalField,
            seatworkField, seatworkTotalField, assignmentField, assignmentTotalField, shortquizField,
            shortquizTotalField, recitationField, recitationTotalField,
            classParticipationAverageField, LabExField, machineProbField, practicalField, projectField,
            labActAverageField, midtermExamField, midtermExamTotalField, finalExamField, finalExamTotalField;

    private Font titleFont = new Font("Poppins", Font.BOLD, 20);
    private Font headerFont = new Font("Poppins", Font.BOLD, 12);
    private Font mainFont = new Font("Poppins", Font.PLAIN, 12);

    public GradingSystem_T5() {
        // Main window title
        setTitle("GradingSystem");
        setLocation(500, 100);
        setSize(410, 710);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Main content panel
        contentPanel = new JPanel();
        contentPanel.setLayout(null);
        contentPanel.setPreferredSize(new Dimension(345, 1000));

        titleLabel = new JLabel("Grading System");
        titleLabel.setFont(titleFont);
        titleLabel.setBounds(115, 8, 240, 30);
        contentPanel.add(titleLabel);

        lectureLabel = new JLabel("LECTURE (100%)");
        lectureLabel.setFont(headerFont);
        lectureLabel.setBounds(20, 40, 240, 30);
        contentPanel.add(lectureLabel);

        finalLabel = new JLabel("Final");
        finalLabel.setFont(headerFont);
        finalLabel.setBounds(20, 60, 240, 30);
        contentPanel.add(finalLabel);

        classStandingLabel = new JLabel("Class Standing (60%)");
        classStandingLabel.setFont(headerFont);
        classStandingLabel.setBounds(20, 80, 240, 30);
        contentPanel.add(classStandingLabel);

        longquizLabel = new JLabel("Long Quizzes (30%)");
        longquizLabel.setFont(headerFont);
        longquizLabel.setBounds(20, 100, 150, 30);
        contentPanel.add(longquizLabel);

        longquizLabel_1 = new JLabel("Long Quiz 1:");
        longquizLabel_1.setFont(mainFont);
        longquizLabel_1.setBounds(40, 130, 100, 30);
        contentPanel.add(longquizLabel_1);

        longquizField_1 = new TransparentTextField();
        longquizField_1.setFont(headerFont);
        longquizField_1.setHorizontalAlignment(JTextField.CENTER);
        longquizField_1.setBounds(240, 125, 50, 30);
        contentPanel.add(longquizField_1);

        JLabel slashLabel1 = createSlashLabel(294, 130);
        contentPanel.add(slashLabel1);

        longquizTotal_1 = new TransparentTextField();
        longquizTotal_1.setFont(headerFont);
        longquizTotal_1.setHorizontalAlignment(JTextField.CENTER);
        longquizTotal_1.setBounds(300, 125, 50, 30);
        contentPanel.add(longquizTotal_1);

        longquizLabel_2 = new JLabel("Long Quiz 2:");
        longquizLabel_2.setFont(mainFont);
        longquizLabel_2.setBounds(40, 170, 100, 30);
        contentPanel.add(longquizLabel_2);

        longquizField_2 = new TransparentTextField();
        longquizField_2.setFont(headerFont);
        longquizField_2.setHorizontalAlignment(JTextField.CENTER);
        longquizField_2.setBounds(240, 165, 50, 30);
        contentPanel.add(longquizField_2);

        JLabel slashLabel2 = createSlashLabel(294, 170);
        contentPanel.add(slashLabel2);

        longquizTotal_2 = new TransparentTextField();
        longquizTotal_2.setFont(headerFont);
        longquizTotal_2.setHorizontalAlignment(JTextField.CENTER);
        longquizTotal_2.setBounds(300, 165, 50, 30);
        contentPanel.add(longquizTotal_2);

        longquizLabel_3 = new JLabel("Long Quiz 3:");
        longquizLabel_3.setFont(mainFont);
        longquizLabel_3.setBounds(40, 210, 100, 30);
        contentPanel.add(longquizLabel_3);

        longquizField_3 = new TransparentTextField();
        longquizField_3.setFont(headerFont);
        longquizField_3.setHorizontalAlignment(JTextField.CENTER);
        longquizField_3.setBounds(240, 205, 50, 30);
        contentPanel.add(longquizField_3);

        JLabel slashLabel3 = createSlashLabel(294, 210);
        contentPanel.add(slashLabel3);

        longquizTotal_3 = new TransparentTextField();
        longquizTotal_3.setFont(headerFont);
        longquizTotal_3.setHorizontalAlignment(JTextField.CENTER);
        longquizTotal_3.setBounds(300, 205, 50, 30);
        contentPanel.add(longquizTotal_3);

        LQAverageLabel = new JLabel("Long Quiz Average:");
        LQAverageLabel.setFont(mainFont);
        LQAverageLabel.setBounds(40, 250, 240, 30);
        contentPanel.add(LQAverageLabel);

        LQAverageField = new TransparentTextField();
        LQAverageField.setFont(headerFont);
        LQAverageField.setHorizontalAlignment(JTextField.CENTER);
        LQAverageField.setBounds(240, 245, 110, 30);
        LQAverageField.setEditable(false);
        contentPanel.add(LQAverageField);

        teacherEvalLabel = new JLabel("Teacher Evaluation (5%):");
        teacherEvalLabel.setFont(headerFont);
        teacherEvalLabel.setBounds(20, 290, 240, 30);
        contentPanel.add(teacherEvalLabel);

        teacherEvalField = new TransparentTextField();
        teacherEvalField.setFont(headerFont);
        teacherEvalField.setHorizontalAlignment(JTextField.CENTER);
        teacherEvalField.setBounds(240, 285, 50, 30);
        contentPanel.add(teacherEvalField);

        JLabel slashLabel4 = createSlashLabel(294, 290);
        contentPanel.add(slashLabel4);

        teacherEvalTotalField = new TransparentTextField();
        teacherEvalTotalField.setFont(headerFont);
        teacherEvalTotalField.setHorizontalAlignment(JTextField.CENTER);
        teacherEvalTotalField.setBounds(300, 285, 50, 30);
        contentPanel.add(teacherEvalTotalField);

        classParticipationLabel = new JLabel("Class Participation (15%):");
        classParticipationLabel.setFont(headerFont);
        classParticipationLabel.setBounds(20, 320, 240, 30);
        contentPanel.add(classParticipationLabel);

        seatworkLabel = new JLabel("Seatwork:");
        seatworkLabel.setFont(mainFont);
        seatworkLabel.setBounds(40, 350, 100, 30);
        contentPanel.add(seatworkLabel);

        seatworkField = new TransparentTextField();
        seatworkField.setFont(headerFont);
        seatworkField.setHorizontalAlignment(JTextField.CENTER);
        seatworkField.setBounds(240, 345, 50, 30);
        contentPanel.add(seatworkField);

        JLabel slashLabel5 = createSlashLabel(294, 350);
        contentPanel.add(slashLabel5);

        seatworkTotalField = new TransparentTextField();
        seatworkTotalField.setFont(headerFont);
        seatworkTotalField.setHorizontalAlignment(JTextField.CENTER);
        seatworkTotalField.setBounds(300, 345, 50, 30);
        contentPanel.add(seatworkTotalField);

        assignmentLabel = new JLabel("Assignment:");
        assignmentLabel.setFont(mainFont);
        assignmentLabel.setBounds(40, 390, 100, 30);
        contentPanel.add(assignmentLabel);

        assignmentField = new TransparentTextField();
        assignmentField.setFont(headerFont);
        assignmentField.setHorizontalAlignment(JTextField.CENTER);
        assignmentField.setBounds(240, 385, 50, 30);
        contentPanel.add(assignmentField);

        JLabel slashLabel6 = createSlashLabel(294, 390);
        contentPanel.add(slashLabel6);

        assignmentTotalField = new TransparentTextField();
        assignmentTotalField.setFont(headerFont);
        assignmentTotalField.setHorizontalAlignment(JTextField.CENTER);
        assignmentTotalField.setBounds(300, 385, 50, 30);
        contentPanel.add(assignmentTotalField);

        shortquizLabel = new JLabel("Short Quiz:");
        shortquizLabel.setFont(mainFont);
        shortquizLabel.setBounds(40, 430, 100, 30);
        contentPanel.add(shortquizLabel);

        shortquizField = new TransparentTextField();
        shortquizField.setFont(headerFont);
        shortquizField.setHorizontalAlignment(JTextField.CENTER);
        shortquizField.setBounds(240, 425, 50, 30);
        contentPanel.add(shortquizField);

        JLabel slashLabel7 = createSlashLabel(294, 430);
        contentPanel.add(slashLabel7);

        shortquizTotalField = new TransparentTextField();
        shortquizTotalField.setFont(headerFont);
        shortquizTotalField.setHorizontalAlignment(JTextField.CENTER);
        shortquizTotalField.setBounds(300, 425, 50, 30);
        contentPanel.add(shortquizTotalField);

        recitationLabel = new JLabel("Recitation:");
        recitationLabel.setFont(mainFont);
        recitationLabel.setBounds(40, 470, 100, 30);
        contentPanel.add(recitationLabel);

        recitationField = new TransparentTextField();
        recitationField.setFont(headerFont);
        recitationField.setHorizontalAlignment(JTextField.CENTER);
        recitationField.setBounds(240, 465, 50, 30);
        contentPanel.add(recitationField);

        JLabel slashLabel8 = createSlashLabel(294, 470);
        contentPanel.add(slashLabel8);

        recitationTotalField = new TransparentTextField();
        recitationTotalField.setFont(headerFont);
        recitationTotalField.setHorizontalAlignment(JTextField.CENTER);
        recitationTotalField.setBounds(300, 465, 50, 30);
        contentPanel.add(recitationTotalField);

        classParticipationAverageLabel = new JLabel("Class Participation Average:");
        classParticipationAverageLabel.setFont(mainFont);
        classParticipationAverageLabel.setBounds(40, 510, 240, 30);
        contentPanel.add(classParticipationAverageLabel);

        classParticipationAverageField = new TransparentTextField();
        classParticipationAverageField.setFont(headerFont);
        classParticipationAverageField.setHorizontalAlignment(JTextField.CENTER);
        classParticipationAverageField.setBounds(240, 505, 110, 30);
        classParticipationAverageField.setEditable(false);
        contentPanel.add(classParticipationAverageField);

        labActLabel = new JLabel("Lab Activities (50%):");
        labActLabel.setFont(headerFont);
        labActLabel.setBounds(20, 540, 240, 30);
        contentPanel.add(labActLabel);

        LabExLabel = new JLabel("Lab Exercises (10%):");
        LabExLabel.setFont(mainFont);
        LabExLabel.setBounds(40, 570, 150, 30);
        contentPanel.add(LabExLabel);

        LabExField = new TransparentTextField();
        LabExField.setFont(headerFont);
        LabExField.setHorizontalAlignment(JTextField.CENTER);
        LabExField.setBounds(240, 565, 110, 30);
        contentPanel.add(LabExField);

        machineProbLabel = new JLabel("Machine Problems (20%):");
        machineProbLabel.setFont(mainFont);
        machineProbLabel.setBounds(40, 610, 150, 30);
        contentPanel.add(machineProbLabel);

        machineProbField = new TransparentTextField();
        machineProbField.setFont(headerFont);
        machineProbField.setHorizontalAlignment(JTextField.CENTER);
        machineProbField.setBounds(240, 605, 110, 30);
        contentPanel.add(machineProbField);

        practicalLabel = new JLabel("Practical (20%):");
        practicalLabel.setFont(mainFont);
        practicalLabel.setBounds(40, 650, 150, 30);
        contentPanel.add(practicalLabel);

        practicalField = new TransparentTextField();
        practicalField.setFont(headerFont);
        practicalField.setHorizontalAlignment(JTextField.CENTER);
        practicalField.setBounds(240, 645, 110, 30);
        contentPanel.add(practicalField);

        projectLabel = new JLabel("Project (50%):");
        projectLabel.setFont(mainFont);
        projectLabel.setBounds(40, 690, 150, 30);
        contentPanel.add(projectLabel);

        projectField = new TransparentTextField();
        projectField.setFont(headerFont);
        projectField.setHorizontalAlignment(JTextField.CENTER);
        projectField.setBounds(240, 685, 110, 30);
        contentPanel.add(projectField);

        labActAverageLabel = new JLabel("Lab Activities Average:");
        labActAverageLabel.setFont(headerFont);
        labActAverageLabel.setBounds(20, 730, 240, 30);
        contentPanel.add(labActAverageLabel);

        labActAverageField = new TransparentTextField();
        labActAverageField.setFont(headerFont);
        labActAverageField.setHorizontalAlignment(JTextField.CENTER);
        labActAverageField.setBounds(240, 725, 110, 30);
        labActAverageField.setEditable(false);
        contentPanel.add(labActAverageField);

        midtermExamLabel = new JLabel("Midterm Exam (30%):");
        midtermExamLabel.setFont(headerFont);
        midtermExamLabel.setBounds(20, 770, 240, 30);
        contentPanel.add(midtermExamLabel);

        midtermExamField = new TransparentTextField();
        midtermExamField.setFont(headerFont);
        midtermExamField.setHorizontalAlignment(JTextField.CENTER);
        midtermExamField.setBounds(240, 765, 50, 30);
        contentPanel.add(midtermExamField);

        JLabel slashLabel9 = createSlashLabel(294, 770);
        contentPanel.add(slashLabel9);

        midtermExamTotalField = new TransparentTextField();
        midtermExamTotalField.setFont(headerFont);
        midtermExamTotalField.setHorizontalAlignment(JTextField.CENTER);
        midtermExamTotalField.setBounds(300, 765, 50, 30);
        contentPanel.add(midtermExamTotalField);

        finalExamLabel = new JLabel("Final Exam (40%):");
        finalExamLabel.setFont(headerFont);
        finalExamLabel.setBounds(20, 810, 240, 30);
        contentPanel.add(finalExamLabel);

        finalExamField = new TransparentTextField();
        finalExamField.setFont(headerFont);
        finalExamField.setHorizontalAlignment(JTextField.CENTER);
        finalExamField.setBounds(240, 805, 50, 30);
        contentPanel.add(finalExamField);

        JLabel slashLabel10 = createSlashLabel(294, 810);
        contentPanel.add(slashLabel10);

        finalExamTotalField = new TransparentTextField();
        finalExamTotalField.setFont(headerFont);
        finalExamTotalField.setHorizontalAlignment(JTextField.CENTER);
        finalExamTotalField.setBounds(300, 805, 50, 30);
        contentPanel.add(finalExamTotalField);

        // Buttons
        computeButton = new RoundButton("Compute");
        computeButton.setFont(headerFont);
        computeButton.setBackground(Color.DARK_GRAY);
        computeButton.setForeground(Color.WHITE);
        computeButton.setBounds(20, 855, 95, 30);
        computeButton.addActionListener(this);
        contentPanel.add(computeButton);

        clearButton = new RoundButton("Clear");
        clearButton.setFont(headerFont);
        clearButton.setBackground(Color.DARK_GRAY);
        clearButton.setForeground(Color.WHITE);
        clearButton.setBounds(140, 855, 95, 30);
        clearButton.addActionListener(this);
        contentPanel.add(clearButton);

        exitButton = new RoundButton("Exit");
        exitButton.setFont(headerFont);
        exitButton.setBackground(Color.DARK_GRAY);
        exitButton.setForeground(Color.WHITE);
        exitButton.setBounds(260, 855, 95, 30);
        exitButton.addActionListener(this);
        contentPanel.add(exitButton);

        int contentHeight = 900;

        contentPanel.setPreferredSize(new Dimension(355, contentHeight));

        scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.getVerticalScrollBar().setBlockIncrement(100);
        getContentPane().add(scrollPane);
    }

    private JLabel createSlashLabel(int x, int y) {
        JLabel slashLabel = new JLabel("/");
        slashLabel.setFont(new Font("Poppins", Font.BOLD, 21));
        slashLabel.setBounds(x, y, 30, 30);
        slashLabel.setForeground(Color.GRAY);
        return slashLabel;
    }

    // Transparent Text Field
    class TransparentTextField extends JTextField {
        private Color underlineColor = Color.GRAY;
        private int underlineThickness = 3;

        public TransparentTextField() {
            setOpaque(false);
            setBorder(null);
            setMargin(new Insets(0, 0, 0, 0));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int height = getHeight();
            g2.setColor(underlineColor);
            g2.setStroke(new BasicStroke(underlineThickness));
            g2.drawLine(0, height - 1, getWidth(), height - 1);
        }

    }

    public class RoundButton extends JButton {
        private int cornerRadius = 10;

        public RoundButton(String label) {
            super(label);
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setOpaque(false);
            setFont(new Font("Poppins", Font.PLAIN, 12));
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (getModel().isPressed()) {
                g.setColor(Color.GRAY);
            } else {
                g.setColor(getBackground());
            }
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == computeButton) {
            try {
                if (areFieldsEmpty()) {
                    JOptionPane.showMessageDialog(this, "All fields must be filled.", "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Long quiz inputs validation

                double lq1 = validateAndParseInput(longquizField_1.getText(), "Long Quiz 1", 100,
                        Double.parseDouble(longquizTotal_1.getText()));
                double lq2 = validateAndParseInput(longquizField_2.getText(), "Long Quiz 2", 100,
                        Double.parseDouble(longquizTotal_2.getText()));
                double lq3 = validateAndParseInput(longquizField_3.getText(), "Long Quiz 3", 100,
                        Double.parseDouble(longquizTotal_3.getText()));
                double lqscoretotal = lq1 + lq2 + lq3;

                double lqTotal1 = Double.parseDouble(longquizTotal_1.getText());
                double lqTotal2 = Double.parseDouble(longquizTotal_2.getText());
                double lqTotal3 = Double.parseDouble(longquizTotal_3.getText());
                double lqtotal = lqTotal1 + lqTotal2 + lqTotal3;

                // Calculate long quiz average
                double longQuizAverage = ((lqscoretotal / lqtotal) * 100) * 0.18;
                LQAverageField.setText(String.format("%.2f", longQuizAverage));

                // Teacher evaluation inputs validation
                double teacherEvalTotal = validateAndParseInput(teacherEvalTotalField.getText(),
                        "Teacher Evaluation Total", 100, 100); // Validate total score
                double teacherEvalScore = validateAndParseInput(teacherEvalField.getText(), "Teacher Evaluation Score",
                        100, teacherEvalTotal);
                double teacherEval = (teacherEvalScore / teacherEvalTotal) * 100 * 0.03;

                // Class participation inputs validation
                double seatworkTotal = validateAndParseInput(seatworkTotalField.getText(), "Seatwork Total", 100, 100); // Validate
                                                                                                                        // total
                                                                                                                        // score
                double seatwork = validateAndParseInput(seatworkField.getText(), "Seatwork", 100, seatworkTotal);
                double assignmentTotal = validateAndParseInput(assignmentTotalField.getText(), "Assignment Total", 100,
                        100); // Validate total score
                double assignment = validateAndParseInput(assignmentField.getText(), "Assignment", 100,
                        assignmentTotal);
                double shortQuizTotal = validateAndParseInput(shortquizTotalField.getText(), "Short Quiz Total", 100,
                        100); // Validate total score
                double shortQuiz = validateAndParseInput(shortquizField.getText(), "Short Quiz", 100, shortQuizTotal);
                double recitationTotal = validateAndParseInput(recitationTotalField.getText(), "Recitation Total", 100,
                        100); // Validate total score
                double recitation = validateAndParseInput(recitationField.getText(), "Recitation", 100,
                        recitationTotal);

                double classParticipationScoreTotal = seatwork + assignment + shortQuiz + recitation;
                double classParticipationTotalPoints = seatworkTotal + assignmentTotal + shortQuizTotal
                        + recitationTotal;
                double classParticipationAverage = ((classParticipationScoreTotal / classParticipationTotalPoints)
                        * 100) * 0.09;
                classParticipationAverageField.setText(String.format("%.2f", classParticipationAverage));

                // Lab activity inputs validation
                double labEx = validateAndParseInput(LabExField.getText(), "Lab Exercise", 100, 100);
                double machineProblems = validateAndParseInput(machineProbField.getText(), "Machine Problems", 100,
                        100);
                double practical = validateAndParseInput(practicalField.getText(), "Practical", 100, 100);
                double project = validateAndParseInput(projectField.getText(), "Project", 100, 100);

                double labActAverage = (((labEx + machineProblems + practical + project) / 400) * 100) * 0.30;
                labActAverageField.setText(String.format("%.2f", labActAverage));

                // Midterm and final exam inputs validation
                double midtermExamTotal = validateAndParseInput(midtermExamTotalField.getText(), "Midterm Exam Total",
                        100, 100); // Validate total score
                double midtermExam = validateAndParseInput(midtermExamField.getText(), "Midterm Exam", 100,
                        midtermExamTotal);
                double midtermExamAverage = (midtermExam / midtermExamTotal) * 100 * 0.15;

                double finalExamTotal = validateAndParseInput(finalExamTotalField.getText(), "Final Exam Total", 100,
                        100); // Validate total score
                double finalExam = validateAndParseInput(finalExamField.getText(), "Final Exam", 100, finalExamTotal);
                double finalExamAverage = (finalExam / finalExamTotal) * 100 * 0.25;

                // Final grade calculation
                double finalGrade = longQuizAverage + teacherEval + classParticipationAverage + labActAverage
                        + midtermExamAverage + finalExamAverage;

                double equivalentGrade = calculateEquivalentGrade(finalGrade);

                // Determine the remark
                String remark = getGeneralRemark(equivalentGrade);

                // Display final grade and remark
                JOptionPane.showMessageDialog(this, "Final Grade: " + String.format("%.2f", finalGrade)
                        + "\nGrade Equivalent: " + String.format("%.1f", equivalentGrade)
                        + "\nRemark: " + remark);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getSource() == clearButton) {
            clearAllFields();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    private boolean areFieldsEmpty() {
        return longquizField_1.getText().isEmpty() || longquizField_2.getText().isEmpty() ||
                longquizField_3.getText().isEmpty() || longquizTotal_1.getText().isEmpty() ||
                longquizTotal_2.getText().isEmpty() || longquizTotal_3.getText().isEmpty() ||
                teacherEvalField.getText().isEmpty() || teacherEvalTotalField.getText().isEmpty() ||
                seatworkField.getText().isEmpty() || seatworkTotalField.getText().isEmpty() ||
                assignmentField.getText().isEmpty() || assignmentTotalField.getText().isEmpty() ||
                shortquizField.getText().isEmpty() || shortquizTotalField.getText().isEmpty() ||
                recitationField.getText().isEmpty() || recitationTotalField.getText().isEmpty() ||
                LabExField.getText().isEmpty() || machineProbField.getText().isEmpty() ||
                practicalField.getText().isEmpty() || projectField.getText().isEmpty() ||
                midtermExamField.getText().isEmpty() || midtermExamTotalField.getText().isEmpty() ||
                finalExamField.getText().isEmpty() || finalExamTotalField.getText().isEmpty();
    }

    private double validateAndParseInput(String input, String fieldName, double maxValue, double totalScore)
            throws NumberFormatException {
        double value = Double.parseDouble(input);
        if (value < 0 || value > maxValue) {
            throw new NumberFormatException("Invalid value for " + fieldName + ". Must be between 0 and " + maxValue);
        }
        if (totalScore > maxValue) {
            throw new NumberFormatException(
                    "Invalid total score for " + fieldName + ". Total score must not exceed " + maxValue);
        }
        if (value > totalScore) {
            throw new NumberFormatException(
                    "Invalid value for " + fieldName + ". Score cannot exceed the total score.");
        }
        return value;
    }

    // calculate the equivalent grade
    private double calculateEquivalentGrade(double finalGrade) {
        if (finalGrade >= 97)
            return 4.0;
        if (finalGrade >= 93)
            return 3.5;
        if (finalGrade >= 89)
            return 3.0;
        if (finalGrade >= 85)
            return 2.5;
        if (finalGrade >= 80)
            return 2.0;
        if (finalGrade >= 75)
            return 1.5;
        if (finalGrade >= 70)
            return 1.0;
        return 0.5;
    }

    // remarks
    private String getGeneralRemark(double equivalentGrade) {
        if (equivalentGrade >= 1.0 && equivalentGrade <= 4.0) {
            return "Passed";
        } else if (equivalentGrade == 0.5) {
            return "Failed";
        } else {
            return "Invalid";
        }
    }

    // clear all fields
    private void clearAllFields() {
        longquizField_1.setText("");
        longquizField_2.setText("");
        longquizField_3.setText("");
        longquizTotal_1.setText("");
        longquizTotal_2.setText("");
        longquizTotal_3.setText("");
        LQAverageField.setText("");
        teacherEvalField.setText("");
        teacherEvalTotalField.setText("");
        seatworkField.setText("");
        seatworkTotalField.setText("");
        assignmentField.setText("");
        assignmentTotalField.setText("");
        shortquizField.setText("");
        shortquizTotalField.setText("");
        recitationField.setText("");
        recitationTotalField.setText("");
        classParticipationAverageField.setText("");
        LabExField.setText("");
        machineProbField.setText("");
        practicalField.setText("");
        projectField.setText("");
        labActAverageField.setText("");
        midtermExamField.setText("");
        midtermExamTotalField.setText("");
        finalExamField.setText("");
        finalExamTotalField.setText("");
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new GradingSystem_T5().setVisible(true));
    }

}
