package com.msb.dongbao.ums.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.msb.dongbao.ums.entity.UmsMember;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author lianzihao
 * @since 2022-05-18
 */
public interface UmsMemberService extends IService<UmsMember> {

    public String register();
}
