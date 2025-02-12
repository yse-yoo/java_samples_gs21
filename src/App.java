import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("商品名を入力してください: ");
        String name = scanner.nextLine();
        
        System.out.print("価格を入力してください: ");
        int price = scanner.nextInt();
        
        System.out.print("数量を入力してください: ");
        int quantity = scanner.nextInt();
        
        Product product = new Product(name, price, quantity);
        System.out.println("\n登録された商品情報:");
        product.displayProduct();
        
        scanner.close();
    }
}