package com.io.darkfoxv.application.services;

import com.io.darkfoxv.application.domain.Post;
import com.io.darkfoxv.application.domain.User;
import com.io.darkfoxv.application.dto.UserDTO;
import com.io.darkfoxv.application.repository.PostRepository;
import com.io.darkfoxv.application.repository.UserRepository;
import com.io.darkfoxv.application.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String title) {
        return postRepository.findByTitleContainingIgnoreCase(title);
    }

}
