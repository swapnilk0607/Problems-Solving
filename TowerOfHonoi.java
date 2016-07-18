/**
 * 
 * @author Swapnil S. Katale
 *Problem : - Tower of Honoi problem
 */
public class TowerOfHonoi {
	static int moves = 0;

	public static void main(String[] args) {
		int m = ToH(3, "A", "B", "C");
		System.out.println("Moves Count :- " + moves);
		System.out.println("Moves via Recursion:- " + m);
	}

	public static int ToH(int n, String source, String aux, String dest) {
		int x, y;
		if (n == 1) {
			moves++;
			System.out.println("Move disk " + n + " from " + source + " to "
					+ dest);
			return 1;
		} else {
			x = ToH(n - 1, source, dest, aux);
			moves++;
			System.out.println("Move disk " + n + " from " + source + " to "
					+ dest);
			y = ToH(n - 1, aux, source, dest);
		}
		return x + y + 1;
	}
}
