package com.io.darkfoxv.application.config;

import com.io.darkfoxv.application.domain.Post;
import com.io.darkfoxv.application.domain.User;
import com.io.darkfoxv.application.dto.AuthorDTO;
import com.io.darkfoxv.application.dto.CommentDTO;
import com.io.darkfoxv.application.repository.PostRepository;
import com.io.darkfoxv.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
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
        userRepository.saveAll(Arrays.asList(alex, bob, maria));
        Post post1 = new Post(null, sdf.parse("21-03-2018"), "Partiu viagem", "Vou viajar para São Paulo. Abralos!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23-03-2018"), "Bom Dia", "Acordei feliz hoje", new AuthorDTO(maria));
        CommentDTO comment1 = new CommentDTO("Boa Viagem Mano!", sdf.parse("21-03-2018"), new AuthorDTO(alex));
        CommentDTO comment2 = new CommentDTO("Aproveite!", sdf.parse("22-03-2018"), new AuthorDTO(bob));
        CommentDTO comment3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("21-03-2018"), new AuthorDTO(alex));
        post1.getComments().addAll(Arrays.asList(comment1, comment2));
        post2.getComments().add(comment3);
        postRepository.saveAll(Arrays.asList(post1, post2));
        maria.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.saveAll(Arrays.asList(alex, bob, maria));
    }
}
