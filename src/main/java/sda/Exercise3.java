package sda;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise3 {

    public static void main(String[] args) {
        Map<String, Integer> mapList = new LinkedHashMap<>();
        mapList.put("Java", 18);
        mapList.put("Python", 1);
        mapList.put("PHP", 0);

        String result = mapList.entrySet().stream()
                .map(entry -> "Key: " + entry.getKey() + ", Value: " + entry.getValue())
                .collect(Collectors.joining(String.format(",%n"), "", "."));

        System.out.println(result);
    }
}
