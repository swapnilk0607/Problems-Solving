/**
 * 
 * @author Swapnil S. Katale
 *Problem : - 9x9 Sudoko Solver
 */
public class SudokuSolver {

	public static void main(String[] args) {
		int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                		{5, 2, 0, 0, 0, 0, 0, 0, 0},
		                {0, 8, 7, 0, 0, 0, 0, 3, 1},
		                {0, 0, 3, 0, 1, 0, 0, 8, 0},
		                {9, 0, 0, 8, 6, 3, 0, 0, 5},
		                {0, 5, 0, 0, 9, 0, 6, 0, 0},
		                {1, 3, 0, 0, 0, 0, 2, 5, 0},
		                {0, 0, 0, 0, 0, 0, 0, 7, 4},
		                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		SudokuSolver sudokuSolver = new SudokuSolver();
		boolean result = sudokuSolver.SolveSodoku(grid);
		System.out.println("Is puzzle solved.." + result);
		sudokuSolver.PrintResultantSudoku(grid);
   }

	public void PrintResultantSudoku(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public boolean SolveSodoku(int[][] grid) {
		int[] emptyLocation = FindEmptyLocation(grid);
		if (emptyLocation[0] == -1 && emptyLocation[1] == -1)
			return true;

		for (int i = 1; i <= 9; i++) {
			int row = emptyLocation[0];
			int col = emptyLocation[1];

			if (IsSafeLocation(grid, row, col, i)) {
				grid[row][col] = i;
				if (SolveSodoku(grid))
					return true;
				else
					grid[row][col] = 0;
			}
		}

		return false;
	}

	public int[] FindEmptyLocation(int[][] grid) {
		int[] position = new int[2]; // returns row,col postion

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					position[0] = i;
					position[1] = j;
					return position;
				}
			}
		}
		position[0] = -1;
		position[1] = -1;
		return position;
	}

	public boolean IsSafeLocation(int[][] grid, int row, int col, int number) {
		return CheckColumnValidity(grid, col, number)
				&& CheckRowValidity(grid, row, number)
				&& CheckBoxValidity(grid, row, col, number);
	}

	public boolean CheckColumnValidity(int[][] grid, int col, int number) {
		int length = grid.length;
		for (int i = 0; i < length; i++) {
			if (grid[i][col] == number)
				return false;
		}
		return true;
	}

	public boolean CheckRowValidity(int[][] grid, int row, int number) {
		int length = grid[row].length;
		for (int i = 0; i < length; i++) {
			if (grid[row][i] == number)
				return false;
		}
		return true;
	}

	public boolean CheckBoxValidity(int[][] grid, int row, int col, int number) {
		int startRow = (row / 3) * 3;
		int startCol = (col / 3) * 3;

		for (int i = startRow; i < (startRow + 3); i++) {
			for (int j = startCol; j < (startCol + 3); j++) {
				if (grid[i][j] == number)
					return false;
			}
		}

		return true;
	}
}
