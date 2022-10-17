package service;

import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import model.MemberDTO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public int login(MemberDTO input) {
        return memberMapper.login(input);
    }

    public int idCheck(MemberDTO input) {
        return memberMapper.idCheck(input);
    }

    public int join(MemberDTO input) {
        return memberMapper.join(input);
    }

}
