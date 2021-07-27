package author.publisher.nexus.backendpro.dto;

public class AuthorDTO {

    private String id;
    private String email;
    private String phonenumber;
    private String accountId;
    private String username;
    private String password;

    public AuthorDTO() {
    }

    public AuthorDTO(String id, String email, String phonenumber, String accountId, String username, String password) {
        this.id = id;
        this.email = email;
        this.phonenumber = phonenumber;
        this.accountId = accountId;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
