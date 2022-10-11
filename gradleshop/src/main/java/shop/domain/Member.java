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
@Table(name="member")
public class Member {
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

    public static Member createUser(MemberFormDto memberFormDto,
                                    PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setName(memberFormDto.getName());
        member.setPassword(passwordEncoder.encode(memberFormDto.getPassword()));
        member.setEmail(memberFormDto.getEmail());
        member.setAddress(memberFormDto.getAddress());
        member.setPhone(memberFormDto.getPhone());
        member.setRoles(Role.USER);
        member.setRegDate(LocalDate.now());

        System.out.println(member.getPassword());
        System.out.println(member.getName());

        System.out.println(member.getRegDate());
        System.out.println(member.getRoles());
        return member;
    }



}