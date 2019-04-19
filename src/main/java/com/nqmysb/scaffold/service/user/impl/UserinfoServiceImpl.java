package com.nqmysb.scaffold.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nqmysb.scaffold.entity.user.Userinfo;
import com.nqmysb.scaffold.mapper.user.UserinfoMapper;
import com.nqmysb.scaffold.model.MyPage;
import com.nqmysb.scaffold.model.ParamSome;
import com.nqmysb.scaffold.service.user.IUserinfoService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liaocan
 * @since 2019-04-14
 */
@Service
public class UserinfoServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements IUserinfoService {
	
    @Resource
    private UserinfoMapper mapper;
    
    public MyPage<Userinfo>  mySelectPage(MyPage<Userinfo> myPage, ParamSome paramSome) {
       return  mapper.mySelectPage(myPage, paramSome);
    }
    
}
