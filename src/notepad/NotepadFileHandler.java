package notepad;

import javax.swing.*;
import java.io.*;

public class NotepadFileHandler {
    /**
     * openFile
     * ファイルを開く
     * @param textArea
     * @param fileChooser
     * @param parent
     */
    public static void openFile(JTextArea textArea, JFileChooser fileChooser, JFrame parent) {
        int option = fileChooser.showOpenDialog(parent);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parent, "Error opening file: " + ex.getMessage());
            }
        }
    }

    /**
     * ファイル保存
     * @param textArea
     * @param fileChooser
     * @param parent
     */
    public static void saveFile(JTextArea textArea, JFileChooser fileChooser, JFrame parent) {
        int option = fileChooser.showSaveDialog(parent);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(parent, "Error saving file: " + ex.getMessage());
            }
        }
    }
}