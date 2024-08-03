import java.util.*;

class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=0){
            System.out.println("Invalid input");
            return;
        }
        int a[][]= new int[n][n]; 
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int k = sc.nextInt();
                if(k != 0 && k != 1){
                    System.out.println("Invalid input");
                    return;
                }
                a[i][j] = k;
            }
        }
        sc.close();
        
        boolean[] v = new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j] == 1){
                    v[i] = true;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(!v[i]){
                System.out.print("Not Connected");
                return;
            }
        }
        System.out.println("Connected");
        
    }
}