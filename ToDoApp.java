import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoApp extends JFrame {

    // GUI Components
    private JTextField taskInputField;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JButton addButton;
    private JButton deleteButton;

    /**
     * Constructor to set up the GUI
     */
    public ToDoApp() {
        // 1. Setup the main JFrame
        setTitle("Java GUI To-Do List App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLayout(new BorderLayout()); // Use BorderLayout for the main frame
        
        // 2. Initialize Components
        taskInputField = new JTextField(20);
        addButton = new JButton("Add Task");
        deleteButton = new JButton("Delete Selected Task");
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        
        // Use a JScrollPane for the JList to enable scrolling when many items are added
        JScrollPane scrollPane = new JScrollPane(taskList);

        // 3. Create Panels for Layout
        
        // Panel for Input field and Add button (North/Top section)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("New Task:"));
        inputPanel.add(taskInputField);
        inputPanel.add(addButton);
        
        // Panel for the Delete button (South/Bottom section)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(deleteButton);

        // 4. Add Panels to the JFrame
        add(inputPanel, BorderLayout.NORTH);  // Input and Add button at the top
        add(scrollPane, BorderLayout.CENTER); // Task list in the middle
        add(buttonPanel, BorderLayout.SOUTH); // Delete button at the bottom

        // 5. Add Action Listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });
        
        // Make the frame visible
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }
    
    /**
     * Handles adding a new task from the input field to the JList.
     */
    private void addTask() {
        String task = taskInputField.getText().trim();
        if (!task.isEmpty()) {
            listModel.addElement(task);
            taskInputField.setText(""); // Clear the input field
        } else {
            JOptionPane.showMessageDialog(this, 
                                          "Task description cannot be empty.", 
                                          "Input Error", 
                                          JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * Handles deleting the currently selected task from the JList.
     */
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) { // -1 means no item is selected
            listModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, 
                                          "Please select a task to delete.", 
                                          "Selection Error", 
                                          JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Main method to start the application on the Event Dispatch Thread (EDT).
     */
    public static void main(String[] args) {
        // Swing applications must be started on the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoApp();
            }
        });
    }
}
