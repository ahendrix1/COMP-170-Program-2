/*--------------------------------------------
    Program 2: MPLS Dog Boarding Cost Estimate
    The MPLS Dog Boarding Company in North Minneapolis is a dog day care facility that is 
    looking for a developer that will implement functionality that will determine the cost 
    of boarding fee based on information entered by client. The application will ask for the 
    name, breed, age, the number of days the dog will need care, and weight of the dog. Once 
    all information is received, the application will generate a estimate that provides the 
    estimated cost of stay, the dog's name, age, number or days, weight and boarding group.  
    The boarding group is based on the dog's age.

    
	
	There will be five requirements for Program 1
	Requirement 1 - Variables are properly declared and initialized; Use of Scanner Object to read 
                    input from console. Make use of constant final variables. When possible, make 
                    sure to declare all variables that will hold data
                    
	Requirement 2 - Input/Output of all necessary information; Correct calculation including 2% discount.
                    
    Requirement 3 - Proper structures used to determine calculated outcome and dog's boarding group; Correct Operators
    Requirement 4 - Style - Proper use of comments, spacing, in program; use of
                    descriptive variable names
    Requirement 5 - Program is submitted by the due date listed and pushed to assigned GitHub Repository; 
                    Repository contains a minimum of three commits.
	

    Course: COMP 170, Fall 1 2026
    System: GNU/Linux
    Author: Avery Hendrix
*/

//IMPORT STATEMENTS

import java.util.Scanner;

public class CostCalc {
    public static void main(String[] args) throws Exception {
        // DECLARATIONS

        final int FEESML = 45;
        final int FEEMID = 65;
        final int FEELRG = 85;
        final int FEEXXL = 100;

        final int WGTSML = 0;
        final int WGTMID = 15;
        final int WGTLRG = 31;
        final int WFTXXL = 81;

        String name, breed, group;

        int age, weight, days;
        int cost = 0;

        Double total = 0.0;

        // INSTANTIATE SCANNER OBJECT
        Scanner sc = new Scanner(System.in);

        // WELCOME MESSAGE
        System.out.println(
                "Welcome to MPLS Dog Boarding cost calculator, this application will generate a summary of cost. ");
        System.out.println("");

        // OUTPUT + INPUT OF DOG INFORMATION
        System.out.print("Enter dog name: ");
        name = sc.nextLine();

        System.out.print("Enter dog breed: ");
        breed = sc.nextLine();

        System.out.print("Enter dog weight: ");
        weight = sc.nextInt();

        System.out.print("Enter dog age: ");
        age = sc.nextInt();

        System.out.print("Enter number of days: ");
        days = sc.nextInt();
        // LOGIC TO DETERMINE ESTIMATED COST BASED ON WEIGHT
        if (weight > WFTXXL) {
            cost = FEEXXL;
        } else if (weight > WGTLRG) {
            cost = FEELRG;
        } else if (weight > WGTMID) {
            cost = FEEMID;
        } else if (weight > WGTSML) {
            cost = FEESML;
        }
        // DETERMINE ESTIMATED COST BASED ON WEIGHT AND NUMBER OF DAYS
        cost = cost * days;
        System.out.println(cost);
        // DETERMINE IF ESTIMATED COST RECEIVE A DISCOUNT

        if (cost > 165) {
            total = cost * 0.98;
        }

        System.out.println(cost);
        System.out.println(total);
        // DETERMINE DOGS BOARDING GROUP BASED ON AGE
        switch (age) {
            case 0:
                group = "BLUE";
                break;
            case 1:
            case 2:
            case 3:
            case 4:
                group = "ORANGE";
                break;
            case 5:
                group = "RED";
                break;
            default:
                group = "GREEN";
                break;
        }

        // OUTUT SUMMARY OF DOG INFO. AND ESTIMATED COST
        System.out.println(" \n ====================== \n SUMMARY \n ======================");
        System.out.println("NAME: " + name);
        System.out.println("BREED: " + breed);
        System.out.println("WEIGHT: " + weight);
        System.out.println("AGE: " + age);
        System.out.println("DAYS: " + days);
        System.out.println("GROUP: " + group);

        if (total != 0.0) {
            System.out.println("\n You qualify for a discount.");
        } else {
            total = (double) cost;
        }
        System.out.println("COST: " + total);

        sc.close();

    }
}
