package com.taotao.rest.jedis;

import java.util.HashSet;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class jedisTest {
	/*@Test
	public void testJedisSingle() {
		//创建一个jedis的对象
		Jedis jedis =  new Jedis("127.0.0.1", 6379);
		//调用jedis对象的方法，方法名称与redis命令一致
		jedis.auth("house");
		jedis.set("key1","jedis test");
		String string = jedis.get("key1");
		System.out.println(string);
	    //关闭jedis
		jedis.close();
	}	*/
//	@Test
//	//使用连接池
//	public void testJedisPool() {
//		//创建Jedis连接池
//		JedisPool pool = new JedisPool("127.0.0.1", 6379);
//		//从连接池中获得Jedis对象
//		Jedis jedis = pool.getResource();
//		jedis.auth("house");
//		String string = jedis.get("key1");
//		System.out.println(string);
//		//关闭jedis对象
//		jedis.close();
//		pool.close();
//	}
	/**
	 * 集群版测试
	 */
	/*@Test
	public void testJedisCluster() {
		HashSet<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("127.0.0.1", 7000));
		nodes.add(new HostAndPort("127.0.0.1", 7001));
		nodes.add(new HostAndPort("127.0.0.1", 7002));
		nodes.add(new HostAndPort("127.0.0.1", 7003));
		nodes.add(new HostAndPort("127.0.0.1", 7004));
		nodes.add(new HostAndPort("127.0.0.1", 7005));
		
		JedisCluster cluster = new JedisCluster(nodes);
		cluster.set("key1", "1000");
		String string = cluster.get("key1");
		System.out.println(string);
		
		cluster.close();
	}*/
//	@Test
//	public void testSpringJedisSingle() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
//		JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
//		Jedis jedis = pool.getResource();
//		String string = jedis.get("key1");
//		System.out.println(string);
//		jedis.close();
//		pool.close();
//	}
	@Test
	public void testSpringJedisCluster() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		JedisCluster jedisCluster = (JedisCluster) applicationContext.getBean("redisClient");
		String string = jedisCluster.get("key1");
		System.out.println(string);
		jedisCluster.close();
	}
}
