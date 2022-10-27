package model;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Date;

@Data
@Alias("member")
public class MemberDTO {

    private String id, password, name, email, contact, address, vegan, status;
    private int auth;
    private Date register;

}
