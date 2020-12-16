import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Solution {
    public static HashSet<String> containingBagCache = new HashSet<String>();
    public static int getContainingBagsCount(String bag, String[] rules) {
        if (containingBagCache.contains(bag)) {
            return 0;
        }
        ArrayList<String> containingBags = new ArrayList<String>();
        for (String rule : rules) { //
            if (rule.substring(bag.length()).contains(bag)) {
                containingBags.add(rule.split("s contain")[0]);
            }
        }
        int count = 1;
        for (String containingBag : containingBags) {
            count += getContainingBagsCount(containingBag, rules);
        }
        containingBagCache.add(bag);
        return count;
    }
    
    public static String[] getBagContent(String bag, String[] rules) {
        for (String rule : rules) {
            if (rule.substring(0, bag.length()).contains(bag)) {
                return rule.split("contain ")[1].split(", ");
            }
        }
        return null;
    }
    public static HashMap<String, Integer> containedBagCache = new HashMap<String, Integer>();
    public static int getContainedBagsCount(String bag, String[] rules) {
        if (containedBagCache.containsKey(bag)) {
            return containedBagCache.get(bag);
        }

        String[] bagContent = getBagContent(bag, rules);
        int result = 1;

        for (String containedBag : bagContent) {
            if (containedBag.contains("no other bags")) {
                continue;
            }
            int amountOfBags = Integer.parseInt(containedBag.substring(0,1));
            result += amountOfBags * getContainedBagsCount(containedBag.substring(2).replace(".", ""), rules);
        }
        containedBagCache.put(bag, result);
        return result;
    }
    public static void main(String[] args) throws IOException {
        String[] rules = AoCFileReader.splitStrIntoLines(AoCFileReader.getStrFromFile("input.txt"));
        int firstPartAnswer = getContainingBagsCount("shiny gold bag", rules) - 1;
        int secondPartAnswer = getContainedBagsCount("shiny gold bag", rules) - 1;
        System.out.println(firstPartAnswer);
        System.out.println(secondPartAnswer);
    }
} 