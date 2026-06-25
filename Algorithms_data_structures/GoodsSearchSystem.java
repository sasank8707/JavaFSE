import java.util.*;

class Goods {
    int goodsId;
    String goodsName;
    String goodsCategory;

    Goods(int goodsId, String goodsName, String goodsCategory) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsCategory = goodsCategory;
    }

    void displayGoods() {
        System.out.println("Goods ID : " + goodsId);
        System.out.println("Goods Name : " + goodsName);
        System.out.println("Goods Category : " + goodsCategory);
    }
}

public class GoodsSearchSystem {

    static Goods linearFind(Goods[] goodsArray, int targetGoodsId) {
        for (Goods singleGoods : goodsArray) {
            if (singleGoods.goodsId == targetGoodsId) {
                return singleGoods;
            }
        }
        return null;
    }

    static Goods binaryFind(Goods[] goodsArray, int targetGoodsId) {
        int leftPointer = 0;
        int rightPointer = goodsArray.length - 1;

        while (leftPointer <= rightPointer) {
            int centerIndex = leftPointer + (rightPointer - leftPointer) / 2;

            if (goodsArray[centerIndex].goodsId == targetGoodsId) {
                return goodsArray[centerIndex];
            }

            if (goodsArray[centerIndex].goodsId < targetGoodsId) {
                leftPointer = centerIndex + 1;
            } else {
                rightPointer = centerIndex - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in);

        System.out.println("E-Commerce Product Search");
        System.out.print("Enter number of goods: ");
        int goodsCount = scannerObj.nextInt();
        scannerObj.nextLine();

        Goods[] goodsList = new Goods[goodsCount];

        for (int index = 0; index < goodsCount; index++) {
            System.out.println("\nGoods " + (index + 1));

            System.out.print("Enter Goods ID: ");
            int enteredId = scannerObj.nextInt();
            scannerObj.nextLine();

            System.out.print("Enter Goods Name: ");
            String enteredName = scannerObj.nextLine();

            System.out.print("Enter Goods Category: ");
            String enteredCategory = scannerObj.nextLine();

            goodsList[index] = new Goods(enteredId, enteredName, enteredCategory);
        }

        System.out.print("\nEnter Goods ID to Search: ");
        int searchKey = scannerObj.nextInt();

        Goods linearOutput = linearFind(goodsList, searchKey);
        System.out.println("\nLinear Search Result:");
        if (linearOutput != null) {
            linearOutput.displayGoods();
        } else {
            System.out.println("Goods not found.");
        }

        Goods[] arrangedGoods = Arrays.copyOf(goodsList, goodsList.length);
        Arrays.sort(arrangedGoods, Comparator.comparingInt(data -> data.goodsId));

        Goods binaryOutput = binaryFind(arrangedGoods, searchKey);
        System.out.println("\nBinary Search Result:");
        if (binaryOutput != null) {
            binaryOutput.displayGoods();
        } else {
            System.out.println("Goods not found.");
        }

        scannerObj.close();
    }
}