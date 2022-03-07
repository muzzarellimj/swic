package semester_two.week_fifteen;

import java.util.HashMap;
import java.util.Map;

public class MapDemonstration {

    public static void main(String[] args) {
        MapObject<String, Integer> encryption = new MapObject<>("A", 4);
        MapObject<String, String> baseball = new MapObject<>("Molina", "Catcher");

        System.out.println(encryption);
        System.out.println(baseball);

        // use of java map
        Map<Character, Integer> code = new HashMap<>();
        code.put('A', 4);
        code.put('B', 9);
        code.put('C', 2);
        code.put('D', 7);

        System.out.println(code);
    }
}