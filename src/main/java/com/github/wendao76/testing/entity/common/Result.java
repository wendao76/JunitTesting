package com.github.wendao76.testing.entity.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author wendao76
 * @version 1.0
 * @description 类描述信息
 * @className Result
 * @date 2020-6-19 10:50
 */
@Getter
@Setter
public class Result<T> implements Serializable {
	private boolean success = true;
	private T data;
	private String message;

	private Result() {

	}

	private Result(T obj) {
		data = obj;
	}

	public static Result of(Object obj) {
		Result result = new Result(obj);
		return result;
	}

	public static Result error(String message) {
		Result result = new Result();
		result.setMessage(message);
		result.setSuccess(false);
		return result;
	}
}
