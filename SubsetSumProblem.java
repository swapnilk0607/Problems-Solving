/**
 * 
 * @author Swapnil S. Katale 
 * 		   Subset sum problem is to find subset of elements
 *         that are selected from a given set whose sum adds up to a given
 *         number K. We are considering the set contains non-negative values. It
 *         is assumed that the input set is unique (no duplicates are
 *         presented).
 */
public class SubsetSumProblem {

	public static void main(String[] args) {
		SubsetSumProblem s = new SubsetSumProblem();
		int[] weights = { 8, 7, 5, 18, 12, 20, 15 };
		int[] solutionArray = new int[weights.length];
		boolean result = s.isSumPossible(weights, 12, 0, 0, solutionArray);
		System.out.println("Is result possible : " + result);
		if (result) {
			System.out.println("Solution is :- ");
			PrintSolution(weights, solutionArray);
		}
	}

	public static void PrintSolution(int[] numbers, int[] solution) {
		for (int i = 0; i < solution.length; i++) {
			if (solution[i] == 1) {
				System.out.print(numbers[i] + " ");
			}
		}
	}

	public boolean isSumPossible(int[] numbers, int targetSum, int currentSum,
			int currentPosition, int[] solution) {
		if (targetSum == currentSum){			
			return true;
		}

		for (int i = currentPosition; i < numbers.length; i++) {
			if (currentSum + numbers[i] <= targetSum) {
				solution[i] = 1;
				if (isSumPossible(numbers, targetSum, currentSum + numbers[i],
						i+1, solution)) {					
					return true;
				}else{
					solution[i] = 0;
				}
			}
		}
		return false;
	}

}
