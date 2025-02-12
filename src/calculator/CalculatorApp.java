package calculator;

import javax.swing.SwingUtilities;

public class CalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorFrame();
            }
        });
    }
}