package games.driftingpixel.gamestore.models.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import games.driftingpixel.gamestore.models.db.store.GameInStoreAvailability;

public class GameNotAvailableException extends java.lang.RuntimeException {

  private List<GameInStoreAvailability> games;

  public GameNotAvailableException(List<GameInStoreAvailability> games){
    super();
    this.games = games;
  }
  
  @Override
  public String getMessage(){
     String message = games
                      .stream()
                      .map(game -> game.getGame().getName())
                      .collect(Collectors.joining(","));

     return String.format("Games [$s] is unavailable", message);
  }
  
 }
 