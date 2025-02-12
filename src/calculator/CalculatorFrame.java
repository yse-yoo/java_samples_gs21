package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorFrame extends JFrame {
    private JTextField display;
    private boolean startNewNumber;
    private CalculatorEngine engine;

    /**
     * コンストラクタ
     */
    public CalculatorFrame() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 初期状態の設定
        engine = new CalculatorEngine();
        startNewNumber = true;

        // 計算結果表示用テキストフィールド（ディスプレイ）
        display = new JTextField("0");
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);

        // ボタンパネル（グリッドレイアウト：4×4）
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        // ボタンを作成してパネルに追加
        for (String label : buttonLabels) {
            JButton btn = new JButton(label);
            btn.setFont(new Font("Arial", Font.BOLD, 20));
            btn.addActionListener(new ButtonListener());
            panel.add(btn);
        }

        // ボタンパネルをウィンドウに追加
        add(panel, BorderLayout.CENTER);
        setLocationRelativeTo(null); // ウィンドウを中央に配置
        setVisible(true);
    }

    /**
     * ボタン押下時のイベントリスナー
     */
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if ("0123456789".contains(command)) {
                // 数字ボタンが押されたとき
                if (startNewNumber) {
                    display.setText(command);
                    startNewNumber = false;
                } else {
                    display.setText(display.getText() + command);
                }
            } else if ("/*-+".contains(command)) {
                // 演算子ボタンが押されたとき
                double number = Double.parseDouble(display.getText());
                double result = engine.calculate(number, command);
                display.setText("" + result);
                startNewNumber = true;
            } else if ("=".equals(command)) {
                double number = Double.parseDouble(display.getText());
                double result = engine.calculate(number, "=");
                display.setText("" + result);
                startNewNumber = true;
            } else if ("C".equals(command)) {
                // クリアボタン：エンジンの状態をリセット
                engine.clear();
                display.setText("0");
                startNewNumber = true;
            }
        }
    }
}