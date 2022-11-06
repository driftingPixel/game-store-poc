package games.driftingpixel.gamestore.models.db.store;

public enum OrderStatus {
  /**
   * When user is adding games to cart
   */
  IN_CART,
  /**
   * Order is finished
   */
  FINISHED,
  /**
   * When user is not updated cart by 1h (additional cron mechanism can check by startDate in order)
   */
  ABANDONED,
  /**
   * User cancel the cart. May be needed for statistical purposes
   */
  CANCELED
}
