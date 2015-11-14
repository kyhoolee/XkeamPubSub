package com.xkeam.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisPool {
	private static JedisPool _instance = null;

	private RedisPool() {

	}

	public synchronized static JedisPool getInstance() {

		if (_instance == null) {
			JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
			jedisPoolConfig.setMaxTotal(100);
			jedisPoolConfig.setMaxIdle(100);
			jedisPoolConfig.setMaxWaitMillis(10000);
			jedisPoolConfig.setMinIdle(10);
			jedisPoolConfig.setTimeBetweenEvictionRunsMillis(5000);
			jedisPoolConfig.setMinEvictableIdleTimeMillis(1000);
			
			_instance = new JedisPool(
					jedisPoolConfig, 
					ConfigParams.redis_host, ConfigParams.redis_port, 
					10000, ConfigParams.redis_pass);

		}
		
		return _instance;
	}

	public synchronized static Jedis getJedis() {
		Jedis jedis = RedisPool.getInstance().getResource();

		jedis.select(ConfigParams.redis_index);
		return jedis;
	}

}
