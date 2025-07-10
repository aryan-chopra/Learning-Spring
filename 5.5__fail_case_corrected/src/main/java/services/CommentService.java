package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import proxies.CommentNotificationProxy;
import repositories.CommentRepository;
import utils.CommentProcessor;

@Repository
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }

    public CommentProcessor validate() {
        CommentProcessor processor = context.getBean(CommentProcessor.class);

        return processor.process();
    }

    public CommentRepository getCommentRepository() {
        return this.commentRepository;
    }
}
