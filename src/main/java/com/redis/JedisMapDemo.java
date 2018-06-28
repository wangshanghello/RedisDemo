package com.redis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * 
 * 类的定义：	map形式的练习
 * @author shengmingChen
 * @Date 2018年5月15日 下午3:02:10
 */
public class JedisMapDemo {
	public static void main(String[] args) {
		Jedis jedis= JedisUitl.getJedis();
		//在map中添加数据
		Map<String, String> map = new HashMap<String, String>();
		map.put("name","王文举");
		map.put("sex","男");
		map.put("age","22");
		map.put("telphone","111111110");
		//hmset存入数据，将map数据对应一个key
		jedis.hmset("student", map);
		//打印输入key中的值
		System.out.println(jedis.hmget("student","name","sex","age"));
		//删除map某个键值对  1 删除成功  0 删除失败
		System.out.println(jedis.hdel("student", "age"));
		System.out.println(jedis.hdel("student", "age"));
		/*
		 * 1.返回结果为null   判断该字段是否存在  hmget
		 * 2. 返回key 为studnet 的键中的存放值个数  hlen
		 * 3.返回map 对象中的所有key    hkeys
		 * 4.返回map 对象中的所有value   hvals
		 */
		// 思考:如何打印student 对应的值  把它改成for循环来做？
		Iterator<String> iter = jedis.hkeys("student").iterator();
		while (iter.hasNext()) {
			String key = (String) iter.next();
			System.out.println(key+":"+jedis.hmget("student", key));
		}
		
	}
}
