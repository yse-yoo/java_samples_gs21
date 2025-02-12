package countdown;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountdownFrame extends JFrame {
    private JLabel countdownLabel;
    private JButton startButton;
    private Timer timer;
    private int count;

    public CountdownFrame() {
        // フレームの設定
        setTitle("Countdown Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        // カウントダウン表示用のラベルを作成
        countdownLabel = new JLabel("Ready", SwingConstants.CENTER);
        countdownLabel.setFont(new Font("Arial", Font.BOLD, 48));
        add(countdownLabel, BorderLayout.CENTER);

        // カウントダウン開始用ボタンを作成
        startButton = new JButton("Start Countdown");
        startButton.setFont(new Font("Arial", Font.PLAIN, 18));
        add(startButton, BorderLayout.SOUTH);

        // ボタン押下時の動作を設定
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCountdown();
            }
        });

        // ウィンドウを中央に配置して表示
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // カウントダウンを開始するメソッド
    private void startCountdown() {
        count = 3; // カウントダウン開始値（秒）
        countdownLabel.setText(String.valueOf(count));
        startButton.setEnabled(false);

        // 1秒ごとに動作する Swing Timer を生成
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                count--;
                if (count > 0) {
                    countdownLabel.setText(String.valueOf(count));
                } else {
                    timer.stop();
                    countdownLabel.setText("Time's up!");
                    startButton.setEnabled(true);
                }
            }
        });
        timer.start();
    }
}