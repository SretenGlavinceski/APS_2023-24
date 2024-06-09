package HashTables.Exercises;

import java.util.*;

public class MostFrequentElement {

    static int mostFreqElement(int[] array) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        Arrays.stream(array).forEach(num -> {
            numFreq.computeIfPresent(num, (k, v) -> v + 1);
            numFreq.putIfAbsent(num, 1);
        });

        int maxFreq = 0;
        int maxNum = array[0];
        for (int key : numFreq.keySet())
            if (numFreq.get(key) > maxFreq) {
                maxFreq = numFreq.get(key);
                maxNum = key;
            }

        return maxNum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int [] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Most frequent element: " + mostFreqElement(array));
    }

}
