import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TodoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do App");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField taskField = new JTextField();
        JButton addButton = new JButton("Add Task");
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        JButton deleteButton = new JButton("Delete Task");

        // Add task
        addButton.addActionListener(e -> {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        });

        // Delete task
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
            }
        });

        frame.setLayout(new BorderLayout());
        frame.add(taskField, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.add(addButton);
        panel.add(deleteButton);

        frame.add(panel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}