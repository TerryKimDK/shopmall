package service;

import lombok.RequiredArgsConstructor;
import model.MemberDTO;
import dao.MemberDAO;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberDAO memberDAO;

    public void idCheck(MemberDTO input) {
        int count = memberDAO.selectCount(input);

        if (count == 1)
            System.out.println("로그인 성공");
        else
            System.out.println("로그인 실패");
    }

}
