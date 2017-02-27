package com.taotao.rest.dao;

public interface JedisClient {
	
	String get(String key);
	String set(String key, String value);
	String Hget(String hkey, String key);
	Long Hset(String hkey, String key, String value);
	long incr(String key);
	//设置参数的过期时间
	long expire(String key, int second);
	long ttl(String key);
}
