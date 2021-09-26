package work.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import work.model.Student;
import work.service.StudentServiceImp;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProviderImpl implements AuthenticationProvider {
    @Autowired
    StudentServiceImp studentServiceImp;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        Student student = studentServiceImp.getStudent(email);
        if(student == null) {
            throw new UsernameNotFoundException("student not found");
        }
        String password = authentication.getCredentials().toString();
        if(!passwordEncoder.matches(password, student.getPassword())) {
            throw new BadCredentialsException("Bad credentials");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        return new UsernamePasswordAuthenticationToken(student,null,grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
