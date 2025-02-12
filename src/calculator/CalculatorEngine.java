package calculator;

public class CalculatorEngine {
    private double result;
    private String operator;

    /**
     * コンストラクタ
     */
    public CalculatorEngine() {
        result = 0;
        operator = "=";
    }

    /**
     * calcualte
     * 
     * 指定された数値と演算子を用いて計算を行い、その結果を返します。
     * 演算子が "=" の場合は、入力された数値を結果として保持します。
     *
     * @param number 入力された数値
     * @param newOperator 新たに設定する演算子
     * @return 計算結果
     */
    public double calculate(double number, String newOperator) {
        if (operator.equals("=")) {
            result = number;
        } else if (operator.equals("+")) {
            result += number;
        } else if (operator.equals("-")) {
            result -= number;
        } else if (operator.equals("*")) {
            result *= number;
        } else if (operator.equals("/")) {
            result /= number;
        }
        operator = newOperator;
        return result;
    }

    /**
     * 内部状態（結果および演算子）をクリアします。
     * return void
     */
    public void clear() {
        result = 0;
        operator = "=";
    }

    /**
     * 計算結果
     * @return double
     */
    public double getResult() {
        return result;
    }
}