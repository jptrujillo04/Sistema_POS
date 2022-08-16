package co.com.hexabyteit.pos.model;

import co.com.hexabyteit.pos.model.constant.UserConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Builder(toBuilder = true)
@Table(name = UserConstant.TABLE_USER, schema="sispos")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "name_user", length = 120, nullable = false)
    private String nameUSer;

    @Column(name = "account", unique = true, length = 20, nullable = false)
    private String account;

    @Column(name = "password_user", length = 60, nullable = false)
    private String password;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "register_user", nullable = false)
    private String registerUser;

    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="users_roles",
            schema = "sispos",
            joinColumns= {@JoinColumn(name="id_user")},
            inverseJoinColumns={@JoinColumn(name="id_role")})
    private List<RoleEntity> roles;
}
