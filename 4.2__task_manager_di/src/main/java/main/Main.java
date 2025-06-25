package main;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment();
        comment.setAuthor("Aryan");
        comment.setText("Lisan-al-Chopra");

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
