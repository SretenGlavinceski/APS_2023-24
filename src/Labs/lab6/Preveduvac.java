//package Labs.lab6;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//class OBHT<K extends Comparable<K>,E> {
//
//    // An object of class OBHT is an open-bucket hash table, containing entries
//    // of class MapEntry.
//    private MapEntry<K,E>[] buckets;
//
//    // buckets[b] is null if bucket b has never been occupied.
//    // buckets[b] is former if bucket b is formerly-occupied
//    // by an entry that has since been deleted (and not yet replaced).
//
//    static final int NONE = -1; // ... distinct from any bucket index.
//
//    @SuppressWarnings({ "rawtypes", "unchecked" })
//    private static final MapEntry former = new MapEntry(null, null);
//    // This guarantees that, for any genuine entry e,
//    // e.key.equals(former.key) returns false.
//
//    private int occupancy = 0;
//    // ... number of occupied or formerly-occupied buckets in this OBHT.
//
//    @SuppressWarnings("unchecked")
//    public OBHT (int m) {
//        // Construct an empty OBHT with m buckets.
//        buckets = (MapEntry<K,E>[]) new MapEntry[m];
//    }
//
//    public MapEntry<K,E> getBucket(int i){
//        return buckets[i];
//    }
//
//    private int hash (K key) {
//        // Translate key to an index of the array buckets.
//        return Math.abs(key.hashCode()) % buckets.length;
//    }
//
//
//    public int search (K targetKey) {
//        // Find which if any bucket of this OBHT is occupied by an entry whose key
//        // is equal to targetKey. Return the index of that bucket.
//        int b = hash(targetKey); int n_search=0;
//        for (;;) {
//            MapEntry<K,E> oldEntry = buckets[b];
//            if (oldEntry == null)
//                return NONE;
//            else if (targetKey.equals(oldEntry.key))
//                return b;
//            else
//            {
//                b = (b + 1) % buckets.length;
//                n_search++;
//                if(n_search==buckets.length)
//                    return NONE;
//
//            }
//        }
//    }
//
//
//    public void insert (K key, E val) {
//        // Insert the entry <key, val> into this OBHT.
//        MapEntry<K,E> newEntry = new MapEntry<K,E>(key, val);
//        int b = hash(key); int n_search=0;
//        for (;;) {
//            MapEntry<K,E> oldEntry = buckets[b];
//            if (oldEntry == null) {
//                if (++occupancy == buckets.length) {
//                    System.out.println("Hash tabelata e polna!!!");
//                }
//                buckets[b] = newEntry;
//                return;
//            }
//            else if (oldEntry == former
//                    || key.equals(oldEntry.key)) {
//                buckets[b] = newEntry;
//                return;
//            }
//            else
//            {
//                b = (b + 1) % buckets.length;
//                n_search++;
//                if(n_search==buckets.length)
//                    return;
//
//            }
//        }
//    }
//
//
//    @SuppressWarnings("unchecked")
//    public void delete (K key) {
//        // Delete the entry (if any) whose key is equal to key from this OBHT.
//        int b = hash(key); int n_search=0;
//        for (;;) {
//            MapEntry<K,E> oldEntry = buckets[b];
//
//            if (oldEntry == null)
//                return;
//            else if (key.equals(oldEntry.key)) {
//                buckets[b] = former;//(MapEntry<K,E>)former;
//                return;
//            }
//            else{
//                b = (b + 1) % buckets.length;
//                n_search++;
//                if(n_search==buckets.length)
//                    return;
//
//            }
//        }
//    }
//
//
//    public String toString () {
//        String temp = "";
//        for (int i = 0; i < buckets.length; i++) {
//            temp += i + ":";
//            if (buckets[i] == null)
//                temp += "\n";
//            else if (buckets[i] == former)
//                temp += "former\n";
//            else
//                temp += buckets[i] + "\n";
//        }
//        return temp;
//    }
//
//
//    public OBHT<K,E> clone () {
//        OBHT<K,E> copy = new OBHT<K,E>(buckets.length);
//        for (int i = 0; i < buckets.length; i++) {
//            MapEntry<K,E> e = buckets[i];
//            if (e != null && e != former)
//                copy.buckets[i] = new MapEntry<K,E>(e.key, e.value);
//            else
//                copy.buckets[i] = e;
//        }
//        return copy;
//    }
//}
//
//
//public class Preveduvac {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        OBHT<String, String> wordTranslator = new OBHT<>(n * 2);
//
//        br.lines().limit(n).forEach(line -> {
//            String [] parts = line.split("\\s+");
//            wordTranslator.insert(parts[1], parts[0]);
//        });
//
//        br.lines().forEach(guess -> {
//            if (!guess.equals("KRAJ")) {
//                int isPresent = wordTranslator.search(guess);
//                if (isPresent != -1)
//                    System.out.println(wordTranslator.getBucket(isPresent).value);
//                else
//                    System.out.println("/");
//            }
//        });
//    }
//}
