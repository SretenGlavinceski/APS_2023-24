package Labs.lab2;

import java.util.Scanner;

public class MiceHoles {

    //TODO: implement function
    public static int minTime(int[] mice, int[] holes) {
        for (int i = 0; i < mice.length; i++) {
            for (int j = i + 1; j < mice.length; j++) {
                if (mice[i] < mice[j]) {
                    int temp1 = mice[i];
                    mice[i] = mice[j];
                    mice[j] = temp1;
                }

                if (holes[i] < holes[j]) {
                    int temp2 = holes[i];
                    holes[i] = holes[j];
                    holes[j] = temp2;
                }
            }
        }

        int min = Math.abs(mice[0] - holes[0]);

        for (int i = 1; i < mice.length; i++) {
            int temp = Math.abs(mice[i] - holes[i]);
            if (min < temp) {
                min = temp;
            }
        }

        return min;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        String parts[] = line.split(" ");
        int mice[] = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            mice[i] = Integer.parseInt(parts[i]);
        }

        line = input.nextLine();
        parts = line.split(" ");
        int holes[] = new int[parts.length];
        for(int i=0;i<parts.length;i++) {
            holes[i] = Integer.parseInt(parts[i]);
        }

        System.out.println(minTime(mice, holes));
    }
}

