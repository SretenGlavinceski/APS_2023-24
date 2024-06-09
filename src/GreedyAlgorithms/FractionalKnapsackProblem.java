package GreedyAlgorithms;

import java.util.Scanner;

public class FractionalKnapsackProblem {

    static double getFractKnpMaxProfit(int [] values, int [] weights, int capacity) {
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] / (double) weights[i] < values[j] / (double) weights[j]) {
                    int temp1 = values[i];
                    int temp2 = weights[i];
                    values[i] = values[j];
                    weights[i] = weights[j];
                    values[j] = temp1;
                    weights[j] = temp2;
                }
            }
        }

        double total = 0;
        int index = 0;
        while (true) {
            if (weights[index] > capacity) {
                total += (((double)capacity / weights[index]) * values[index]);
                break;
            } else {
                capacity -= weights[index];
                total += values[index];
            }
            index++;
        }

        return total;
    }
//{{60, 10}, {100, 20}, {120, 30}}, W = 50
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int [] weights = new int[n];
        int [] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }

        int maxCapacity = scanner.nextInt();
        System.out.println(getFractKnpMaxProfit(values, weights, maxCapacity));
    }
}
