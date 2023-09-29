package com.pradeep.rest.webservices.epasswebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static ArrayList<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  static {
    
	  inMemoryUserList.add(new JwtUserDetails(1L, "dummy",
        "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER"));
  
    inMemoryUserList.add(new JwtUserDetails(1L, "pradeep",
            "$2a$10$ReXRGd54Z3X2fCd3ioi9q.hSeauNSdNzkAFPb0F/LJP5fg3dYxNCC", "ROLE_ADMIN"));
      
    inMemoryUserList.add(new JwtUserDetails(1L, "guest",
            "$2a$10$FtK1QYvkwu0ii5Ae1u.gs.iZuq294c.djnNHTkYRapuVhK39d7yAW", "ROLE_GUEST"));
      
  
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
        .filter(user -> user.getUsername().equals(username)).findFirst();

    if (!findFirst.isPresent()) {
      throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
    }

    return findFirst.get();
  }

}


