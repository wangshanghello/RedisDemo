package com.redis;

import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * 
 * 类的定义：获取redis数据 库中的所有keys
 * @author shengmingChen
 * @Date 2018年5月15日 下午2:20:19
 */
public class JedisKeysDemo {
	public static void main(String[] args) {
		//建立数据库连接
		Jedis jedis= JedisUitl.getJedis();
		//获取keys
		Set<String> keys =	jedis.keys("*");
		//集合都的循环打印
		for (String key : keys) {
			System.out.println(key+"-------------------------");
		}
		//思考：如何遍历出主键为集合的值   课堂练习  《重要》
		Iterator<String> it  = keys.iterator();
		while (it.hasNext()) {
			String key = (String) it.next();
			System.out.println(key+"****");
			
		}
		
		
		//System.out.println(keys);
	}
}
