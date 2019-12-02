package com.sreyes.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sreyes.model.RoleEntity;
import com.sreyes.model.UserEntity;
import com.sreyes.repositories.RoleRepository;
import com.sreyes.repositories.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException(username);

        RoleEntity role = roleRepository.getOne(user.getRole());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()));        
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}

