//package author.publisher.nexus.backendpro.controller;
//
//import author.publisher.nexus.backendpro.model.Comment;
//import author.publisher.nexus.backendpro.repository.CommentRepository;
//import author.publisher.nexus.backendpro.repository.PublisherRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("api/comment")
//public class CommentController {
//
//    @Autowired
//    private PublisherRepository publisherRepository;
//    private Object String;
//
//    @Autowired
//    private CommentRepository commentRepository;
//
//    @GetMapping
//    public List<Comment> getComment() {
//        return commentRepository.findAll();
//    }
//
//    @PostMapping
//    public Comment sentComment(@RequestBody Comment comment){
//        Comment c = new Comment();
//        c.setRating(comment.getRating());
//        c.setComment(comment.getComment());
//        c.setAuthor(comment.getAuthor());
//        c.setDate(comment.getDate());
//        commentRepository.save(c);
//        return c;
//    }
//
////    @PostMapping
////    public Comment getCommentByPublisherId(@RequestBody Comment comment) {
////
////        if(comment.getAuthor()==null){
////            System.out.print("Author is required");
////        }
////        else {
////            Comment c = new Comment();
////            c.setRating(comment.getRating());
////            c.setComment(comment.getComment());
////            c.setAuthor(comment.getAuthor());
////            c.setDate(comment.getDate());
////            return commentRepository.save(c);///mekata adalawa777
////        }
////        return new Comment();
////    }
//}
