package com.diepvusinhtu1.ecommerce.service;

import com.diepvusinhtu1.ecommerce.entity.User;
import com.diepvusinhtu1.ecommerce.repository.*;
import com.diepvusinhtu1.ecommerce.security.model.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }
}
