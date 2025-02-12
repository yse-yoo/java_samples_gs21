package countdown;

import javax.swing.SwingUtilities;

public class CountdownApp {
    public static void main(String[] args) {
        // Event Dispatch Thread 上で UI を構築
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CountdownFrame();
            }
        });
    }
}