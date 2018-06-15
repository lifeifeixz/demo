package com.baixiang.chuxing.user.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public class CustomObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 3223645203459453114L;

	/**
	 * 构造函数
	 */
	public CustomObjectMapper() {
		super();

		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
		simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
		registerModule(simpleModule);
	}
}
