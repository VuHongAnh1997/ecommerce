package com.diepvusinhtu1.ecommerce;

import com.diepvusinhtu1.ecommerce.entity.*;
import com.diepvusinhtu1.ecommerce.entity.Role;
import com.diepvusinhtu1.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.password.*;
import org.springframework.web.servlet.config.annotation.*;

import java.util.*;

@SpringBootApplication
public class EcommerceApplication {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

//            Optional<Role> role = roleRepository.findById(1L);
//            User user = new User();
//            user.setRole(role.get());
//            user.setUpdatedAt(new Date().toInstant());
//            user.setFullName("Vũ Hồng Anh");
//            user.setEmail("diepvusinhtu1@gmail.com");
//            user.setDeleted(0);
//            user.setAddress("47 Vũ Trọng Phụng");
//            user.setPassword(passwordEncoder.encode("honganh97"));
//            user.setCreatedAt(new Date().toInstant());
//            user.setUsername("0392707516");
//            user.setId(1L);
//            userRepository.save(user);

//            Optional<Role> role = roleRepository.findById(2L);
//            User user = new User();
//            user.setRole(role.get());
//            user.setUpdatedAt(new Date().toInstant());
//            user.setFullName("Nguyễn Hương Thảo");
//            user.setEmail("vuhonganh250797@gmail.com");
//            user.setDeleted(0);
//            user.setAddress("Phạm Ngọc Thạch");
//            user.setPassword(passwordEncoder.encode("anhyeuem"));
//            user.setCreatedAt(new Date().toInstant());
//            user.setUsername("0392707514");
//            user.setId(2L);
//            userRepository.save(user);
        };
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }
        };
    }

}
