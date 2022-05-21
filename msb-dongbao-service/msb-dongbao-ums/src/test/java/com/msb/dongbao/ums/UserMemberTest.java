package com.msb.dongbao.ums;

import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MsbDongBaoUmsApplication.class)
@RunWith(SpringRunner.class)
public class UserMemberTest {

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Test
    public void updateTest(){
        UmsMember umsMember = new UmsMember();
        umsMember.setId(8L);

        umsMemberMapper.updateById(umsMember);
    }

    @Test
    public void testInsert(){
        UmsMember umsMember = new UmsMember();
        umsMember.setUsername("张三123");
        umsMember.setPassword("123123");
        umsMember.setIcon("kkk123");
        umsMember.setEmail("1205648321123@qq.com");
        umsMember.setNickName("小花123");
        umsMember.setNote("帅哥123");
        umsMemberMapper.insert(umsMember);
    }

}
