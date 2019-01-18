package com.jj.base.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jj.base.entity.SysUser;
import com.jj.base.mapper.SysUserDao;
import com.jj.base.service.SysUserService;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zjg
 * @since 2019-01-16
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser>
		implements SysUserService {

	@Override
	public void addUser(SysUser request) {
		insert(request);
	}

}
