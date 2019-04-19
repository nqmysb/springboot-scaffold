package com.nqmysb.scaffold.controller.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.stat.DruidStatManagerFacade;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nqmysb.scaffold.dto.user.UserinfoDTO;
import com.nqmysb.scaffold.entity.user.Userinfo;
import com.nqmysb.scaffold.model.MyPage;
import com.nqmysb.scaffold.model.ParamSome;
import com.nqmysb.scaffold.service.user.IUserinfoService;

import ikidou.reflect.TypeBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * <p>
 * 用户管理前端控制器
 * </p>
 *
 * @author liaocan
 * @since 2019-04-14
 */
@Controller
@RequestMapping("/user")
@Api(value="用户资源", tags="用户管理")  
public class UserinfoController {

	@Autowired
	IUserinfoService userinfoServiceImpl;
	
	
	@ApiOperation(value="查询全部用户信息", notes="通过用户输入的条件，查询满足条件的用户信息列表", httpMethod = "POST")  
	@ApiImplicitParams({  
        @ApiImplicitParam(paramType = "query", name = "userId", dataType = "string", required = false, value = "用户编号"),  
        @ApiImplicitParam(paramType = "query", name = "userName", dataType = "string", required = false, value = "用户账号，可以模糊查找"),  
        @ApiImplicitParam(paramType = "query", name = "fullName", dataType = "string", required = false, value = "用户姓名，可以模糊查找"),  
        @ApiImplicitParam(paramType = "query", name = "email", dataType = "string", required = false, value = "电子邮件，可以模糊查找"),    
        @ApiImplicitParam(paramType = "query", name = "mobile", dataType = "string", required = false, value = "联系方式，可以模糊查找"),
        @ApiImplicitParam(paramType = "query", name = "status", dataType = "string", required = false, value = "用户状态，0：停用、1：正常")
	})  
	@RequestMapping(value ="/getUsers",method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<Userinfo> getUsers(@RequestBody(required=false) UserinfoDTO param) {
		ArrayList<Userinfo> data = null;
		if(param != null){
			data  = (ArrayList<Userinfo>) userinfoServiceImpl.list(new QueryWrapper<Userinfo>().like("userId", param.getUserId()));

		}
		return data;
	}


	@SuppressWarnings("unused")
	@ApiOperation(value="查询分页用户信息", notes="通过用户输入的条件，查询满足条件的用户信息列表", httpMethod = "GET")  
	@ApiImplicitParams({  
        @ApiImplicitParam(paramType = "query", name = "userId", dataType = "string", required = false, value = "用户编号"),  
        @ApiImplicitParam(paramType = "query", name = "userName", dataType = "string", required = false, value = "用户账号，可以模糊查找"),  
        @ApiImplicitParam(paramType = "query", name = "fullName", dataType = "string", required = false, value = "用户姓名，可以模糊查找"),  
        @ApiImplicitParam(paramType = "query", name = "email", dataType = "string", required = false, value = "电子邮件，可以模糊查找"),    
        @ApiImplicitParam(paramType = "query", name = "mobile", dataType = "string", required = false, value = "联系方式，可以模糊查找"),
        @ApiImplicitParam(paramType = "query", name = "status", dataType = "string", required = false, value = "用户状态，0：停用、1：正常")
	}) 
	@RequestMapping("/getUsersPage")
	@ResponseBody
	public MyPage<Userinfo> getUsersPage(@RequestBody(required=false) UserinfoDTO param) {

		System.out.println("----- baseMapper 自带分页 ------");
		Page<Userinfo> page = new Page<>(1, 5);
		IPage<Userinfo> userIPage = userinfoServiceImpl.page(page,
				new QueryWrapper<Userinfo>().like("email", "593@55.com").like("username", "jack1"));

		System.out.println("总条数 ------> " + userIPage.getTotal());
		System.out.println("当前页数 ------> " + userIPage.getCurrent());
		System.out.println("当前每页显示数 ------> " + userIPage.getSize());

		System.out.println("----- baseMapper 自带分页 ------");

		System.out.println("json 正反序列化 begin");
		String json = JSON.toJSONString(page);
		Page<Userinfo> page1 = JSON.parseObject(json,
				TypeBuilder.newInstance(Page.class).addTypeParam(Userinfo.class).build());

		System.out.println("json 正反序列化 end");

		System.out.println("----- 自定义 XML 分页 ------");
		MyPage<Userinfo> myPage = new MyPage<Userinfo>(1, 5).setSelectStr1("593@55.com").setSelectStr2("jack1");
		ParamSome paramSome = new ParamSome("593@55.com", "jack1");
		MyPage<Userinfo> userMyPage = userinfoServiceImpl.mySelectPage(myPage, paramSome);

		System.out.println("总条数 ------> " + userMyPage.getTotal());
		System.out.println("当前页数 ------> " + userMyPage.getCurrent());
		System.out.println("当前每页显示数 ------> " + userMyPage.getSize());

		System.out.println("----- 自定义 XML 分页 ------");

		return userMyPage;
	}
	
	
	@ApiOperation(value="查询druid数据源监控数据", httpMethod = "GET")   
	@GetMapping("/druid/stat")
	@ResponseBody
	public Object druidStat() {
		// DruidStatManagerFacade#getDataSourceStatDataList
		// 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
		return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
	}
	

}
