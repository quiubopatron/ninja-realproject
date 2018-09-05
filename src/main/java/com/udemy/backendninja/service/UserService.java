package com.udemy.backendninja.service;

import com.udemy.backendninja.entity.UserRole;
import com.udemy.backendninja.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;


    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // Llamara automaticamente al repository UserRepository metodo findByUsername

        com.udemy.backendninja.entity.User user  = userRepository.findByUsername(username);

        List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());

        return buildUser(user, authorities);
    }



    private User buildUser(com.udemy.backendninja.entity.User user, List<GrantedAuthority> authorities) {

        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }


    /**
     * Convierte los roles de la aplicacion en  una lista de GrantedAuthority que es lo que necesita spring
     * @param userRoles
     * @return
     */
    private List<GrantedAuthority> buildAuthorities (Set<UserRole> userRoles ) {

        Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();

        for (UserRole userRole : userRoles) {
            auths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<GrantedAuthority>(auths);
    }

}
