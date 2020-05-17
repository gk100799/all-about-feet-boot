package com.gksj.allaboutfeet.config;

import com.gksj.allaboutfeet.entity.User;
import com.gksj.allaboutfeet.services.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

  @Autowired
  private UserService userService;
  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain)
      throws ServletException, IOException {
    if (request.getMethod().equals("OPTIONS")) {
      chain.doFilter(request, response);
      return;
    }
    else if (!request.getServletPath().equalsIgnoreCase("/user/login") && !request.getServletPath()
        .equalsIgnoreCase("/user/signup")) {
      final String requestTokenHeader = request.getHeader("Authorization");
      String username = null;
      String jwtToken = null;
      if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
        jwtToken = requestTokenHeader.substring(7);
        try {
          username = jwtTokenUtil.getUsernameFromToken(jwtToken);
        } catch (IllegalArgumentException e) {
          System.out.println("Unable to get JWT Token");
          response.setStatus(401);
          return;
        } catch (ExpiredJwtException e) {
          System.out.println("JWT Token has expired");
          response.setStatus(401);
          return;
        } catch (Exception e) {
          System.out.println("JWT Token has expired");
          response.setStatus(401);
          return;
        }
      } else {
        logger.warn("JWT Token does not begin with JWT String");
        response.setStatus(401);
        return;
      }
      if (username != null) {
        User userDetails = this.userService.getByUsername(username);
        if (!jwtTokenUtil.validateToken(jwtToken, userDetails)) {
          response.setStatus(401);
          return;
        } else {
          chain.doFilter(request, response);
        }
      }
    }
    response.setStatus(401);
    return;

  }
}
