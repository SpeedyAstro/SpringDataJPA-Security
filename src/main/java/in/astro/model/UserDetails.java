package in.astro.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "Security_user")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    @Column(length = 20,unique = true,nullable = false)
    private String uname;
    @Column(length = 200,unique = true,nullable = false)
    private String pwd;
    @Column(length = 50,unique = true,nullable = false)
    private String email;
    private boolean status = true;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Security_Roles", joinColumns = @JoinColumn(name = "User_Id", referencedColumnName = "uid"))
    @Column(name = "role")
    private Set<String> roles;
}
