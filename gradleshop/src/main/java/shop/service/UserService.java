package shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import shop.domain.Member;
import shop.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor // repository di를 위해
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public Member saveMember(Member member) {
        validateDuplicateUser(member);
        return userRepository.save(member);
    }

    public void validateDuplicateUser(Member member) {
        System.out.println("valid method :" + member.getEmail());
        Member findMember = userRepository.findByEmail(member.getEmail());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws
            UsernameNotFoundException {
        Member member = userRepository.findByEmail(email);
        System.out.println("override userservice: " + member.getEmail());
        System.out.println("override userservice: " + member.getPassword());
        System.out.println("override userservice: " + member.getRoles());
        System.out.println("override userservice: " + member.getName());
        System.out.println("override userservice: " + member.getPhone());
        System.out.println("override userservice: " + member.getId());
        System.out.println("override userservice: " + member.getAddress());

        if (member == null) {
            throw new UsernameNotFoundException(email);
        }

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRoles().toString())
                .build();

    }

}
