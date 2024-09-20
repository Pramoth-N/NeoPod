import java.util.*;

public class ReverseArrayOnKintervels {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // getline(cin,s);
        int k = sc.nextInt();
        String str[] = s.split(" ");
        int n=str.length ;
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            try{
                nums[i] = Integer.parseInt(str[i]);
            } catch (Exception ex){
                System.out.println("Invalid input");
                return ;
            }
        }
        for(int i=0;i<n;i+=k){
            reverse(nums,i,k);
        }
        for(int x : nums){
            System.out.printf("%d ",x);
        }
    }
    
    private static void reverse(int[] nums , int i, int k){
        k+=i -1;
        k = Math.min(k,nums.length - 1);
        while(i<k){
            int t = nums[i];
            nums[i] = nums[k];
            nums[k] = t;
            i++;
            k--;
        }
    }

}
