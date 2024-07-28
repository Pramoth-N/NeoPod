import java.util.*;

class MissingNumber{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        for(int i=1;i<=n;i++) {
            if(i != sc.nextInt()) {
                System.out.println(i);
                return;
            }
        }
        
        System.out.println("No missing seat number found in the classroom.");
    }
}