import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Layout {
    private JFrame mainFrame;
    private JPanel controlPanel;
    private JTextField ia; //text input field
    private JTextArea oa; //text output area
    private int WIDTH=800;
    private int HEIGHT=700;
//

    public Layout() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Layout layout = new Layout();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Simple Application"); // makes box
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        mainFrame.add(topPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(inputPanel, BorderLayout.NORTH);
        JLabel inputLabel = new JLabel("Input:");
        inputPanel.add(inputLabel);
        ia = new JTextField(50);
        inputPanel.add(ia);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        addButtons();
        topPanel.add(controlPanel, BorderLayout.CENTER);

        oa = new JTextArea();
        oa.setEditable(false);
        Font customFont = new Font("Arial", Font.BOLD, 18);
        oa.setFont(customFont);
        JScrollPane scrollPane = new JScrollPane(oa);
        mainFrame.add(scrollPane, BorderLayout.CENTER);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        mainFrame.setVisible(true);
    }

    private void addButtons() {
        JButton submitButton = new JButton("Submit");
        submitButton.setActionCommand("Submit");
        submitButton.addActionListener(new ButtonClickListener());
        controlPanel.add(submitButton);
        JButton resetButton = new JButton("Reset");
        resetButton.setActionCommand("Reset");
        resetButton.addActionListener(new ButtonClickListener());
        controlPanel.add(resetButton);
        JButton addLineBreakButton = new JButton("Add Line Break");
        addLineBreakButton.setActionCommand("AddLineBreak");
        addLineBreakButton.addActionListener(new ButtonClickListener());
        controlPanel.add(addLineBreakButton);

        mainFrame.setVisible(true);// always have to set mainframe visibility to true when changing something on it
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Submit")) {
                oa.append(ia.getText() + "\n");// googled how to go down to the next line: https://stackoverflow.com/questions/20706206/insert-line-break-in-java
            }
            else if (command.equals("Reset")) {
                ia.setText("");
                oa.setText("");
            }
            else if (command.equals("AddLineBreak")){
                oa.append("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            }

        }
    }
}