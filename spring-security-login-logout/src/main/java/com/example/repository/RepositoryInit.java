package com.example.repository;

import com.example.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepositoryInit implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception {

        List<Role> roles = new ArrayList<>();
        Role role1 = new Role();
        role1.setRole("ADMIN");
        roles.add(role1);
        roles.stream().forEach(role -> roleRepository.save(role));
    }
}
