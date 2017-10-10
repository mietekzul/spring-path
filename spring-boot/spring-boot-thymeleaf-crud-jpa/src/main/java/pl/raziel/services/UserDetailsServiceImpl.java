package pl.raziel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.raziel.entities.User;
import pl.raziel.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User currentUser = userRepository.findByUsername(username);

        UserDetails user = new org.springframework.security.core.userdetails.User(
                username, currentUser.getPasswordHash(), true, true, true, true, AuthorityUtils.createAuthorityList(currentUser.getRole()));
        System.out.println("ROLE: " + currentUser.getRole());

        return user;
    }
}
