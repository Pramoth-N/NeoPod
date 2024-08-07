/*
 You are given a list of developers, each with information about their name, programming language, the number of projects 
 they have completed, and their years of experience. 
 Your task is to find the most experienced developer based on a specific criterion.
 Input Format 
 An Integer representing the number of programmers. 
 For each programmer. 
    a. A string representing the name of the programmer. 
    b.A string representing the programming language they use. 
    c. An Integer representing the number of projects completed. 
    d. An Integer representing the years of experience. 
    Output Format  
    Print the name of the most experienced developer. 
    If the input is invalid, print "Invalid Input. 
 Constrainte 
    1<= length of name , programminglanguages <= 1000
    0<= prolectsCompleted, vearsOfExperiences <= 1000
 */
import java.util.*;

public class ExperiencedDeveloper {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=0){
            System.out.println("Invalid input");
            return;
        }
        String experienceddev = "";
        int experience = 0;
        while(n-- > 0) {
            sc.nextLine();
            String name = sc.nextLine();
            String lang = sc.nextLine();
            int projects = sc.nextInt();
            int exp = sc.nextInt();
            
            if(projects < 0 || exp < 0 || name.replace(" ","").length() <=0 || lang.replace(" ","").length() <= 0){
                System.out.println("Invalid input");
                return;
            }
            if(projects / exp > experience){
                experience = projects/exp;
                experienceddev = name;
            }
        }
        
        System.out.println(experienceddev);
    }
}
}
