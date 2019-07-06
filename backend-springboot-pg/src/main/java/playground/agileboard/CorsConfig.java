package playground.agileboard;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
  @Bean
  public CorsFilter corsFilter() {
    // TODO: Enhance the handling of CORS
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.setAllowCredentials(true);
    corsConfig.addAllowedOrigin("*");
    corsConfig.addAllowedHeader("*");
    corsConfig.addAllowedMethod(HttpMethod.OPTIONS);
    corsConfig.addAllowedMethod(HttpMethod.GET);
    corsConfig.addAllowedMethod(HttpMethod.POST);
    corsConfig.addAllowedMethod(HttpMethod.PUT);
    corsConfig.addAllowedMethod(HttpMethod.DELETE);
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);
    return new CorsFilter(source);
  }
}
