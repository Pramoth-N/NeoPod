import java.util.*;

class SumOfSquares {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        sc.close();
        if(a<0||b<0){
            System.out.print("Invalid input");
            return;
        }
        long sum = 0;
        for(int i=a;i<=b;i++){
            sum+=Math.pow(i,2);
        }
        System.out.print(sum);
    }
}