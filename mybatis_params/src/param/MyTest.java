package param;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import param.domain.Client;
import param.mapper.ClientMapper;
import param.util.MyBatisUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void testLogin1(){
        LoginVO vo = new LoginVO("tom","1111");
        SqlSession session = MyBatisUtils.getSession();
        ClientMapper clientMapper = session.getMapper(ClientMapper.class);
        Client client = clientMapper.login1(vo);
        System.out.println(client);
        session.close();
    }

    @Test
    public void testLogin2(){
        Map<String, Object> paramMap = new HashMap<String,Object>(){
            {
                this.put("username1","tom");
                this.put("password1","1111");
            }
        };
        SqlSession session = MyBatisUtils.getSession();
        ClientMapper clientMapper = session.getMapper(ClientMapper.class);
        Client client = clientMapper.login2(paramMap);
        session.close();
        System.out.println(client);
    }

    @Test
    public void testLogin3(){
        SqlSession session = MyBatisUtils.getSession();
        ClientMapper clientMapper = session.getMapper(ClientMapper.class);
        Client client = clientMapper.login3("tom","1111");
        session.close();
        System.out.println(client);
    }

    @Test
    public void testLogin4(){
        SqlSession session = MyBatisUtils.getSession();
        ClientMapper clientMapper = session.getMapper(ClientMapper.class);
        List<Client> list = clientMapper.login4("id DESC");
        for(Client temp : list){
            System.out.println(temp);
        }
    }
}
