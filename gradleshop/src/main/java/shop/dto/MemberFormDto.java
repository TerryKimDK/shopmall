package shop.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class MemberFormDto {

    @NotBlank(message = "이름은 필수로 입력")
    private String name;
    @NotBlank(message = "이름은 필수로 입력")
    @Email(message = "이메일 형식으로 입력해주세요")
    private String email;
    @NotBlank(message = "이름은 필수로 입력")
    @Length(min = 4, max = 16)
    private String password;
    @NotBlank(message = "이름은 필수로 입력")
    private String address;
    @NotBlank(message = "이름은 필수로 입력")
    private String phone;
}
