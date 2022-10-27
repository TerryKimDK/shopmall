package service;

import lombok.RequiredArgsConstructor;
import model.MemberDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final SessionFactory factory;

    public int login(MemberDTO member) {
        return factory.getInstance().selectOne("MemberMapper.login", member);
    }

    public int idCheck(MemberDTO member) {
        return factory.getInstance().selectOne("MemberMapper.idCheck", member);
    }

    public int join(MemberDTO member) {
        return factory.getInstance().insert("MemberMapper.join", member);
    }

}
