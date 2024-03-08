package com.github.denisdff.warmtables.Dao;

import com.github.denisdff.warmtables.Entity.UserEntity;
import com.github.denisdff.warmtables.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDao {

    private final UserRepository userRepository;

    @Autowired
//    @Qualifier("JdbcUserDetailsManager")
    private UserDetailsService userDetailsService;



    @Autowired
    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity save(UserEntity user) {
        UserDetails ud = User.withDefaultPasswordEncoder()
                .username(user.getUsername())
                        .password(user.getPassword())
                        .roles("USER")
                        .build();
        ((JdbcUserDetailsManager)userDetailsService).createUser(ud);
        return user;
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
