/*
 * 
You are given a list of food items, where each item is categorized into one of three types: Fruit, Vegetable, or Dalry. 
Each item has a specified quantity and calorie count per unit. 
Print the total calorie intake. 
Input Format 
    The first line contains an integer sunItems representing the number of food Iterns. 
    Each of the following lines contains a string type representing the type of food (Frult, Vegetable, Dalry), 
    followed by two integers representing quantity and colories respectively. 
Output Format 
    •Print an integer representing the total calorie intake from all food items. 
Constraints is numitems $20 1s quantity ≤ 1000 *1s calories ≤ 1000 
Sample Input 1: 
    3 
    Fruit 2 50 
    Vegetable 3 30 
    Dairy 1 100
    Sample Output 1: 290 
 * 
 */

 import java.util.*;
class CalorieIntake {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String type = "Fruit Vegetable Dairy";
        int n = sc.nextInt();
        String name;
        int qty,cal,calorie = 0;;
        for(int i=0;i<n;i++){
            name = sc.next();
            qty = sc.nextInt();
            cal = sc.nextInt();
            if(!type.contains(name)){
                System.out.print("Invalid input");
                return;
            }
            
            calorie += qty*cal;
        }
        System.out.print(calorie);
    }
}