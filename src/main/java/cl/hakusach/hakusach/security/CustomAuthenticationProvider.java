package cl.hakusach.hakusach.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;



import cl.hakusach.hakusach.repositories.AlumnoRepository;
import cl.hakusach.hakusach.repositories.ProfesorRepository;

import cl.hakusach.hakusach.models.Alumno;
import cl.hakusach.hakusach.models.Profesor;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private AlumnoRepository alumnoRepository;

    @Autowired
    private ProfesorRepository profesorRepository; 


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Alumno alumno = alumnoRepository.findByUsername(authentication.getName());
        Profesor profesor = profesorRepository.findByUsername(authentication.getName());

        String name = null;
        String password = null;
        String autority = null; // Fix as a Constant or Property

        if (profesor != null) {
            name = profesor.getUsername();
            password = profesor.getPassword();
            autority = "profesor";
        }
        else if (alumno != null) {
            name = alumno.getUsername();
            password = alumno.getPassword();
            autority = "alumno";
        }
        else {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        if(password.compareTo(authentication.getCredentials().toString()) != 0) {
            throw new UsernameNotFoundException("Usuario no encontrado.");
        }
        
        List<GrantedAuthority> autorities = new ArrayList<>();
        autorities.add(new  SimpleGrantedAuthority(autority));

        return new UsernamePasswordAuthenticationToken(name, password, autorities);
    }

    @Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}


}