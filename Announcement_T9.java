import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Announcement_T9 {

    private final ArrayList<String> announcements = new ArrayList<>();

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> new Announcement_T9().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Announcement");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLayout(new BorderLayout(10, 10));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel typeLabel = new JLabel("Type:");
        JComboBox<String> typeComboBox = new JComboBox<>(new String[] { "Event", "Reminder" });

        JLabel scheduleLabel = new JLabel("Schedule:");
        JPanel schedulePanel = new JPanel(new GridLayout(1, 3));
        JComboBox<String> monthComboBox = new JComboBox<>(new String[] {
                "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December" });
        JComboBox<Integer> dayComboBox = new JComboBox<>();
        JComboBox<Integer> yearComboBox = new JComboBox<>();

        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }
        for (int i = 2020; i <= 2030; i++) {
            yearComboBox.addItem(i);
        }
        schedulePanel.add(monthComboBox);
        schedulePanel.add(dayComboBox);
        schedulePanel.add(yearComboBox);

        JLabel timeLabel = new JLabel("Time:");
        JPanel timePanel = new JPanel(new GridLayout(1, 3));
        JComboBox<Integer> hourComboBox = new JComboBox<>();
        JComboBox<Integer> minuteComboBox = new JComboBox<>();
        JComboBox<Integer> secondComboBox = new JComboBox<>();

        for (int i = 0; i < 24; i++) {
            hourComboBox.addItem(i);
        }
        for (int i = 0; i < 60; i++) {
            minuteComboBox.addItem(i);
            secondComboBox.addItem(i);
        }
        timePanel.add(hourComboBox);
        timePanel.add(minuteComboBox);
        timePanel.add(secondComboBox);

        JLabel priorityLabel = new JLabel("Priority:");
        JComboBox<String> priorityComboBox = new JComboBox<>(new String[] { "High", "Medium", "Low" });

        JLabel titleLabel = new JLabel("Title:");
        JTextField titleField = new JTextField();

        JLabel contentLabel = new JLabel("Content:");
        JTextArea contentArea = new JTextArea(3, 20);
        JScrollPane contentScrollPane = new JScrollPane(contentArea);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton postButton = new JButton("POST");
        JButton clearButton = new JButton("CLEAR");
        JButton closeButton = new JButton("CLOSE");
        JButton viewButton = new JButton("VIEW");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(typeLabel, gbc);
        gbc.gridx = 1;
        panel.add(typeComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(scheduleLabel, gbc);
        gbc.gridx = 1;
        panel.add(schedulePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(timeLabel, gbc);
        gbc.gridx = 1;
        panel.add(timePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(priorityLabel, gbc);
        gbc.gridx = 1;
        panel.add(priorityComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(titleLabel, gbc);
        gbc.gridx = 1;
        panel.add(titleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(contentLabel, gbc);
        gbc.gridx = 1;
        panel.add(contentScrollPane, gbc);

        buttonPanel.add(postButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(closeButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        postButton.addActionListener(e -> {
            String type = (String) typeComboBox.getSelectedItem();
            String priority = (String) priorityComboBox.getSelectedItem();
            String title = titleField.getText();
            String content = contentArea.getText();
            int month = monthComboBox.getSelectedIndex();
            int day = (int) dayComboBox.getSelectedItem();
            int year = (int) yearComboBox.getSelectedItem();
            int hour = (int) hourComboBox.getSelectedItem();
            int minute = (int) minuteComboBox.getSelectedItem();
            int second = (int) secondComboBox.getSelectedItem();

            if (title.isEmpty() || content.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                String dateStr = String.format("%02d/%02d/%04d %02d:%02d:%02d", month + 1, day, year, hour, minute,
                        second);
                Date scheduledDate = sdf.parse(dateStr);

                // Check if the scheduled date and time are valid
                if (scheduledDate.before(new Date())) {
                    JOptionPane.showMessageDialog(frame, "Scheduled time can't be from the past.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                announcements.add("Type: " + type + ", Priority: " + priority +
                        ", Title: " + title + ", Content: " + content +
                        ", Scheduled: " + sdf.format(scheduledDate));

                new Thread(() -> {
                    long delay = scheduledDate.getTime() - System.currentTimeMillis();
                    try {
                        Thread.sleep(delay);
                        SwingUtilities.invokeLater(() -> {
                            JOptionPane.showMessageDialog(frame,
                                    "Announcement!\nType: " + type + "\nPriority: " + priority +
                                            "\nTitle: " + title + "\nContent: " + content,
                                    "Scheduled Announcement",
                                    JOptionPane.INFORMATION_MESSAGE);
                        });
                    } catch (InterruptedException interruptedException) {
                        interruptedException.printStackTrace();
                    }
                }).start();

                JOptionPane.showMessageDialog(frame, "Announcement scheduled successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error scheduling announcement: " + ex.getMessage(), "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        clearButton.addActionListener(e -> {
            typeComboBox.setSelectedIndex(0);
            monthComboBox.setSelectedIndex(0);
            dayComboBox.setSelectedIndex(0);
            yearComboBox.setSelectedIndex(0);
            hourComboBox.setSelectedIndex(0);
            minuteComboBox.setSelectedIndex(0);
            secondComboBox.setSelectedIndex(0);
            priorityComboBox.setSelectedIndex(0);
            titleField.setText("");
            contentArea.setText("");
        });

        viewButton.addActionListener(e -> {
            if (announcements.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No announcements to display.", "View Announcements",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                StringBuilder announcementList = new StringBuilder();
                for (String announcement : announcements) {
                    announcementList.append(announcement).append("\n\n");
                }
                JOptionPane.showMessageDialog(frame, announcementList.toString(),
                        "Announcements", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        closeButton.addActionListener(e -> System.exit(0));

        frame.setVisible(true);
    }
}
