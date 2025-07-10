package services;

import org.springframework.stereotype.Service;
import repositories.CommentRepository;

@Service
public class UserService {
    private final CommentRepository commentRepository;

    public UserService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentRepository getCommentRepository() {
        return this.commentRepository;
    }
}
