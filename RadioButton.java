import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RadioButton extends JFrame {

    private JRadioButton admin, manager, receptionist, trainer; // Declare radio buttons as instance variables

    public RadioButton() {
        // Set up the frame
        setTitle("Select an Option");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);

        // Set up panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.BLACK);
        add(panel);

        Font font = new Font("Poppins", Font.PLAIN, 16);

        // Headline label
        JLabel headline = new JLabel("Please choose an option:");
        headline.setFont(font);
        headline.setForeground(Color.WHITE);
        headline.setBounds(50, 20, 400, 40);
        panel.add(headline);

        // Set up radio buttons
        int buttonWidth = 200;
        int buttonHeight = 40;
        int panelWidth = getWidth();

        admin = createRadioButton("Admin", font, panel, buttonWidth, buttonHeight, panelWidth, 70);
        manager = createRadioButton("Manager", font, panel, buttonWidth, buttonHeight, panelWidth, 120);
        receptionist = createRadioButton("Receptionist", font, panel, buttonWidth, buttonHeight, panelWidth, 170);
        trainer = createRadioButton("Trainer", font, panel, buttonWidth, buttonHeight, panelWidth, 220);

        ButtonGroup group = new ButtonGroup();
        group.add(admin);
        group.add(manager);
        group.add(receptionist);
        group.add(trainer);

        // Next button
        JButton nextButton = new JButton("Next");
        nextButton.setFont(font);
        nextButton.setBounds((panelWidth - 200) / 2, 300, 200, 50);
        nextButton.setBackground(new Color(0, 255, 200));
        nextButton.setForeground(Color.BLACK);
        nextButton.setActionCommand("Next"); // Set the action command
        nextButton.addActionListener(this);
        panel.add(nextButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JRadioButton createRadioButton(String text, Font font, JPanel panel, int width, int height, int panelWidth, int yPosition) {
        JRadioButton radioButton = new JRadioButton(text);
        radioButton.setFont(font);
        radioButton.setForeground(Color.WHITE);
        radioButton.setBackground(Color.BLACK);
        radioButton.setBounds((panelWidth - width) / 2, yPosition, width, height);
        panel.add(radioButton);
        return radioButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Next")) {
            String role = null; // Variable to store the selected role

            // Check which radio button is selected
            if (admin.isSelected()) {
                role = "Admin";
            } else if (manager.isSelected()) {
                role = "Manager";
            } else if (receptionist.isSelected()) {
                role = "Receptionist";
            } else if (trainer.isSelected()) {
                role = "Trainer";
            }

            // Perform actions based on the selected role
            if (role != null) {
                JOptionPane.showMessageDialog(this, "You selected: " + role, "Role Selected", JOptionPane.INFORMATION_MESSAGE);
                // Optionally, navigate to the next page or perform other actions
                new Login(role); // Example of navigating to the Login page
                dispose(); // Close the current window
            } else {
                // No radio button was selected
                JOptionPane.showMessageDialog(this, "Please select an option first!", "Info", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Handle mouse click events if needed
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        new RadioButton(); // Create the RadioButton JFrame
    }
}
