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

package com.jj.base.dto.input;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.jj.base.common.dto.InputDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zjg
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class UserDto extends InputDto implements Serializable{

	@NotNull(message="年龄不能为空")
	private Integer age;
	
	@NotNull(message="姓名不能为空")
	private String name;
	
}
