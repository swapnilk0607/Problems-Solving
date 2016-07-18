/**
 * 
 * @author Swapnil S. Katale 
 * Problem :-
 * A Maze is given as N*N binary matrix of blocks where source
 * block is the upper left most block i.e., maze[0][0] and destination
 * block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts
 * from source and has to reach destination. The rat can move only in
 * two directions: forward and down. In the maze matrix, 0 means the
 * block is dead end and 1 means the block can be used in the path from
 * source to destination. Note that this is a simple version of the
 * typical Maze problem. For example, a more complex version can be that
 * the rat can move in 4 directions and a more complex version can be
 * with limited number of moves.
 */
public class MazeRunner {

	public static void main(String[] args) {
		int[][] maze = { 
						{ 1, 0, 0, 0 },
						{ 1, 1, 0, 1 },
						{ 0, 1, 0, 0 },
						{ 1, 1, 1, 1 } 
					   };

		int[][] solution = new int[maze.length][maze[0].length];
		MazeRunner mazeRunner = new MazeRunner();
		boolean result = mazeRunner.MazeSolver(maze, 0, 0, solution);
		System.out.println("Is maze solvable : " + result);
		mazeRunner.PrintMazePath(solution);
	}

	public void PrintMazePath(int[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}

	public boolean MazeSolver(int[][] maze, int x, int y, int[][] solution) {
		if (x == maze.length - 1 && y == maze.length - 1) {
			solution[x][y] = 1;
			return true;
		}

		if (!IsSafeMove(maze, x, y)) {
			return false;
		}
		solution[x][y] = 1;
		if (MazeSolver(maze, x + 1, y, solution)) {
			return true;
		}

		if (MazeSolver(maze, x, y + 1, solution)) {
			return true;
		}

		solution[x][y] = 0;
		return false;
	}

	public boolean IsSafeMove(int[][] maze, int x, int y) {
		if (x < 0 || x > maze[0].length - 1 || y < 0 || y > maze.length - 1
				|| maze[x][y] == 0)
			return false;
		else
			return true;
	}

}
