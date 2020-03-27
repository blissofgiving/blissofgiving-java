package com.blissofgiving.filter;

import com.blissofgiving.config.security.BlissofgivingUserDetailServiceImpl;
import com.blissofgiving.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class BlissofgivingRequestFilter extends OncePerRequestFilter {

    private static String BEARER = "Bearer ";

    @Autowired
    JWTUtil jwtUtil;

    @Autowired
    BlissofgivingUserDetailServiceImpl blissofgivingUserDetailService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        //Fetch JWT token
        String username = null;
        String jwtToken = null;

        if(authorizationHeader != null && authorizationHeader.startsWith(BEARER)){
            jwtToken = authorizationHeader.substring(BEARER.length());
            username = jwtUtil.extractUserName(jwtToken);
        }

        //Validate token and set into the security context
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = blissofgivingUserDetailService.loadUserByUsername(username);
            if(jwtUtil.validateToken(jwtToken, userDetails)){
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        //Forward to next filter
        filterChain.doFilter(request, response);
    }
}
