## Find weather the give String is presents in the hash table or not
---
``` java []

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String s = sc.next();
            int num = sc.nextInt();
            map.put(s,num);
        }
        
        String key = sc.next();
        if(map.containsKey(key)){
            System.out.println("Key " + '"' + key + '"' +" exists in the dictionary.");
        } else {
            System.out.println("Key " + '"' + key + '"' +" does not exist in the dictionary.");
        }
    }
}

```