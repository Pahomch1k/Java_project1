package step.learning.DZ.Dz_9;
import java.util.concurrent.*;

public class InflationCalculator {
    public void run() {
        ExecutorService executor = Executors.newFixedThreadPool(6);
        Future<Double>[] futures = new Future[12];

        for (int i = 0; i < 12; i++) {
            futures[i] = executor.submit(() -> calculateInflation(generatePrices(), generatePrices()));
        }

        double totalInflation = 0;
        for (Future<Double> future : futures) {
            try {
                totalInflation += future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdown();

        System.out.println("Average Annual Inflation: " + totalInflation / 12);
    }

    private double calculateInflation(double[] pricesLastYear, double[] pricesThisYear) {
        double sumLastYear = 0, sumThisYear = 0;

        for (double price : pricesLastYear) {
            sumLastYear += price;
        }
        for (double price : pricesThisYear) {
            sumThisYear += price;
        }

        double averagePriceLastYear = sumLastYear / pricesLastYear.length;
        double averagePriceThisYear = sumThisYear / pricesThisYear.length;

        return ((averagePriceThisYear - averagePriceLastYear) / averagePriceLastYear) * 100;
    }

    private double[] generatePrices() {
        double[] prices = new double[100];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = 100 + Math.random() * 20;
        }
        return prices;
    }
}