package com.project.ischool.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class SlaveRedisConfig {

    @Bean("slaveRedisFactory")
    public JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        JedisConnectionFactory slaveJedisConnectionFactory = new JedisConnectionFactory();
        slaveJedisConnectionFactory.setPort(6379);
        slaveJedisConnectionFactory.setHostName("192.168.1.95");
        slaveJedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        slaveJedisConnectionFactory.setTimeout(3000);
        return slaveJedisConnectionFactory;
    }


    @Bean("slaveRedisTemplate")
    public RedisTemplate slaveRedisTemplate(@Qualifier("slaveRedisFactory")JedisConnectionFactory jedisConnectionFactory){
        RedisTemplate slaveRedisTemplate=new RedisTemplate();
        slaveRedisTemplate.setConnectionFactory(jedisConnectionFactory);
        slaveRedisTemplate.setKeySerializer(new StringRedisSerializer());
        slaveRedisTemplate.setValueSerializer(new StringRedisSerializer());
        return slaveRedisTemplate;
    }

}
