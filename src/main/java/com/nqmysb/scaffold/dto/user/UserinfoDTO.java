package com.nqmysb.scaffold.dto.user;

import lombok.Data;

/** 
 * Class Name: UserinfoDTO  
 * Description: 
 * 	数据传输，用来接收参数
 * @date: 2018年1月23日
 * @version: 1.0
 *
 */  
@Data
public class UserinfoDTO {
	
	private String userId;
	
	private String userName;
	
	private String fullName;
	
	private String email;
	
	private String mobile;
	
	private String status;
	
	private Integer pageNum;





}
