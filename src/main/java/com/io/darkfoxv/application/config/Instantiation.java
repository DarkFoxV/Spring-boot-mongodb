package com.io.darkfoxv.application.config;

import com.io.darkfoxv.application.domain.Post;
import com.io.darkfoxv.application.domain.User;
import com.io.darkfoxv.application.repository.PostRepository;
import com.io.darkfoxv.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        userRepository.deleteAll();
        postRepository.deleteAll();
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");
        userRepository.saveAll(Arrays.asList(alex, bob,maria));
        Post post1 = new Post(null,sdf.parse("21-03-2018"),"Partiu viagem","Vou viajar para São Paulo. Abralos!", maria);
        Post post2 = new Post(null,sdf.parse("23-03-2018"),"Bom Dia","Acordei feliz hoje", maria);
        postRepository.saveAll(Arrays.asList(post1, post2));

    }
}
