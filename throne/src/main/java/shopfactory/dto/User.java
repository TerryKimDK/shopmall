package shopfactory.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Date;


@Data
@Entity
@Table(name="user")
@NoArgsConstructor
@Transactional
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String addr;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;
    private Date regdate;

}