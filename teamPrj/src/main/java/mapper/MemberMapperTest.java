package mapper;

import model.MemberDTO;

public interface MemberMapperTest {

    int login(MemberDTO member);

    int idCheck(MemberDTO member);

    int join(MemberDTO member);

}
