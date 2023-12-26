package com.photo.photogram.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    int usrId;
    @Size(min =2 , max = 20)
    @Column(nullable = false) // null 불가능
    String name;
    @NotBlank// 빈문자열 null 스페이스바 안됨
    String pw;
    char menuAuthorAt;
    char useAt;
    @NotBlank// 빈문자열 null 스페이스바 안됨
    String email;
    String tel;
    Date rgsDate;
    String rgsUsr;
    Date modDate;
    String modUsr;
}