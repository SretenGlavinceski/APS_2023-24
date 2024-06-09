//package Labs.lab6;
//
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class RoutingHashJava {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int n = Integer.parseInt(scanner.nextLine());
//        Map<String, List<String>> routersByNetworks = new HashMap<>();
//
//        for (int i = 0; i < n; i++) {
//            String router = scanner.nextLine();
//            String networks = scanner.nextLine();
//
//            routersByNetworks.put(
//                    router,                                 // add router
//                    Arrays.stream(networks.split(",")) // add networks
//                            .map(s -> s.substring(0, s.length() - 2))
//                            .collect(Collectors.toList())
//            );
//        }
//
//        int m = Integer.parseInt(scanner.nextLine());
//
//        for (int i = 0; i < m; i++) {
//            String key = scanner.nextLine();
//            String [] temp = scanner.nextLine().split("\\.");
//            String network = Arrays.stream(temp)
//                    .limit(temp.length - 1)
//                    .collect(Collectors.joining("."));
//
//            if (routersByNetworks.containsKey(key) && routersByNetworks.get(key).contains(network))
////                System.out.println("postoi");
//            else
//                System.out.println("ne postoi");
//        }
//    }
//}
