import java.util.Scanner;

public class MakeChange {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// Amount: .67, Tendered: .50, Result: Error message
		// Amount: .67, Tendered: 1.00, Result: 1 quarter, 1 nickel, 3 pennies.
		// Amount: .59, Tendered: 1.00, Result: 1 quarter, 1 dime, 1 nickel, 1 penny.
		// Amount: 3.96, Tendered: 20.00, Result: 1 ten dollar bill, 1 five dollar bill,
		// 1 one dollar bill, 4 pennies.
		// Amount: any amount less than 20.00, Tendered: anything greater than amount:
		// correct denominations for correct change.
		makeChange(ask());

	}

	private static void makeChange(double remainder) {

		String[] currencies = { "$20", "$10", "$5", "1", "Quarters", "Dimes", "Nickels", "Pennies" };
		int[] values = { 2000, 1000, 500, 100, 25, 10, 05, 01 };
		int[] returnedCurrencies = new int[8];
		int change = (int) (Math.round(remainder * 100));
		double total = 0;
		for (int i = 0; i < currencies.length; i++) {
			returnedCurrencies[i] = (int) (change / values[i]);
			System.out.println(currencies[i] + ": " + returnedCurrencies[i]);
			change = change % values[i];
			total = total + returnedCurrencies[i] * values[i];
		}
		sampleUI("Your change is $" + total / 100);

	}

	public static double ask() {
		while (true) {
			sampleUI("Enter the cost of goods");
			double cost = scanner.nextDouble();
			sampleUI("Enter the amount given");
			double given = scanner.nextDouble();
			double diff = given - cost;
			
			if (diff < 0) {
				System.err.println("You didn't pay enough. Try again!");
				continue;
			}
			if (diff == 0) {
				System.out.println("You paid in perfect change. Goodbye!");
				System.exit(0);
			}

			return diff;
		}
	}

	public static void sampleUI(String toPrint) {
		String stars = "";
		for (int i = 0; i < toPrint.length()+2; i++) {
			stars = stars + "*";
		}

		System.out.println(stars);
		System.out.println("*" + toPrint + "* ");
		System.out.println(stars);

	}
}
