package HashTables.Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Offer {
    String date;
    String time;
    String place;
    int price;

    public Offer(String s) {
        String[] parts = s.split("\\s+");

        this.date = parts[0];
        this.time = parts[1];
        this.place = parts[2];
        this.price = Integer.parseInt(parts[3]);
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d\n", time, place, price);
    }
}

public class BestOffer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.next();
        Map<String, Offer> mapByOffer = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Offer offer = new Offer(scanner.nextLine());
            if (mapByOffer.containsKey(offer.getDate())) {
                if (offer.getPrice() > mapByOffer.get(offer.getDate()).getPrice())
                    mapByOffer.put(offer.getDate(), offer);
            }
            else mapByOffer.put(offer.getDate(), offer);
        }

        String dateForTest = scanner.nextLine();
        System.out.println(mapByOffer.get(dateForTest));

    }
}

// input:
// 7
//27/01/2016 14:00 NewYork 6000
//28/01/2016 08:00 Paris 3000
//28/01/2016 14:00 Munich 5000
//27/01/2016 09:00 Beijing 8000
//27/01/2016 08:00 Seattle 4000
//28/01/2016 09:00 SaltLakeCity 10000
//28/01/2016 09:00 Lagos 12000
//27/01/2016

// output:
// 09:00 Beijing 8000
