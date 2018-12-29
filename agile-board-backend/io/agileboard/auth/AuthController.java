package io.agileboard.auth;

import org.springframework.http.

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController {
  @RequestMapping(value = "/api/auth", method = RequestMethod.POST, produces = MediaType)
}
