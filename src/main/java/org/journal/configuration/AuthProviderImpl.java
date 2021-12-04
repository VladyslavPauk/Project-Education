package org.journal.configuration;

import org.journal.model.Teacher;
import org.journal.service.StudentService;
import org.journal.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.journal.model.Student;
import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProviderImpl implements AuthenticationProvider {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        Student student = studentService.getStudent(email);
        Teacher teacher = teacherService.getTeacher(email);

        int count = 0;

        if (student != null) {
            if (passwordEncoder.matches(password, student.getPassword())) {
                count = 1;
            } else throw new BadCredentialsException("Bad credentials");
        }

        if (teacher != null) {
            if (passwordEncoder.matches(password, teacher.getPassword())) {
                count = 2;
            } else throw new BadCredentialsException("Bad credentials");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (count == 1) {
            return new UsernamePasswordAuthenticationToken(student, null, grantedAuthorities);
        } else return new UsernamePasswordAuthenticationToken(teacher, null, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
