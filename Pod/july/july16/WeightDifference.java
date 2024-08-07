import java.util.*;

class WeightDifference{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        System.out.println("Heaviest piece weight: " + max);
        System.out.println("Lightest piece weight: " + min);
        System.out.println("Weight difference: " + (max - min));
    }
}