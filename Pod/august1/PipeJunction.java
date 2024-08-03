/*
 * 
 * 
 * 
 * Given a junction with a incoming pipes and outgoing pipes, each having a rated capacity and a rust factor &, determine if the junction is balanced or not. 
 * The junction is balanced if the sum of the actual capacities of the Incoming pipes is equal to the sum of the actual capacities of the outgoing pipes. 
 * If the Junction is not balanced, calculate the rated capacity of an additional pipe needed to balance the junction, 
 * considering the rust factor. Input the number of incoming and outgoing pipes, their rated capacities, 
 * and the rust factor. Input Format • Three integers representing the number of Incoming (1), and outgoing pipes (M), 
 * and rustFactor (R). ⚫ax integers represent the rated capacities of Incoming pipes.
 *  • Integers representing the rated capacities of outgoing pipes. Output Format Print "Balanced" if the junction is already balanced. 
 * I An integer, with a negative value for an outgoing pipe and a positive value for an incoming pipe, 
 * If it is not balanced. - • If the any of input is non-integer, print "Invalid input".
 *  • If the values of it, and are less than or equal to zero, print "-1".

Constraints 
-15<= N,M<= 15 0<R <=10 
1<= elements <= 1000
 Explanation: 
 Rated capacities of incoming and out coming pipes are (10, 15, 20), (8, 12, 25) with 3 Input pipes and 3 output pipes, 
 each having a rust factor of 2, the actual capacities are 8, 13, 18 for input pipes and 6, 10, 23 for output pipes. 
 The total actual capacity for input pipes is 39 (sum of 8+13+18), and for output pipes, it is also 39 (sum of 6+10+23). 
 Since the total actual capacities for both input and output pipes are equal, the system is balanced, resulting in the output: "Balanced".

 * 
 * 
 * 
 */


 import java.util.*;
class PipeJunction{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        try{
        int input = sc.nextInt();
        int output = sc.nextInt();
        int rush = sc.nextInt();
        if(input <=0 || output<=0 || rush<0){
            System.out.print(-1);
            return;
        }
        int inpipe[] = new int[input];
        int outpipe[] = new int[output];
        for(int i=0;i<input;i++) {
            inpipe[i] = sc.nextInt();
        }
        for(int i=0;i<output;i++) {
            outpipe[i] = sc.nextInt();
        }
        int insum =0 , outsum =0;
        for(int i=0;i<input;i++) {
            insum += inpipe[i] ;
        }
        for(int i=0;i<output;i++) {
            outsum += outpipe[i];
        }
        
        if(insum == outsum){
            System.out.print("Balanced");
        } else{
            System.out.print(outsum - insum);
        }
        }catch(Exception ex){
            System.out.print("Invalid input");
        }
    }
}


