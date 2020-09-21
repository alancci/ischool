package com.project.ischool.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @desc 主Redis配置负责读
 * @author  alancci
 * @date   2020/9/21 14:29
 */
@Configuration
public class MasterRedisConfig {
    //Redis连接池配置
    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig masterConfig=new JedisPoolConfig();
        masterConfig.setMaxTotal(1000);
        masterConfig.setMaxIdle(1000);
        masterConfig.setMaxWaitMillis(3000);
        return masterConfig;
    }
    //redis主连接工厂
    @Bean("masterRedisFactory")
    @Primary
    public JedisConnectionFactory masterJedisConnectionFactory(JedisPoolConfig jedisPoolConfig){
        JedisConnectionFactory masterJedisConnectionFactory=new JedisConnectionFactory();
        masterJedisConnectionFactory.setPort(6379);
        masterJedisConnectionFactory.setHostName("192.168.1.178");
        masterJedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        masterJedisConnectionFactory.setTimeout(3000);
        return  masterJedisConnectionFactory;
    }
    /**
     * @desc
     * 构造redis主对应的Template
     */
    @Bean("masterRedisTemplate")
    @Primary
    public RedisTemplate masterRedisTemplate(@Qualifier("masterRedisFactory") JedisConnectionFactory jedisConnectionFactory){
        RedisTemplate masterRedisTemplate=new RedisTemplate();
        masterRedisTemplate.setConnectionFactory(jedisConnectionFactory);
        masterRedisTemplate.setKeySerializer(new StringRedisSerializer());
        masterRedisTemplate.setValueSerializer(new StringRedisSerializer());
        return masterRedisTemplate;
    }





}
