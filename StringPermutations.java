/**
 * 
 * @author Swapnil S. Katale Problem :- Write a program to print all
 *         permutations of a given string
 */
public class StringPermutations {

	public static void main(String[] args) {
		StringPermutations sp = new StringPermutations();
		sp.doPermutation("ABCD".toCharArray(), 0);
		System.out.println("----------END----------------");
	}	

	public void doPermutation(char[] input, int currentPosition) {		
		if (null == input)
			return;

		if (currentPosition == input.length - 1) {
			System.out.println(input);
			return;
		}

		for (int i = currentPosition; i < input.length; i++) {
			Swap(input, currentPosition, i);
			doPermutation(input, currentPosition + 1);
			Swap(input, currentPosition, i);
		}		
	}

	public static void Swap(char[] input, int index1, int index2) {
		char temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}

}
