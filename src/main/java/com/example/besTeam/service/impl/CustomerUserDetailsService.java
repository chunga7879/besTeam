//package com.example.besTeamAt.service.impl;
//
//import com.example.besTeamAt.data.dao.UserDAO;
//import lombok.AllArgsConstructor;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.security.core.userdetails.User;
//
//import javax.transaction.Transactional;
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//@AllArgsConstructor
//public class CustomerUserDetailsService implements UserDetailsService {
//    private final UserDAO userDAO;
//
//    @Override
//    @Transactional
//    public UserDetails loadUserByUsername(String id) {
//
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//
//        com.example.besTeamAt.data.entity.User user = userDAO.findById(Long.valueOf(id));
//
//        if (user != null) {
//            grantedAuthorities.add(new SimpleGrantedAuthority("USER")); // USER 라는 역할을 넣어준다.
//            return new User(Long.toString(user.getId()), user.getPassword(), grantedAuthorities);
//        } else {
//            throw new UsernameNotFoundException("can not find User : " + id);
//        }
//    }
//}
