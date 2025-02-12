package notepad;

import javax.swing.*;
import java.awt.*;

public class NotepadFrame extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;

    /**
     * コンストラクタ
     */
    public NotepadFrame() {
        setTitle("Simple Notepad");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // テキストエリアとスクロールペインを生成
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // ファイル選択用コンポーネントの生成
        fileChooser = new JFileChooser();

        // メニューバーを生成して設定
        setJMenuBar(createMenuBar());

        // ウィンドウを中央に配置し、表示
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * createMenuBar
     * メニューバーの生成
     * @return JMenuBar the menu bar with file operations
     */
    // メニューバーの生成
    private JMenuBar createMenuBar() {
        // Create a new menu bar
        JMenuBar menuBar = new JMenuBar();
        // Create a "File" menu
        JMenu fileMenu = new JMenu("File");

        // New: テキストエリアをクリア
        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(e -> textArea.setText(""));

        // Open: ファイルを開く
        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(e -> openFile());

        // Save: ファイルに保存
        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(e -> saveFile());

        // Exit: アプリケーション終了
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        // Add menu items to the "File" menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator(); // Add a separator line
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        // Add the "File" menu to the menu bar
        menuBar.add(fileMenu);

        return menuBar; // Return the constructed menu bar
    }

    /**
     * openFile
     * ファイルを開く
     */
    private void openFile() {
        // Use the NotepadFileHandler to open a file and read its content into the textArea
        NotepadFileHandler.openFile(textArea, fileChooser, this);
    }

    /**
     * saveFile
     * ファイル保存
     */
    private void saveFile() {
        NotepadFileHandler.saveFile(textArea, fileChooser, this);
    }
}