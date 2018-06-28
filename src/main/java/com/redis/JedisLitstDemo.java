package com.redis;

import redis.clients.jedis.BinaryClient.LIST_POSITION;
import redis.clients.jedis.Jedis;

/**
 * 
 * 类的定义： list常用的一些操作 课堂练习：jedis 的set练习 包括增加，删除，输出
 * 
 * @author shengmingChen
 * @Date 2018年5月15日 上午8:52:29
 */
public class JedisLitstDemo {
	public static void main(String[] args) {
		// 建立连接
		Jedis jedis = JedisUitl.getJedis();
		// 删除列表内容
		jedis.del("1702A");
		// 根据链表下标来指定区间范围来删除数据
		// jedis.ltrim("1702A", 1, 2);

		// 向列表里存放三条数据，按照插入顺序排序
		jedis.lpush("1702A", "jiayuhui", "zhaohong", "yujiaqi");
		// 获取list列表数据 （-1 取得所有，列表最后一个）
		System.out.println(jedis.lrange("1702A", 0, -1));
		// 在key 对应的list结尾增加字符串元素
		jedis.rpush("1702A", "huaweiwei");
		// 在key对应的list首部增加字符串元素
		jedis.lpush("1702A", "wangshang");
		System.out.println(jedis.lrange("1702A", 0, -1));
		// 在列表中根据一个参考元素在之前或者之后增加一个元素
		jedis.linsert("1702A", LIST_POSITION.BEFORE, "yujiaqi", "dulongfei");
		System.out.println(jedis.lrange("1702A", 0, -1));
	}
}
