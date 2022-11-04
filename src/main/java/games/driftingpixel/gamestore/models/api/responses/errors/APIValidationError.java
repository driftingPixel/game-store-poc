package games.driftingpixel.gamestore.models.api.responses.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
class APIValidationError extends AbstractApiSubError {
   private String object;
   private String field;
   private Object rejectedValue;
   private String message;

   APIValidationError(String object, String message) {
       this.object = object;
       this.message = message;
   }
}