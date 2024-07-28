import java.util.*;

class Anagram {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i=0;i<n;i++) {
            str[i] = sc.next();
        }
        // Arrays.sort(str);
        List<List<String>> ans = groupAnagrams(str);
        // Collections.sort(ans);
        
        for(List<String> it : ans) {
            for(String s : it) {
                System.out.print(s + " ");
            }
                System.out.println();
        }
    }
    
    private static List<List<String>> groupAnagrams(String[] str) {
        
        Map<String, List<String>> anagrams = new HashMap<>();
        
        for(String s : str) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            
            String sortedStr = new String(charArray);
            if(!anagrams.containsKey(sortedStr)) {
                anagrams.put(sortedStr, new ArrayList<>());
            }
            
            anagrams.get(sortedStr).add(s);
        }
        
        return new ArrayList<>(anagrams.values());
    }
}