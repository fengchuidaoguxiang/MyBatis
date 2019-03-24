package param;

//封装登录的信息
//VO:Value Object:值对象
//DTO:Data Transform Object：数据转换对象

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginVO {
    private String username;
    private String password;
}
