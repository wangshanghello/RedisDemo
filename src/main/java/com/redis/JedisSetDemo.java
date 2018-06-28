package com.redis;

import redis.clients.jedis.Jedis;

/**
 * 
 * 类的定义：	set形式的练习
 * @author shengmingChen
 * @Date 2018年5月15日 下午2:36:28
 */
public class JedisSetDemo {
	public static void main(String[] args) {
		//连接
		Jedis jedis= JedisUitl.getJedis();
		jedis.sadd("people", "zhangsan");
		jedis.sadd("people", "18");
		jedis.sadd("people", "女");
		jedis.sadd("people", "180");
		jedis.sadd("people", "160");
		jedis.sadd("people", "河南");
		System.out.println(jedis.smembers("people"));
		//删除集合中指定的元素
		jedis.srem("people", "160");
		System.out.println(jedis.smembers("people"));
		//判断集合中是否有该元素存在 返回结果为ture 和false
		System.out.println(jedis.sismember("people", "180"));
		//返回集合中的个数
		System.out.println(jedis.scard("people"));
		
	}
}	
