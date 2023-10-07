package hw2;

/**
 * This class encapsulates the logic and state for a highly simplified
 * game of American football.  
 *
 * @author Logan Gosch
 */
public class Handegg
{
  /**
   * Number of points awarded for a touchdown.
   */
  public static final int TOUCHDOWN_POINTS = 6;

  /**
   * Number of points awarded for a successful extra point attempt
   * after a touchdown.
   */
  public static final int EXTRA_POINTS = 1;

  /**
   * Number of points awarded for a field goal.
   */
  public static final int FIELD_GOAL_POINTS = 3;

  /**
   * Total length of the field from goal line to goal line, in yards.
   */
  public static final int FIELD_LENGTH = 100;

  /**
   * Initial position of the offensive team after a touchdown and extra point attempt.
   */
  public static final int STARTING_POSITION = 30;

  /**
   * Yards required to get a first down.
   */
  public static final int YARDS_FOR_FIRST_DOWN = 10;

  /**
   * Current down of the play.
   */
  private int currentDown = 1;

  /**
   * Current team on offense, 0 or 1.
   */
  private int offenseTeam = 0;

  /**
   * Current score for team 0.
   */
  private int teamZeroScore = 0;

  /**
   * Current score for team 1.
   */
  private int teamOneScore = 0;

  /**
   * Current location of the ball on the field, initially 30.
   */
  private int currentLocation = STARTING_POSITION;

  private int yardsToFirstDown = YARDS_FOR_FIRST_DOWN;

  /**
   * Adds extra points to the team's score given an attempt.
   * @param success Determines if extra-points will be received.
   */
  public void extraPoint(boolean success) {
      if (success) {
          if (whoIsOffense() == 0) {
              teamZeroScore += EXTRA_POINTS;
          }
          else {
              teamOneScore += EXTRA_POINTS;
          }
      }
      switchSidesAtCurrentLocation(FIELD_LENGTH - STARTING_POSITION);
  }

  /**
   * Records the result of a field goal attempt, adding FIELD_GOAL_POINTS points if the field goal was successful.
   * @param success Determines if the field goal was successful.
   */
  public void fieldGoal(boolean success) {
    if (success) {
      if (whoIsOffense() == 0) {
        teamZeroScore += FIELD_GOAL_POINTS;
        switchSidesAtCurrentLocation(FIELD_LENGTH - STARTING_POSITION);
      } else {
        teamOneScore += FIELD_GOAL_POINTS;
        switchSidesAtCurrentLocation(FIELD_LENGTH - STARTING_POSITION);
      }
    } else {
        switchSidesAtCurrentLocation(currentLocation);
    }
  }

  /**
   *
   Records the result of passing the ball the given number of yards, possibly resulting in a first down, a touchdown, a turnover, or an interception.
   * @param yards Number of yards to add to position.
   * @param intercepted Determines if the pass was intercepted, thus turning offense over to the other team.
   */
  public void pass(int yards, boolean intercepted) {
      if (intercepted) {
          switchSidesAtCurrentLocation(Math.min(currentLocation + yards, 100));
      } else {
          play(yards);
      }

  }

  /**
   * Records the result of running the ball the given number of yards, possibly resulting in a first down, a touchdown, or a turnover.
   * @param yards Number of yards to advance by.
   */
  public void run(int yards) {
      play(yards);
  }

  /**
   * Records the result of a punt.
   * @param yards Number of yards to advance by.
   */
  public void punt(int yards) {
      if (((currentLocation + yards) >= 0) && ((currentLocation + yards) <= 100)) {
          currentLocation += yards;
          switchSidesAtCurrentLocation(currentLocation);
      } else if ((currentLocation + yards) < 0) {
          currentLocation = 0;
          switchSidesAtCurrentLocation(currentLocation);
      } else if ((currentLocation + yards) > 100) {
          currentLocation = FIELD_LENGTH;
          switchSidesAtCurrentLocation(currentLocation);
      }
  }

    /**
     * Returns the number of yards the offense must advance the ball to get a first down.
     * @return Yards til the first down.
     */
    public int getYardsToFirstDown() {
        return yardsToFirstDown;
    }

    /**
     * Returns the points for the indicated team.
     * @param whichTeam Determines which team's score will be retrieved.
     * @return Current team's score.
     */
    public int getScore(int whichTeam) {
        if (whichTeam == 0) {
            return teamZeroScore;
        }
        else {
            return teamOneScore;
        }
    }

  /**
   * Returns the location of the ball as the number of yards from the offense's own goal line.
   * @return Current location
   */
  public int getLocation() {
    return currentLocation;
  }

  /**
   * Returns the current down.
   * @return What down it is currently.
   */
  public int whichDown() {
    return currentDown;
  }

  /**
   * Returns the index for the team currently playing offense.
   * @return Which team is on offense.
   */
  public int whoIsOffense() {
    return offenseTeam;
  }

    /**
     * Records the result of a play by the offense, abstracted to play to both a run(int) and a pass(int, bool).
     * @param yards - The yards advanced by the offense
     */
  private void play(int yards) {
      currentLocation = Math.max(currentLocation + yards, 0);
      yardsToFirstDown = getYardsToFirstDown() - yards;
      if (currentDown == 4 && getYardsToFirstDown() > 0) {
          switchSidesAtCurrentLocation(currentLocation);
      } else if (currentLocation > FIELD_LENGTH) {
          if (whoIsOffense() == 0) {
              teamZeroScore += TOUCHDOWN_POINTS;
          } else if (whoIsOffense() == 1) {
              teamOneScore += TOUCHDOWN_POINTS;
          }
      } else if (yardsToFirstDown <= 0) {
          currentDown = 1;
          yardsToFirstDown = 10;
      } else {
          currentDown++;
      }
  }

    /**
     * Switches offense team and resets instance variables referring to the play.
     * @param yards - The yards either the offense was currently at, or the yards needed to reset to STARTING_POSITION.
     */
  private void switchSidesAtCurrentLocation(int yards) {
      if (whoIsOffense() == 0) {
          offenseTeam = 1;
      }
      else {
          offenseTeam = 0;
      }
      currentLocation = 100 - yards;
      currentDown = 1;
      yardsToFirstDown = YARDS_FOR_FIRST_DOWN;
  }

}
