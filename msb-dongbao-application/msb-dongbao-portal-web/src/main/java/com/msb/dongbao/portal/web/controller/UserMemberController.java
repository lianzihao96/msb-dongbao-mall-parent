package com.msb.dongbao.portal.web.controller;

import com.msb.dongbao.common.JwtUtil;
import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.msb.dongbao.common.base.result.ResultWrapper;
import com.msb.dongbao.ums.entity.UmsMember;
import com.msb.dongbao.ums.entity.dto.UmsMemberLoginParamDTO;
import com.msb.dongbao.ums.entity.dto.UmsMemberRegisterParamDTO;
import com.msb.dongbao.ums.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("user-member")
public class UserMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PostMapping("/register")
    public ResultWrapper register(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){
        return umsMemberService.register(umsMemberRegisterParamDTO);
    }

    @PostMapping("/login")
    public ResultWrapper login(@RequestBody UmsMemberLoginParamDTO umsMemberLoginParamDTO){
        return umsMemberService.login(umsMemberLoginParamDTO);
    }

    @PostMapping("/edit")
    @TokenCheck
    public ResultWrapper edit(@RequestBody UmsMember umsMember){
        System.out.println("edit");
        return umsMemberService.edit(umsMember);
    }

    @GetMapping("/test-verify")
    public ResultWrapper verify(String token){
        System.out.println("正常业务");
        return ResultWrapper.getSuccessBuilder().build();
    }
}
