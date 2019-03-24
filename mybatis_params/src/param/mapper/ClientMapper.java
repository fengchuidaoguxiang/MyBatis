package param.mapper;

import org.apache.ibatis.annotations.Param;
import param.LoginVO;
import param.domain.Client;

import java.util.List;
import java.util.Map;

public interface ClientMapper {
    //方式一：把多个参数封装成POJO
    public Client login1(LoginVO vo);
    //方式二：使用Map对象来封装多个参数
    public Client login2(Map<String,Object> params);
    //方式三：使用Param注解，原理是方式二,Param注解中的字符串表示Map中的key
    public Client login3(@Param("username") String username, @Param("password") String password);

    public List<Client> login4(@Param("orderBy") String orderBy);

}
