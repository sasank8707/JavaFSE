import java.util.*;
class Product {
    int productId;
    String productName;
    String category;
    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
    void display() {
        System.out.println("Product ID   : " + productId);
        System.out.println("Product Name : " + productName);
        System.out.println("Category     : " + category);
    }
}
public class EcommerceSearch {
    static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }
    static Product binarySearch(Product[] products, int targetId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            }
            if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("E-Commerce Product Search");
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();
        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct " + (i + 1));
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Category: ");
            String category = sc.nextLine();
            products[i] = new Product(id, name, category);
        }
        System.out.print("\nEnter Product ID to Search: ");
        int searchId = sc.nextInt();
        Product linearResult = linearSearch(products, searchId);
        System.out.println("\nLinear Search Result");
        if (linearResult != null) {
            linearResult.display();
        } else {
            System.out.println("Product not found.");
        }
        Product[] sortedProducts = Arrays.copyOf(products, products.length);
        Arrays.sort(sortedProducts, Comparator.comparingInt(p -> p.productId));
        Product binaryResult = binarySearch(sortedProducts, searchId);
        System.out.println("\nBinary Search Result");
        if (binaryResult != null) {
            binaryResult.display();
        } else {
            System.out.println("Product not found.");
        }
        sc.close();
    }
}