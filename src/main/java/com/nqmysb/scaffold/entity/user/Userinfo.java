package com.nqmysb.scaffold.entity.user;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * <p>
 * 用户实体对象
 * </p>
 *
 * @author liaocan
 * @since 2019-04-14
 */



@Data
@TableName("USERINFO")
public class Userinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("USERID")
    private String userid;

    @TableField("USERNAME")
    private String username;

    @TableField("FULLNAME")
    private String fullname;

    @TableField("EMAIL")
    private String email;

    @TableField("MOBILE")
    private String mobile;

    @TableField("STATUS")
    private String status;

   

 
}
