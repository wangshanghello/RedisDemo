package com.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;

/**
 * 
 * 类的定义： jedis连接练习 封装jedis连接
 * 
 * @author shengmingChen
 * @Date 2018年5月14日 下午3:21:01
 */
public class JedisUitl {
	// jedis 服务器IP
	private static String myHost = "127.0.0.1";
	// jedis 端口
	private static int port = 6379;

	public static Jedis getJedis() {
		// 开启建立连接 初始化连接池
		Jedis jedis = new Jedis(myHost, port);
		// 授权
		jedis.auth("root"); // 注意：禁止在程序中出现密码，验证码 授权码，用户等
		System.out.println("授权成功");
		System.out.println(jedis.ping());
		return jedis;
	}

	@Test
	public void RedisTest1() {
		// 开启建立连接 初始化连接池
		Jedis jedis = new Jedis(myHost, port);
		// 授权
		jedis.auth("root");
		System.out.println("授权成功");
		System.out.println(jedis.ping());
	}

	public static void main(String[] args) {
		// 开启建立连接 初始化连接池
		Jedis jedis = new Jedis(myHost, port);
		// 授权
		jedis.auth("root");
		System.out.println("授权成功");
		System.out.println(jedis.ping());
	}

}
