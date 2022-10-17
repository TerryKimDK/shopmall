package mapper;

import lombok.RequiredArgsConstructor;
import model.MemberDTO;

@RequiredArgsConstructor
public class MemberMapper {
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
