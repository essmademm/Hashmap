import java.util.HashMap;
import java.util.Map;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        // 1. Create & Put
        HashMap<String, Integer> map1 = new HashMap<>();
        map1.put("Aida", 85);
        map1.put("Azat", 92);
        map1.put("Dana", 77);
        System.out.println("1) " + map1);
        System.out.println("Size: " + map1.size());


        // 2. Get & ContainsKey
        HashMap<String, Integer> map2 = new HashMap<>();
        map2.put("Aida", 85);
        map2.put("Azat", 92);
        map2.put("Dana", 77);

        System.out.println("\n2) Get Aida: " + map2.get("Aida"));
        System.out.println("Get Mira: " + map2.get("Mira"));

        if (map2.containsKey("Mira")) {
            System.out.println("Mira found");
        } else {
            System.out.println("Mira not found");
        }


        // 3. Update Existing Value
        HashMap<String, Integer> map3 = new HashMap<>();
        map3.put("Aida", 85);
        map3.put("Azat", 92);
        map3.put("Dana", 77);

        Integer old = map3.put("Dana", 80);
        System.out.println("\n3) Old Dana score: " + old);
        System.out.println("Updated map: " + map3);


        // 4. Remove by Key
        HashMap<String, Integer> map4 = new HashMap<>();
        map4.put("Aida", 85);
        map4.put("Azat", 92);
        map4.put("Dana", 77);

        Integer removed = map4.remove("Azat");
        System.out.println("\n4) Azat removed: " + (removed != null));

        Integer removed2 = map4.remove("NonExisting");
        System.out.println("NonExisting removed: " + (removed2 != null));


        // 5. isEmpty & clear
        HashMap<String, Integer> map5 = new HashMap<>();
        map5.put("Aida", 85);
        map5.put("Dana", 80);

        System.out.println("\n5) Is empty before clear: " + map5.isEmpty());
        map5.clear();
        System.out.println("Is empty after clear: " + map5.isEmpty());


        // 6. getOrDefault
        HashMap<String, Integer> map6 = new HashMap<>();
        map6.put("Aida", 85);
        map6.put("Dana", 80);

        int score1 = map6.getOrDefault("Aida", -1);
        int score2 = map6.getOrDefault("Mira", -1);

        System.out.println("\n6) Aida: " + (score1 == -1 ? "Not found" : score1));
        System.out.println("Mira: " + (score2 == -1 ? "Not found" : score2));


        // 7. putIfAbsent
        HashMap<String, Integer> map7 = new HashMap<>();
        map7.put("Aida", 85);

        map7.putIfAbsent("Aida", 90);   // keeps 85
        map7.putIfAbsent("Mira", 88);   // inserts 88

        System.out.println("\n7) " + map7);


        // 8. replace
        HashMap<String, Integer> map8 = new HashMap<>();
        map8.put("Aida", 85);

        boolean condReplace = map8.replace("Aida", 85, 86);
        System.out.println("\n8) Conditional replace success: " + condReplace);

        Integer uncondReplace = map8.replace("Aida", 91);
        System.out.println("Unconditional replace old value: " + uncondReplace);

        Integer replaceMissing = map8.replace("Unknown", 100);
        System.out.println("Replace missing key: " + replaceMissing);


        // 9. Iterate keys, values, entries
        HashMap<String, Integer> map9 = new HashMap<>();
        map9.put("Aida", 85);
        map9.put("Dana", 80);
        map9.put("Timur", 90);

        System.out.println("\n9) Keys:");
        for (String key : map9.keySet()) {
            System.out.println(key);
        }

        System.out.println("Values:");
        for (Integer value : map9.values()) {
            System.out.println(value);
        }

        System.out.println("Entries:");
        for (Map.Entry<String, Integer> entry : map9.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }


        // 10. Count score ≥ 80
        HashMap<String, Integer> map10 = new HashMap<>();
        map10.put("Aida", 85);
        map10.put("Dana", 70);
        map10.put("Timur", 90);

        int count = 0;
        for (Integer value : map10.values()) {
            if (value >= 80) {
                count++;
            }
        }
        System.out.println("\n10) Count >= 80: " + count);


        // 11. Find max score
        HashMap<String, Integer> map11 = new HashMap<>();
        map11.put("Aida", 85);
        map11.put("Dana", 80);
        map11.put("Timur", 90);

        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map11.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        System.out.println("\n11) Max score: " + max);
        System.out.println("Student(s) with max:");
        for (Map.Entry<String, Integer> entry : map11.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println(entry.getKey());



                // 12. Word Frequency Counter
                String text1 = "Java is fun and Java is powerful and fun";
                String[] words1 = text1.toLowerCase().split(" ");
                HashMap<String, Integer> wordFreq = new HashMap<>();

                for (String w : words1) {
                    wordFreq.put(w, wordFreq.getOrDefault(w, 0) + 1);
                }
                System.out.println("1) Word frequency: " + wordFreq);


                // 13. Character Frequency (letters only)
                String text2 = "Mississippi";
                HashMap<Character, Integer> charFreq = new HashMap<>();

                for (char c : text2.toCharArray()) {
                    if (Character.isLetter(c)) {
                        charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
                    }
                }
                System.out.println("\n2) Character frequency: " + charFreq);

                char maxChar = 0;
                int maxCount = 0;
                for (Map.Entry<Character, Integer> e : charFreq.entrySet()) {
                    if (e.getValue() > maxCount) {
                        maxCount = e.getValue();
                        maxChar = e.getKey();
                    }
                }
                System.out.println("Most frequent char: " + maxChar);


                // 14. Group Words by Length
                String[] arr3 = {"hi","book","java","sun","loop","map"};
                HashMap<Integer, ArrayList<String>> lengthMap = new HashMap<>();

                for (String w : arr3) {
                    lengthMap.computeIfAbsent(w.length(), k -> new ArrayList<>()).add(w);
                }
                System.out.println("\n3) Grouped by length: " + lengthMap);


                // 15. First Non-Repeating Character
                String text4 = "swiss";
                HashMap<Character, Integer> freq4 = new HashMap<>();

                for (char c : text4.toCharArray()) {
                    freq4.put(c, freq4.getOrDefault(c, 0) + 1);
                }

                Character firstUnique = null;
                for (char c : text4.toCharArray()) {
                    if (freq4.get(c) == 1) {
                        firstUnique = c;
                        break;
                    }
                }
                System.out.println("\n4) First non-repeating: " +
                        (firstUnique == null ? "None" : firstUnique));


                // 16. Two-Sum (Index Map)
                int[] nums5 = {2, 7, 11, 15};
                int target5 = 9;
                HashMap<Integer, Integer> indexMap = new HashMap<>();

                for (int i = 0; i < nums5.length; i++) {
                    int complement = target5 - nums5[i];
                    if (indexMap.containsKey(complement)) {
                        System.out.println("\n5) Two sum indices: " +
                                indexMap.get(complement) + ", " + i);
                        break;
                    }
                    indexMap.put(nums5[i], i);
                }


                // 17. Detect Duplicates with Map
                String[] arr6 = {"apple","banana","apple","orange","banana","kiwi"};
                HashMap<String, Integer> freq6 = new HashMap<>();

                for (String s : arr6) {
                    freq6.put(s, freq6.getOrDefault(s, 0) + 1);
                }

                System.out.println("\n6) Unique items:");
                for (Map.Entry<String, Integer> e : freq6.entrySet()) {
                    if (e.getValue() == 1) {
                        System.out.println(e.getKey());
                    }
                }

                System.out.println("Duplicated items:");
                for (Map.Entry<String, Integer> e : freq6.entrySet()) {
                    if (e.getValue() > 1) {
                        System.out.println(e.getKey() + " = " + e.getValue());
                    }
                }


                // 18. Equals & Order-Insensitivity
                HashMap<String,Integer> mapA = new HashMap<>();
                mapA.put("A",1);
                mapA.put("B",2);

                HashMap<String,Integer> mapB = new HashMap<>();
                mapB.put("B",2);
                mapB.put("A",1);

                System.out.println("\n7) Equals: " + mapA.equals(mapB));
                System.out.println("HashCodes: " + mapA.hashCode() + " , " + mapB.hashCode());


                // 19. Remove Entries Conditionally
                HashMap<String,Integer> mapp = new HashMap<>();
                mapp.put("Aida",75);
                mapp.put("Azat",50);
                mapp.put("Dana",40);

                Iterator<Map.Entry<String,Integer>> it = mapp.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String,Integer> e = it.next();
                    if (e.getValue() < 60) {
                        it.remove();
                    }
                }
                System.out.println("\n8) After removing <60: " + mapp);


                // 20. Merge Scores
                HashMap<String,Integer> scores1 = new HashMap<>();
                scores1.put("Aida",40);
                scores1.put("Azat",35);
                scores1.put("Dana",50);

                HashMap<String,Integer> scores2 = new HashMap<>();
                scores2.put("Azat",10);
                scores2.put("Dana",5);
                scores2.put("Mira",45);

                for (Map.Entry<String,Integer> e : scores2.entrySet()) {
                    scores1.merge(e.getKey(), e.getValue(), Integer::sum);
                }
                System.out.println("\n9) Merged scores: " + scores1);


                // 21. Invert a Map (Handling Collisions)
                HashMap<String,Integer> studentScore = new HashMap<>();
                studentScore.put("Aida",90);
                studentScore.put("Azat",80);
                studentScore.put("Dana",90);

                HashMap<Integer, ArrayList<String>> inverted = new HashMap<>();

                for (Map.Entry<String,Integer> e : studentScore.entrySet()) {
                    inverted.computeIfAbsent(e.getValue(),
                            k -> new ArrayList<>()).add(e.getKey());
                }
                System.out.println("\n10) Inverted map: " + inverted);


                // 22. Top-2 Frequent Words
                String text11 = "java is fun java is cool java is powerful";
                String[] words11 = text11.split(" ");
                HashMap<String,Integer> freq11 = new HashMap<>();

                for (String w : words11) {
                    freq11.put(w, freq11.getOrDefault(w,0)+1);
                }

                ArrayList<Map.Entry<String,Integer>> list =
                        new ArrayList<>(freq11.entrySet());

                list.sort((a,b) -> b.getValue() - a.getValue());

                System.out.println("\n11) Top 2 frequent:");
                for (int i = 0; i < Math.min(2, list.size()); i++) {
                    System.out.println(list.get(i).getKey() +
                            " = " + list.get(i).getValue());
                }
            }
        }
    }
}