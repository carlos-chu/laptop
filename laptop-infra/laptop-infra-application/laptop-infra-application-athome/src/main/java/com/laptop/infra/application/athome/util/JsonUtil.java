package com.laptop.infra.application.athome.util;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtil {

	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	}

	/**
	 * parse and convert a json string to an object
	 */
	public static <T> T fromJson(String json, Class<T> t) {
		if (json == null) {
			return null;
		}
		try {
			return mapper.readValue(json, t);
		} catch (Exception e) {
			throw new RuntimeException("convert fromJson failed: " + json + ", dest class: " + t.getName(), e);
		}
	}

	/**
	 * convert from srcObj to specified class
	 */
	public static <T> T fromObject(Object srcObj, Class<T> t) {
		if (srcObj == null) {
			return null;
		}
		try {
			return mapper.convertValue(srcObj, t);
		} catch (Exception e) {
			throw new RuntimeException("convert fromObject failed: " + srcObj + ", dest class: " + t.getName(), e);
		}
	}

	/**
	 * convert a map to object
	 */
	public static <T> T fromMap(Map<?, ?> map, Class<T> t) {
		if (map == null) {
			return null;
		}
		try {
			return mapper.readValue(toJsonString(map), t);
		} catch (Exception e) {
			throw new RuntimeException("convert fromMap failed: " + map + ", dest class: " + t.getName(), e);
		}
	}

	/**
	 * convert any object to json string
	 */
	public static String toJsonString(Object obj) {

		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException("convert toJsonString failed: " + obj, e);
		}
	}

}
