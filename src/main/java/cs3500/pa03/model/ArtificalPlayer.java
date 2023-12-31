package cs3500.pa03.model;

import cs3500.pa03.view.GameViewer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Responsible for implementing Player for an AI player
 */
public class ArtificalPlayer extends AbstractPlayer {
  private final List<Coord> targets = new ArrayList<>();

  /**
   * Represent the name of the player
   *
   *  @return AI for AI player
   */
  public String name() {
    return "AI";
  }

  /**
   * Generates a list of shots
   *
   * @return a list of shots generated by the AI
   */
  public List<Coord> takeShots() {
    GameViewer view = new GameViewer();
    System.out.println("Opponent board data:");
    view.printBoard(super.board.getLetters(), true);

    Random rand = new Random();
    int shots = super.board.getAliveShips();
    int width = super.board.getLetters().length;
    int height = super.board.getLetters()[0].length;
    int x;
    int y;
    List<Coord> coords = new ArrayList<>();

    for (int i = 0; i < shots; i += 1) {
      x = rand.nextInt(width);
      y = rand.nextInt(height);
      while (super.alreadyShot[x][y]) {
        x = rand.nextInt(width);
        y = rand.nextInt(height);
      }
      super.alreadyShot[x][y] = true;
      coords.add(new Coord(x, y));
    }

    return coords;
  }

  /**
   * Reports to this player what shots in their previous volley returned from takeShots()
   * successfully hit an opponent's ship.
   *
   * @param shotsThatHitOpponentShips the list of shots that successfully hit the opponent's ships
   */
  public void successfulHits(List<Coord> shotsThatHitOpponentShips) {

  }
}