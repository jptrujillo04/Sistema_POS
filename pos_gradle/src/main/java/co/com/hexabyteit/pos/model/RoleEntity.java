package co.com.hexabyteit.pos.model;

import co.com.hexabyteit.pos.model.constant.RoleConstant;
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
@Table(name = RoleConstant.TABLE_ROLE, schema="sispos")
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_role")
    private Long idRole;

    @Column(name = "role_name",unique = true, length = 20, nullable = false)
    private String roleName;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "register_user", nullable = false)
    private String registerUser;

    @Column(name = "register_date")
    private LocalDateTime registerDate;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;
}
