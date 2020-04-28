package app.mtics.domain.authentication;

import app.mtics.domain.user.User;

import javax.persistence.*;

@Entity
@Table(name = "authentication")
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    public Authentication() {
    }

    public Authentication(String password, String email, User user) {
        this.password = password;
        this.email = email;
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public User getUser() {
        return user;
    }
}
