package games.driftingpixel.gamestore.models.exceptions;

  
public class WrongIdException extends java.lang.RuntimeException {
  
 @Override
 public String getMessage(){
    return "Element with request id, does not exist";
 }
}
