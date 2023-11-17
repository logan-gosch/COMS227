package mini3.maze_ui;

import java.util.Scanner;

import mini3.maze_api.CellStatus;
import mini3.maze_api.MazeCell;
import mini3.maze_api.MazeObserver;
import mini3.maze_api.TwoDMaze;
import mini3.MazeExplorer;

/**
 * Simple console UI for the MazeExplorer.  Attaches an observer to
 * the maze so that user has to press ENTER for next cell update.
 */
public class ConsoleUI
{
  
  
  public static void main(String[] args)
  {
    TwoDMaze maze = new TwoDMaze(RunSearcher.MAZE1);
    MazeObserver observer = new ConsoleObserver(maze);
    printMaze(maze);
    System.out.println();
    MazeExplorer.search(maze, maze.getStartRow(), maze.getStartColumn());
  }
  
  
  /**
   * Prints the given grid in text form.
   * @param maze
   *   grid to be printed
   */
  public static void printMaze(TwoDMaze maze)
  {
    for (int row = 0; row < maze.getNumRows(); row += 1)
    {
      for (int col = 0; col < maze.getNumColumns(); col += 1)
      {
        MazeCell c = maze.getCell(row, col);
        CellStatus s = c.getStatus();              
        char ch = ' ';
        if (c.isWall())
        {
          ch = '#';
        }
        else if (c.isGoal())
        {
          ch = '$';
        }
        else
        {
          switch(s)
          {
            case SEARCHING_DOWN:
            {
              ch = 'v';
              break;
            }
            case SEARCHING_LEFT:
            {
              ch = '<';
              break;
            }
            case SEARCHING_UP:
            {
              ch = '^';
              break;
            }
            case SEARCHING_RIGHT:
            {
              ch = '>';
              break;
            }
            case FOUND_IT:
            {
              ch = '*';
              break;
            }
            case DEAD_END:
            {
              ch = 'x';
              break;
            }
            default:
          }
        }
        System.out.print(ch);
      }
      System.out.println();
    }
  }
}

/**
 * Implementation of GridObserver that prints out the maze
 * and then waits for user to press ENTER before continuing
 * to next step of search.
 */

class ConsoleObserver implements MazeObserver
{
  private TwoDMaze maze;
  private Scanner scanner = new Scanner(System.in);
  public ConsoleObserver(TwoDMaze givenMaze)
  {
    maze = givenMaze;
    maze.setObserver(this);
  }
  
  @Override
  public void statusChanged(MazeCell cell)
  {
    ConsoleUI.printMaze(maze);
    CellStatus status = maze.getCell(maze.getStartRow(), maze.getStartColumn()).getStatus();
    if (status != CellStatus.FOUND_IT && status != CellStatus.DEAD_END)
    {
      System.out.println("Press ENTER to continue...");
      scanner.nextLine();
    }
  }    
}
