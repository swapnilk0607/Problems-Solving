import java.util.Scanner;
/**
 * 
 * @author Swapnil S. Katale
 *Problem : Multiplication of two numbers using old school method
 */
public class LargeMultiplier {

	public static void main(String[] args) {
		int a = 12, b = -24, x;
		String[] multiplier;
		int[] result = new int[200];
		System.out.println("Enter 2 numbers:");
		Scanner sc = new Scanner(System.in);
		System.out.print("1st number:-");
		a = sc.nextInt();
		System.out.print("2nd number:-");
		b = sc.nextInt();
		sc.close();
		multiplier = (b + "").toString().split("");
		int tmp = 0;
		int length = multiplier.length - 1;
		for (int i = length, j = 0; i > 0; i--, j++) {
			x = a * (Integer.parseInt(multiplier[i])) + tmp;
			result[j] = x % 10;
			tmp = x / 10;
		}

		while (tmp > 0) {
			result[length++] = tmp % 10;
			tmp /= 10;
		}

		for (int i = length - 1; i >= 0; i--) {
			System.out.print(result[i]);
		}
		System.out.println();
	}

}
