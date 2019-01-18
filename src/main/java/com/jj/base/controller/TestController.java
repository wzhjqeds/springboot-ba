/*
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jj.base.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jj.base.common.dto.ResultDto;
import com.jj.base.common.exception.BusinessException;
import com.jj.base.dto.input.UserDto;
import com.jj.base.entity.SysUser;
import com.jj.base.service.SysUserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zjg
 */
@RestController
@Slf4j
public class TestController {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("list")
	public ResultDto<List<UserDto>> list(@RequestBody @Validated UserDto request,
			HttpServletRequest requests) {
		HttpSession session = requests.getSession();
		Boolean isLogin = (Boolean) session.getAttribute("isLogin");
		if(null!=isLogin && isLogin) {
			log.info("已经登录");
		}else {
			log.info("未登录");
			session.setAttribute("isLogin", true);
		}
		Cookie[] cookies = requests.getCookies();
		Enumeration<String> headerNames = requests.getHeaderNames();
		String authType = requests.getAuthType();
		String characterEncoding = requests.getCharacterEncoding();
		String contentType = requests.getContentType();
		DispatcherType dispatcherType = requests.getDispatcherType();
		String localAddr = requests.getLocalAddr();
		String localName = requests.getLocalName();
		int localPort = requests.getLocalPort();
		String pathInfo = requests.getPathInfo();
		String queryString = requests.getQueryString();
		List<UserDto> result = new ArrayList<>();
		UserDto e = new UserDto();
		e.setAge(10);
		e.setName("huahua");
		result.add(e);
		if (request.getAge() == 1) {
			int a = 1 / 0;
		}
		else if (request.getAge() == 2) {
			throw new BusinessException("E003", "年龄不能为2");
		}
		return ResultDto.success(result);
	}

	@PostMapping("add")
	public ResultDto<Void> add(@RequestBody @Validated SysUser request) {

		this.sysUserService.addUser(request);
		return ResultDto.success(null);
	}

	@PostMapping("query")
	public ResultDto<Void> query() {
		UserDto request = new UserDto();
		request.setAge(3);
		request.setName("xiaom");
		ResponseEntity<ResultDto> postForEntity = this.restTemplate
				.postForEntity("http://localhost:8080/list", request, ResultDto.class);
		ResultDto body = postForEntity.getBody();
		List<ResultDto> data = (List<ResultDto>) body.getData();
		return ResultDto.success(null);
	}

}
