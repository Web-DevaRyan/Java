import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends JFrame implements ActionListener {
    JTextArea textArea;
    JFileChooser fileChooser;
    JPopupMenu popupMenu;
    JMenuItem cutItem;
    JMenuItem copyItem;
    JMenuItem pasteItem;
    JMenuItem findItem;
    JMenuItem replaceItem;

    public TextEditor() {
        super("Text Editor");

        // Create text area
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane);

        // Create popup menu
        popupMenu = new JPopupMenu();
        cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(this);
        popupMenu.add(cutItem);
        copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(this);
        popupMenu.add(copyItem);
        pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(this);
        popupMenu.add(pasteItem);
        findItem = new JMenuItem("Find");
        findItem.addActionListener(this);
        popupMenu.add(findItem);
        replaceItem = new JMenuItem("Replace");
        replaceItem.addActionListener(this);
        popupMenu.add(replaceItem);
        textArea.setComponentPopupMenu(popupMenu);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create file menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        // Create file menu items
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        fileMenu.add(openItem);

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(this);
        fileMenu.add(saveItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        fileMenu.add(exitItem);

        // Create edit menu
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        // Create edit menu items
        cutItem = new JMenuItem("Cut");
        cutItem.addActionListener(this);
        editMenu.add(cutItem);

        copyItem = new JMenuItem("Copy");
        copyItem.addActionListener(this);
        editMenu.add(copyItem);

        pasteItem = new JMenuItem("Paste");
        pasteItem.addActionListener(this);
        editMenu.add(pasteItem);

        findItem = new JMenuItem("Find");
        findItem.addActionListener(this);
        editMenu.add(findItem);

        replaceItem = new JMenuItem("Replace");
        replaceItem.addActionListener(this);
        editMenu.add(replaceItem);

        // Create file chooser
        fileChooser = new JFileChooser();

        // Set frame properties
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open")) {
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                    reader.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equals("Save")) {
            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(textArea.getText());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    } else if (e.getActionCommand().equals("Exit")) {
        System.exit(0);
    } else if (e.getActionCommand().equals("Cut")) {
        textArea.cut();
    } else if (e.getActionCommand().equals("Copy")) {
        textArea.copy();
    } else if (e.getActionCommand().equals("Paste")) {
        textArea.paste();
    } else if (e.getActionCommand().equals("Find")) {
    String findString = JOptionPane.showInputDialog("Find:");
    String text = textArea.getText();
    int index = text.indexOf(findString);
    if (index == -1) {
        JOptionPane.showMessageDialog(null, "Text not found.");
    } else {
        textArea.select(index, index + findString.length());
        while (index >= 0 && index < text.length() - 1) {
            index = text.indexOf(findString, index + 1);
            if (index != -1) {
                textArea.select(index, index + findString.length());
            }
        }
	}
    } else if (e.getActionCommand().equals("Replace")) {
        String findString = JOptionPane.showInputDialog("Find:");
        String replaceString = JOptionPane.showInputDialog("Replace:");
        String text = textArea.getText();
        int index = text.indexOf(findString);
        if (index != -1) {
            textArea.replaceRange(replaceString, index, index + findString.length());
        }
    }
}

public static void main(String[] args) {
    new TextEditor();
}
}