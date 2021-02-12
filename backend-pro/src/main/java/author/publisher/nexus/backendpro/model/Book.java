package author.publisher.nexus.backendpro.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("book")
public class Book{

    @Id
    private String id;
    private String name;
    private String file;
    private String fileSource;
    private String authorId;

    //@DBRef
    //private Collection<Author> author;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Collection<Author> getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Collection<Author> author) {
//        this.author = author;
//    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileSource() {
        return fileSource;
    }

    public void setFileSource(String fileSource) {
        this.fileSource = fileSource;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }
}
