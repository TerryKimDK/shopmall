package shop.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;
import shop.dto.MemberFormDto;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Getter @Setter
@ToString
@Table(name="user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    @Column(unique = true)
    private String email;
    private String address;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role roles;
    private LocalDate regDate;

    public static User createUser(MemberFormDto memberFormDto,
                                  PasswordEncoder passwordEncoder) {
        User user= new User();
        user.setName(memberFormDto.getName());
        user.setPassword(passwordEncoder.encode(memberFormDto.getPassword()));
        user.setEmail(memberFormDto.getEmail());
        user.setAddress(memberFormDto.getAddress());
        user.setPhone(memberFormDto.getPhone());
        user.setRoles(Role.USER);
        user.setRegDate(LocalDate.now());

        System.out.println(user.getPassword());
        System.out.println(user.getName());

        System.out.println(user.getRegDate());
        System.out.println(user.getRoles());
        return user;
    }

}