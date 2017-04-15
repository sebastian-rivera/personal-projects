package com.ellipticalcode.shared.impl;

import com.ellipticalcode.data.entity.role.Role;
import com.ellipticalcode.data.entity.user.User;
import com.ellipticalcode.data.repository.RoleRepository;
import com.ellipticalcode.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian Rivera on 1/22/2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    UserRepository userRepository;
    RoleRepository roleRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Long count = userRepository.count();

        if(count == 0) {

            Role role = new Role();
            role.setRoleName("ROLE_ADMIN");
            roleRepository.save(role);

            List<Role> roles = new ArrayList<>();
            roles.add(role);


            User user = new User();

            user.setPassword("admin");
            user.setUserName("admin");
            user.setAccountNonLocked(true);
            user.setAccountNonExpired(true);
            user.setCredentialsNonExpired(true);


            user.setRoles(roles);
            user.setAccountNonExpired(true);



            user.setEnabled(true);

            userRepository.save(user);

            return new UserDetailsImpl(user);

        } else {

            User user = userRepository.findByUserName(username);

            return new UserDetailsImpl(user);

        }

    }
}
