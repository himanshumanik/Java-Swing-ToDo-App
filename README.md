# Java GUI To-Do List Application

This project is a simple desktop To-Do list application built using **Java Swing**, demonstrating fundamental concepts of Graphical User Interface (GUI) development and event handling.

## Objective

The objective was to create a functional To-Do list where users can perform the essential operations of adding and deleting tasks.

## Deliverables & Components Used

| Component | Java Class | Purpose |
| :--- | :--- | :--- |
| **Main Window** | `JFrame` | The main container for the application. |
| **Task Input** | `JTextField` | Allows the user to type in a new task. |
| **Add Task Button** | `JButton` | Triggers the addition of the task to the list. |
| **Delete Button** | `JButton` | Triggers the removal of the currently selected task. |
| **Task List** | `JList` & `DefaultListModel` | Displays the list of to-do items and manages the underlying data structure. |
| **Scroll Functionality** | `JScrollPane` | Ensures the list remains scrollable when the number of tasks exceeds the window size. |

## Implementation Details

The `ToDoApp` class extends `JFrame` and uses `BorderLayout` for the main window layout.

1.  **`addTask()`:** Fetches text from the `JTextField`, checks if it's empty, and adds it to the `DefaultListModel` which is bound to the `JList`.
2.  **`deleteTask()`:** Retrieves the index of the selected item in the `JList` and uses that index to remove the item from the `DefaultListModel`.
3.  **Event Handling:** `ActionListener` interfaces are implemented directly on the `addButton` and `deleteButton` to link button clicks to the respective methods.
4.  **EDT:** The application is launched using `SwingUtilities.invokeLater()` to ensure thread safety, as all Swing components must be manipulated on the Event Dispatch Thread (EDT).

## Screenshot



## How to Run

1.  Clone the repository: `git clone [YOUR_REPO_LINK]`
2.  Compile the Java file: `javac ToDoApp.java`
3.  Run the application: `java ToDoApp`
