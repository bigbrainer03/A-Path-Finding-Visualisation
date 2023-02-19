package pathfiner;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pathfinder {
  // Represents a cell in the map
  private static class Cell {
    int row;
    int col;

    Cell(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  // The map is represented as a 2D array of characters
  // 'S' represents the starting point
  // 'D' represents the destination point
  // 'X' represents an obstacle
  // '.' represents a free cell
  private static final char[][] MAP = {
    {'S', '.', '.', '.', '.', '.', '.'},
    {'.', 'X', '.', 'X', '.', 'X', '.'},
    {'.', '.', '.', '.', '.', '.', '.'},
    {'.', 'X', '.', 'X', '.', 'X', '.'},
    {'.', '.', '.', '.', '.', '.', 'D'},
  };

  private static final int ROWS = MAP.length;
  private static final int COLS = MAP[0].length;

  // Constant arrays representing the four possible directions
  private static final int[] dx = {-1, 0, 1, 0};
  private static final int[] dy = {0, 1, 0, -1};

  // The distance from the starting point to each cell
  private static int[][] distance;

  // A queue to store the cells to be visited
  private static Deque<Cell> queue = new ArrayDeque<>();

  public static void main(String[] args) {
    // Initialize the distance array with -1 for all cells
    distance = new int[ROWS][COLS];
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        distance[i][j] = -1;
      }
    }

    // Find the starting point in the map
    Cell start = null;
    for (int i = 0; i < ROWS; i++) {
      for (int j = 0; j < COLS; j++) {
        if (MAP[i][j] == 'S') {
          start = new Cell(i, j);
          break;
        }
      }
    }

    // Set the distance of the starting point to 0
    distance[start.row][start.col] = 0;

    // Add the starting point to the queue
    queue.add(start);

    // Perform breadth-first search
    while (!queue.isEmpty()) {
      Cell cell = queue.poll();

      // Check if we have reached the destination
      if (MAP[cell.row][cell.col] == 'D') {
        System.out.println("Found the destination! Distance: " + distance[cell.row][cell.col]);
        return;
      }
    

      // Explore the four