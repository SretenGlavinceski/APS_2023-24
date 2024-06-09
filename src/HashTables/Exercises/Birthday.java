package HashTables.Exercises;

import HashTables.CBHT;
import HashTables.MapEntry;
import HashTables.SLLNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class Birthday {
    public static void main(String[] args) {

        CBHT<Integer, Integer> map = new CBHT<>(12);

        new BufferedReader(new InputStreamReader(System.in))
                .lines().forEach(line -> {
                    String [] date = line.split("\\.");
                    String month = date[1];

                    int key = Integer.parseInt(month);

                    if (map.search(key) != null) {
                        int value = map.search(key).element.value;
                        map.delete(key);
                        map.insert(key, value + 1);
                    } else {
                        map.insert(key, 1);
                    }
                });

        System.out.println(map.search(7).element.value);
    }
}


// input
// 20.7.1976
//16.7.1988
//18.7.1966
//5.6.1988^D
// 7

// output 3