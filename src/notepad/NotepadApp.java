package notepad;

import javax.swing.SwingUtilities;

public class NotepadApp {
    /**
     * メインアプリ
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NotepadFrame());
    }
}