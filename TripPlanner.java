/*
  Produces a text for auxiliate a Vacation Planner. 
  The informations passed as input are: name, destination city, the amount of money the user pretend
  to spend on the travel, and other things.
  
  Author: Felippe Trigueiro Angelo
*/

import java.util.Scanner;
import java.text.DecimalFormat;

public class TripPlanner {
	public static void main(String args[]) {		
		greeting();	
		travelResources();
		timeDifference();
	}
	
	public static void greeting() {
		Scanner input = new Scanner(System.in);
		String name = "", travelCity = "";
		
		
		System.out.println("Welcome to Vacation Planner!");
		System.out.print("What is your name? ");
		name = input.nextLine();
		System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
		travelCity = input.nextLine();
		System.out.println("Great! " + travelCity + " sounds like a gret trip");
		System.out.println("***********\n");
		
	}
	
	public static void travelResources() {
		Scanner input = new Scanner(System.in);
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		String curLetterSymbol = "";
		int days = 0;
		double moneyUSD = 0.0, monCurrentUSD = 0.0, moneyUSDperDay = 0.0;
		
		System.out.print("How many days are you going to spend travelling? ");
		days = input.nextInt();
		System.out.print("How much money, in USD, are you planning to spend on your trip? ");
		moneyUSD = input.nextDouble();
		System.out.print("What is the three letter currency symbol for yout travel destination? ");
		curLetterSymbol = input.next();
		System.out.print("How many " + curLetterSymbol + " are in 1 USD? ");
		monCurrentUSD = input.nextDouble();	
		
		moneyUSDperDay = moneyUSD/days; //Give the amount of money that can be spended per day
		
		System.out.println("\nIf you are travelling for " + days + " that is the same as " + (24*days) + " hours or " + 
		(24*60*days) + " minutes");
		System.out.println("If you are going to spend $" + moneyUSD + " USD that means per day you can spend up to $" + 
		numberFormat.format(moneyUSDperDay) + " USD");
		System.out.println("Your total budget in " + curLetterSymbol + "is " + numberFormat.format(monCurrentUSD*moneyUSD) + " " + curLetterSymbol + " is " + numberFormat.format(monCurrentUSD*moneyUSDperDay) + " " + curLetterSymbol);
		System.out.println("*************\n");
	}
	
	public static void timeDifference() {
		Scanner input = new Scanner(System.in);
		double hourDifference = 0.0;
		
		System.out.print("What is the time difference, in hours, between your home and your destination? ");
		hourDifference = input.nextInt();
		System.out.println("That means that when it is midnight at home it will be " + String.format("%.0f:00", hourDifference) + 
		" in your travel destination and when it is noon at home it will be " + String.format("%.0f:00", 12+hourDifference));
		System.out.println("*************\n");
	}
}
