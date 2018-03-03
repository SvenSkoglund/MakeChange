import java.util.Scanner;

public class MakeChange {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		makeChange(ask());

	}

	private static void makeChange(double ask) {
		// TODO Auto-generated method stub
		int twenties = (int) (ask / 20);
		double twentyRemaining = ask % 20;
		
		int tens = (int) (twentyRemaining /10);
		double tenRemaining = (twentyRemaining % 10);
		
		int fives = (int) (tenRemaining /5);
		double fiveRemaining = (tenRemaining % 5);
		
		int ones = (int) (fiveRemaining /1);
		double oneRemaining = (fiveRemaining % 1);
		
		int quarters = (int) (oneRemaining / .25);
		double quartersRemaining = (oneRemaining % .25);
		
		int dimes = (int) (quartersRemaining / .1);
		double dimesRemaining = (quartersRemaining % .1);
		
		int nickels = (int) (dimesRemaining / .05);
		double nickelsRemaining = (dimesRemaining % .05);
		
		int pennies = (int) (nickelsRemaining / .01);
		double penniesRemaining = (nickelsRemaining % .01);
	
		System.out.println("$20: " + twenties);
		System.out.println("$10: " + tens);
		System.out.println("$5: " + fives);
		System.out.println("$1: " + ones);
		System.out.println("Quarters: " + quarters);
		System.out.println("Dimes: " + dimes);
		System.out.println("Nickels: " + nickels);
		System.out.println("Pennies: " + pennies);



	}

	public static double ask() {
		while (true) {
			System.out.println("Enter the cost");
			double cost = scanner.nextDouble();
			System.out.println("Enter the amount given");
			double given = scanner.nextDouble();

			double diff = given - cost;
			if (diff < 0) {
				System.out.println("You didn't pay enough. Try again!");
			} if (diff == 0) {
				System.out.println("You paid in perfect change. Goodbye!");
				System.exit(0);
			}
			return diff;
		}
	}
}
