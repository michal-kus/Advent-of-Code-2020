import java.util.HashMap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class Solution {

    
    
    public static int checkExpenseReport(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();// liczba klucz jej indeks wartosc
        for (int i = 0; i < nums.length; i++) {
            int temp = 2020 - nums[i]; // różnica pomiędzy liczbą w tej pętli oraz 2020
            if (map.containsKey(temp)) { // jeśli ta różnica już jest to jest mnożone
                return temp * nums[i]; // wymnaża liczbę co tera jest z jej roznica do 2020
            }
            map.put(nums[i], i); // wklada dla mapy liczbe i jej indeks
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
            
            String data;

            data = new String(Files.readAllBytes(Paths.get("input.txt")));

            String[] lines = data.split(System.getProperty("line.separator"));
            int[] arr = new int[lines.length];

            for(int i = 0; i < lines.length; i++) {
                arr[i] = Integer.parseInt(lines[i]);
            }
            System.out.print(Integer.toString(checkExpenseReport(arr)));
        
        }
    }

