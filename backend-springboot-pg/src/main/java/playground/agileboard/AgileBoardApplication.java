package playground.agileboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("playground.agileboard")
public class AgileBoardApplication {
  public static void main(String[] args) {
    SpringApplication.run(AgileBoardApplication.class, args);
  }
}
