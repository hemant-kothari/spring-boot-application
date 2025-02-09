package com.example.solarsystem.service;

import com.example.solarsystem.model.User;
import com.example.solarsystem.model.UserProfile;
import com.example.solarsystem.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            user.getRoles().stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet())
        );
    }

    @Transactional
    public User registerUser(String username, String email, String password, boolean isAdmin) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already exists");
        }
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(isAdmin ? Set.of("ROLE_ADMIN", "ROLE_USER") : Set.of("ROLE_USER"));

        UserProfile profile = new UserProfile();
        profile.setUser(user);
        user.setProfile(profile);

        return userRepository.save(user);
    }

    public boolean toggleUserStatus(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        user.setEnabled(!user.isEnabled());
        userRepository.save(user);
        return user.isEnabled();
    }

    public User getUserByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserByUsername'");
    }
}





// package com.example.solarsystem.service;

// import com.example.solarsystem.model.User;
// import com.example.solarsystem.model.UserProfile;
// import com.example.solarsystem.repository.UserRepository;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import java.util.Set;
// import java.util.stream.Collectors;

// @Service
// public class UserService implements UserDetailsService {
//     private final UserRepository userRepository;
//     private final PasswordEncoder passwordEncoder;

//     public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//         this.userRepository = userRepository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         User user = userRepository.findByUsername(username)
//             .orElseThrow(() -> new UsernameNotFoundException("User not found"));

//         return new org.springframework.security.core.userdetails.User(
//             user.getUsername(),
//             user.getPassword(),
//             user.getRoles().stream()
//                 .map(SimpleGrantedAuthority::new)
//                 .collect(Collectors.toSet())
//         );
//     }

//     @Transactional
//     public User registerUser(String username, String email, String password, boolean isAdmin) {
//         if (userRepository.existsByUsername(username)) {
//             throw new RuntimeException("Username already exists");
//         }
//         if (userRepository.existsByEmail(email)) {
//             throw new RuntimeException("Email already exists");
//         }

//         User user = new User();
//         user.setUsername(username);
//         user.setEmail(email);
//         user.setPassword(passwordEncoder.encode(password));
//         user.setRoles(isAdmin ? Set.of("ROLE_ADMIN", "ROLE_USER") : Set.of("ROLE_USER"));

//         UserProfile profile = new UserProfile();
//         profile.setUser(user);
//         user.setProfile(profile);

//         return userRepository.save(user);
//     }

//     public boolean toggleUserStatus(Long userId) {
//         User user = userRepository.findById(userId)
//             .orElseThrow(() -> new RuntimeException("User not found"));
//         user.setEnabled(!user.isEnabled());
//         userRepository.save(user);
//         return user.isEnabled();
//     }

//     public User getUserByUsername(String username) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getUserByUsername'");
//     }
// }





// package com.example.solarsystem.service;

// import com.example.solarsystem.model.User;
// import com.example.solarsystem.model.UserProfile;
// import com.example.solarsystem.repository.UserRepository;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import java.util.Collections;

// @Service
// public class UserService implements UserDetailsService {
//     private final UserRepository userRepository;

//     public UserService(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         User user = userRepository.findByUsername(username)
//             .orElseThrow(() -> new UsernameNotFoundException("User not found"));

//         return new org.springframework.security.core.userdetails.User(
//             user.getUsername(),
//             user.getPassword(),
//             Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
//         );
//     }

//     @Transactional
//     public User registerUser(String username, String email, String password) {
//         if (userRepository.existsByUsername(username)) {
//             throw new RuntimeException("Username already exists");
//         }
//         if (userRepository.existsByEmail(email)) {
//             throw new RuntimeException("Email already exists");
//         }

//         User user = new User();
//         user.setUsername(username);
//         user.setEmail(email);
//         user.setPassword(password);  // Store password as-is

//         UserProfile profile = new UserProfile();
//         profile.setUser(user);
//         user.setProfile(profile);

//         return userRepository.save(user);
//     }
// }
