package com.core.pilot.config;

import com.core.pilot.adapter.UserRepo;
import com.core.pilot.adapter.model.User;
import com.core.pilot.config.model.UserPrinciple;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user=userRepo.findByUsername(username);
        if (user==null){
            log.info("user not found");
            throw new UsernameNotFoundException("username Not found");
        }
        return new UserPrinciple(user);
    }
}
