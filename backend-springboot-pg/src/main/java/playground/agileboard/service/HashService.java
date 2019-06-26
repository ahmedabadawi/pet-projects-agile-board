package playground.agileboard.service;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class HashService {

  public HashService() {}
  
  public String hash(String value) {
    return new String(DigestUtils.md5Digest(value.getBytes()));
  }
}
