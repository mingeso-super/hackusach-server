package cl.hakusach.hakusach.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import cl.hakusach.hakusach.requests.AuthUserRequest;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
           this.authenticationManager = authenticationManager;
    }
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
            try {
                
                AuthUserRequest credential = new ObjectMapper()
                                        .readValue(req.getInputStream(), AuthUserRequest.class);
                
                
                return authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    credential.getUsername(),
                                    credential.getPassword(),
                                    null)
                );
                
            }
            catch (IOException e) {
                    throw new RuntimeException(e);
            }
        
        
    }
    
    protected void successfulAuthentication(HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain,
            Authentication auth) throws IOException, ServletException {
        
        String token = Jwts.builder()
                .setSubject(((String)auth.getPrincipal()))
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes())
                .compact();
        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+ token);
        res.setHeader("Access-Control-Expose-Headers", "Authorization");
        res.setContentType("application/json");
    }
    

}