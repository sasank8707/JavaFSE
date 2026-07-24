import java.util.Scanner;
public class Money {
    static double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return predictFutureValue(
                currentValue * (1 + growthRate / 100),
                growthRate,
                years - 1
        );
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Money Tool");
        System.out.print("Current Value: ");
        double currentValue = sc.nextDouble();
        System.out.print("Annual Rate (%): ");
        double growthRate = sc.nextDouble();
        System.out.print("Years: ");
        int years = sc.nextInt();
        double futureValue = predictFutureValue(
                currentValue,
                growthRate,
                years
        );
        System.out.printf("\nPredicted Value after %d years: %.2f",
                years,
                futureValue);
        sc.close();
    }
}