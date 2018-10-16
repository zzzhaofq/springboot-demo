package com.zfq.rbac;

import com.zfq.rbac.mapper.AccessMapper;
import com.zfq.rbac.mapper.UserMapper;
import com.zfq.rbac.model.Access;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RbacApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccessMapper accessMapper;

    @Test
    public void contextLoads() throws SQLException {
//        User user = userMapper.selectByPrimaryKey(1);
//        System.out.println(user);
        List<Access> accesses = accessMapper.selectByUsername("admin");
        for (Access a :
                accesses) {
            System.out.println(a);
        }
    }

}
