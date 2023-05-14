package com.zara.technical.domain.exception;

/**
 * Generic custom exception that must be thrown when not found price entity.
 */
public class NotFoundPriceException extends RuntimeException{

  private static final long serialVersionUID = 2099558255962178397L;

  /**
   * Instances a new object with the message by default.
   */
  public NotFoundPriceException() { this("Price entity not found for requested params."); }

  /**
   * Instances a new object with given message.
   *
   * @param message Exception's message.
   */
  public NotFoundPriceException(final String message) { super(message); }

}
