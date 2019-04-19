package com.nqmysb.scaffold.mapper.user;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nqmysb.scaffold.entity.user.Userinfo;
import com.nqmysb.scaffold.model.MyPage;
import com.nqmysb.scaffold.model.ParamSome;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liaocan
 * @since 2019-04-14
 */
@Mapper
public interface UserinfoMapper extends BaseMapper<Userinfo> {
	
	   /**
     * 3.x 的 page 可以进行取值,多个入参记得加上注解
     * 自定义 page 类必须放在入参第一位
     * 返回值可以用 IPage<T> 接收 也可以使用入参的 MyPage<T> 接收
     * <li> 3.1.0 之前的版本使用注解会报错,写在 xml 里就没事 </li>
     * <li> 3.1.0 开始支持注解,但是返回值只支持 IPage ,不支持 IPage 的子类</li>
     *
     * @param myPage 自定义 page
     * @return 分页数据
     */
//    @Select("select * from user where (age = #{pg.selectInt} and name = #{pg.selectStr}) or (age = #{ps.yihao} and name = #{ps.erhao})")
    MyPage<Userinfo> mySelectPage(@Param("pg") MyPage<Userinfo> myPage, @Param("ps") ParamSome paramSome);

}
