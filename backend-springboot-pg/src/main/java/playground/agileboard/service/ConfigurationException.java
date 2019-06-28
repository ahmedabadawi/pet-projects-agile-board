package playground.agileboard.service;

import java.util.Locale;

public class ConfigurationException extends RuntimeException {
  public ConfigurationException() {
    super("Required configuration is missing or invalid");
  }
  
  public ConfigurationException(final String configKey) {
    super(String.format(Locale.ROOT, "Required configuration key [%s] is missing or invalid", configKey));
  }
}
