package entities;

public class User {
    
    String name;
    Long id;
    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String name, Long id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }
    
    
}
