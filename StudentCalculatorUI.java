import javax.swing.*;
import java.awt.*;

public class StudentCalculatorUI extends JFrame {

    JTextField nameField;
    JTextField rollField;
    JTextField javaField;
    JTextField dbmsField;
    JTextField pythonField;
    JTextField osField;
    JTextField cnField;
    JLabel resultLabel;
    public StudentCalculatorUI() {

        setTitle("Student Grade Calculator");

        setSize(900,700);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JLabel title =
                new JLabel(
                        "STUDENT GRADE & CGPA CALCULATOR",
                        SwingConstants.CENTER);

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        25));

        add(title, BorderLayout.NORTH);

        JPanel inputPanel =
                new JPanel();

        inputPanel.setLayout(
                new GridLayout(
                        7,
                        2,
                        10,
                        10));

        inputPanel.add(
                new JLabel("Student Name"));

        nameField =
                new JTextField();

        inputPanel.add(nameField);

        inputPanel.add(
                new JLabel("Roll Number"));

        rollField =
                new JTextField();

        inputPanel.add(rollField);
        add(inputPanel, BorderLayout.NORTH);  // Name + Roll

// ✅ CREATE NEW PANEL FOR MARKS
JPanel marksPanel = new JPanel();
marksPanel.setLayout(new GridLayout(5, 2, 10, 10));

// Java
marksPanel.add(new JLabel("Java"));
javaField = new JTextField();
marksPanel.add(javaField);

// DBMS
marksPanel.add(new JLabel("DBMS"));
dbmsField = new JTextField();
marksPanel.add(dbmsField);

// Python
marksPanel.add(new JLabel("Python"));
pythonField = new JTextField();
marksPanel.add(pythonField);

// OS
marksPanel.add(new JLabel("Operating System"));
osField = new JTextField();
marksPanel.add(osField);

// CN
marksPanel.add(new JLabel("Computer Network"));
cnField = new JTextField();
marksPanel.add(cnField);

// ADD MARKS PANEL TO FRAME
add(marksPanel, BorderLayout.CENTER);
resultLabel = new JLabel("Result will appear here");
resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

add(resultLabel, BorderLayout.EAST);

JButton calculateButton = new JButton("Calculate Result");

calculateButton.setFont(new Font("Arial", Font.BOLD, 16));

add(calculateButton, BorderLayout.SOUTH);

// STEP 10
calculateButton.addActionListener(e -> {

    try {
        int java = Integer.parseInt(javaField.getText());
        int dbms = Integer.parseInt(dbmsField.getText());
        int python = Integer.parseInt(pythonField.getText());
        int os = Integer.parseInt(osField.getText());
        int cn = Integer.parseInt(cnField.getText());

        int total = java + dbms + python + os + cn;
        double percentage = total / 5.0;

        double cgpa = percentage / 9.5;

        String grade;
        String status;

        if (percentage >= 90) grade = "A+";
        else if (percentage >= 75) grade = "A";
        else if (percentage >= 60) grade = "B";
        else if (percentage >= 40) grade = "C";
        else grade = "F";

        if (percentage >= 40) status = "PASS 🟢";
        else status = "FAIL 🔴";

        // SHOW IN LABEL (BEST PART OF STEP 13)
        resultLabel.setText(
                "<html>" +
                "Total: " + total + "<br>" +
                "Percentage: " + String.format("%.2f", percentage) + "%<br>" +
                "CGPA: " + String.format("%.2f", cgpa) + "<br>" +
                "Grade: " + grade + "<br>" +
                "Status: " + status +
                "</html>"
        );

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null, "Please enter valid numbers!");
    }
});
setVisible(true);
     
    }
}
        