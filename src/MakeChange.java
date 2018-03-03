import java.util.Scanner;

public class MakeChange {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		// Here we call the ask() method to take input from the user, the ask method
		// returns the value of the difference between the cost paid and the amount
		// given, or prints an error and repeats if the user enters less paid than cost
		makeChange(ask());

	}

	// This method takes the double remainder returned by the ask() method and
	// calculates how much of each bill is needed to make change.
	// It then prints the amount of each bill/coin and also prints the total change
	// through the sampleUI(method)
	private static void makeChange(double remainder) {
		
		
		// These variables hold places for the names, values, and amount returned of
		// each bill/coin.
		String[] currencies = { "$20", "$10", "$5", "1", "Quarters", "Dimes", "Nickels", "Pennies" };
		int[] values = { 2000, 1000, 500, 100, 25, 10, 05, 01 };
		int[] returnedCurrencies = new int[8];

		// This line of code converts the double remainder into an integer in order to
		// solve errors from double inaccuracies.
		int change = (int) (Math.round(remainder * 100));

		// This variable will store the total amount of change
		double total = 0;

		// In this loop, we calculate the amount of a bill/coin that should be taken
		// from the remainder, starting with the highest bill/coin. Then we calculate
		// the amount of remainder left after removing that bill. We then repeat this
		// for the bill of the next lowest value. We also update the total with each
		// iteration through the loop
		for (int i = 0; i < currencies.length; i++) {
			returnedCurrencies[i] = (int) (change / values[i]);
			System.out.printf("%10s: %4d\n",currencies[i] ,returnedCurrencies[i]);
			change = change % values[i];
			total = total + returnedCurrencies[i] * values[i];
		}
		sampleUI("Your change is $" + total / 100);

	}

	// This method prompts the user for input for cost and amount given, then
	// calculates and returns the difference. It prints an error message and asks
	// the user to try again if the amount given is less than the cost. It also
	// recognizes if the cost and the amount paid are the same. In which case it
	// prints a message and exits the program
	
	public static double ask() {
		while (true) {
			sampleUI("Enter the cost of goods");
			double cost = scanner.nextDouble();
			sampleUI("Enter the amount given");
			double given = scanner.nextDouble();
			double remainder = given - cost;

			if (remainder < 0) {
				System.err.println("You didn't pay enough. Try again!");
				continue;
			}
			if (remainder == 0) {
				System.out.println("You paid in perfect change. Goodbye!");
				System.exit(0);
			}

			return remainder;
		}
	}

	//This method creates a border of stars around given to the method.
	public static void sampleUI(String toPrint) {
		String stars = "";
		for (int i = 0; i < toPrint.length() + 2; i++) {
			stars = stars + "*";
		}

		System.out.println(stars);
		System.out.println("*" + toPrint + "* ");
		System.out.println(stars);

	}
}
