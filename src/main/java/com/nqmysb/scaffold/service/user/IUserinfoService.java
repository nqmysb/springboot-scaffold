package com.nqmysb.scaffold.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nqmysb.scaffold.entity.user.Userinfo;
import com.nqmysb.scaffold.model.MyPage;
import com.nqmysb.scaffold.model.ParamSome;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liaocan
 * @since 2019-04-14
 */
public interface IUserinfoService extends IService<Userinfo> {
	
	
	public MyPage<Userinfo>  mySelectPage(MyPage<Userinfo> myPage, ParamSome paramSome);

}
