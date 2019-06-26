package playground.agileboard.service;

public class AuthenticationException extends Exception {
  public AuthenticationException() {
    super("Invalid Credentials");
  }
  
  public AuthenticationException(final String message) {
    super(message);
  }
  
  public AuthenticationException(final Throwable e) {
    super(e);
  }
  
  public AuthenticationException(final String message, final Throwable e) {
    super(message, e);
  }
}
