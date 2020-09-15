package com.liziczh.springboot.redis.constant;

/**
 * @author zhehao.chen
 */
public class RedisConstants {
	public static enum CACHE_KEY {
		KEY("KEY:", "键");

		private String code;
		private String name;

		private CACHE_KEY(String code, String name) {
			this.code = code;
			this.name = name;
		}
		public String getCode() {
			return code;
		}
		public String getName() {
			return name;
		}
	}
}
