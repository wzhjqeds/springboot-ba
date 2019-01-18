package com.jj.base.service;

import com.baomidou.mybatisplus.service.IService;
import com.jj.base.entity.SysUser;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zjg
 * @since 2019-01-16
 */
public interface SysUserService extends IService<SysUser> {

	/**
	 * @param request
	 */
	void addUser(SysUser request);

}
