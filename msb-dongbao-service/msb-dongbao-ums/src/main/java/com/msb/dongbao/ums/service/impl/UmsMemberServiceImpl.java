package com.msb.dongbao.ums.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.msb.dongbao.ums.mapper.UmsMemberMapper;
import com.msb.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * <p>
 * 后台用户表 服务实现类
 * </p>
 *
 * @author lianzihao
 * @since 2022-05-18
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    //密码加密
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public String register(UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(umsMemberRegisterParamDTO,umsMember);
        String encode = bCryptPasswordEncoder.encode(umsMemberRegisterParamDTO.getPassword());
        umsMember.setPassword(encode);
        umsMemberMapper.insert(umsMember);
        return "success";
    }

    @Override
    public String login(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        UmsMember umsMember = umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
        if (umsMember != null ){
            String passwordDb = umsMember.getPassword();

            if (!bCryptPasswordEncoder.matches(umsMemberLoginParamDTO.getPassword(),passwordDb)){
                return "密码不正确";
            }
         }else {
            return "用户不存在!";
        }
        System.out.println("登录成功");
        return "token";
    }
}
