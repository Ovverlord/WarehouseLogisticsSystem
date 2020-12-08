package com.bsuir.WarehouseManagementSystem.service;

import com.bsuir.WarehouseManagementSystem.model.Role;
import com.bsuir.WarehouseManagementSystem.model.User;
import com.bsuir.WarehouseManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByLogin(login);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveUser(User user){
        User updatedUser = userRepository.findById(user.getId()).orElseThrow();
        updatedUser.setLogin(user.getLogin());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setFullName(user.getFullName());
        userRepository.save(updatedUser);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
//    public void saveUser(User user, String username, Map<String,String> form){
//        user.setLogin(username);
//
//        Set<String> roles = Arrays.stream(Role.values())
//                .map(Role::name)
//                .collect(Collectors.toSet());
//
//        user.getRoles().clear();
//
//        for (String key : form.keySet()) {
//            if (roles.contains(key)) {
//                user.getRoles().add(Role.valueOf(key));
//            }
//        }
//
//        userRepository.save(user);
//    }
}
