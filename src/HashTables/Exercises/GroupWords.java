package HashTables.Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class GroupWords {

    static String getKey(String string) {
        Set<Character> distinctChars = new TreeSet<>();
        for (int i = 0; i < string.length(); i++)
            distinctChars.add(string.charAt(i));

        return distinctChars.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    static void showSameSetCharacterWords(String [] words) {
        Map<String, List<String>> wordCollect;

        wordCollect = Arrays.stream(words).collect(Collectors.groupingBy(
                GroupWords::getKey,
                LinkedHashMap::new,
                Collectors.toList()
        ));

        for (List<String> strings : wordCollect.values())
            System.out.println(strings);
    }

    public static void main(String[] args) {
        String [] words= { "may", "student", "students", "dog",
                "studentssess", "god", "cat", "act",
                "tab", "bat", "flow", "wolf", "lambs",
                "amy", "yam", "balms", "looped",
                "poodle"};

        showSameSetCharacterWords(words);
    }
}

