import java.util.*;

class OddPyramid{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if(n<=0){
            System.out.println("Invalid input");
            return;
        }
        int num =1;
        for(int i=1;i<=n;i++){
            if(i!=n)
            System.out.printf("%"+(n-i)+"s","");
            for(int j=1;j<=i;j++){
                System.out.printf("%d ",num);
                num+=2;
            }
            System.out.println();
            
        }
    }
}