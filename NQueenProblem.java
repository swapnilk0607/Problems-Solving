import java.util.Scanner;

public class NQueenProblem {

	public static void main(String[] args) {
		NQueenProblem nqueen = new NQueenProblem();
		System.out.print("Enter Board Length :- ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int[][] board = new int[n][n];
		if (nqueen.solveNqueen(board, board.length, 0)) {
			printSolution(board);
			return;
		}
		System.out.println("Solution dosen't exist");
	}

	public boolean solveNqueen(int[][] grid, int n, int row) {
		if (row == n)
			return true;
		for (int i = 0; i < n; i++) {
			if (isSafeToPlace(grid, row, i, n)) {
				grid[row][i] = 1;
				if (solveNqueen(grid, n, row + 1)) {
					return true;
				} else {
					grid[row][i] = 0;
				}
			}
		}
		return false;
	}

	public static void printSolution(int grid[][]) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 1)
					System.out.print("Q  ");
				else
					System.out.print("0  ");
			}
			System.out.println();
		}
	}

	public boolean isSafeToPlace(int[][] grid, int row, int col, int n) {
		int i, j;

		for (i = 0; i < row; i++)
			if (grid[i][col] == 1)
				return false;

		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (grid[i][j] == 1)
				return false;

		for (i = row, j = col; j >= 0 && i < n; i++, j--)
			if (grid[i][j] == 1)
				return false;

		return true;
	}
}
