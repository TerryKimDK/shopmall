package shopfactory.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class User {
    private String id;
    private String email;
    private String password;
    private String addr;
    private String phone;
    private String nb;
    private Date regdate;
    private int userexit;

}