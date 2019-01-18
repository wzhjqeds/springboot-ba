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

package com.jj.base.core.advice;

import com.jj.base.common.constans.CommonEnum;
import com.jj.base.common.dto.ResultDto;
import com.jj.base.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class BaseControllerAdvice {

	private static final Logger logger = LoggerFactory
			.getLogger(BaseControllerAdvice.class);

	@ExceptionHandler({ BusinessException.class })
	@ResponseBody
	public ResultDto<Object> handleMissingServletRequestParameterException(
			BusinessException e) {
		return ResultDto.error(e.getCode(), e.getMessage());
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseBody
	public ResultDto<Object> handleOtherExceptions(Exception e) {
		logger.error(e.getMessage(), e);
		return ResultDto.error(CommonEnum.ERROR);
	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	@ResponseBody
	public ResultDto<Object> handleOtherExceptions(MethodArgumentNotValidException e) {
		logger.error(e.getMessage(), e);

		return ResultDto.error(CommonEnum.ERROR.code(),
				e.getBindingResult().getFieldError().getDefaultMessage());
	}

}
