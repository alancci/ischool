package com.project.ischool.shiro.redisCache;

import com.project.ischool.utils.ApplicationContextUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Set;

public class RedisCache<K,V> implements Cache<K,V> {
    @Autowired
    private RedisTemplate redisTemplate;
    private String cacheName;

    public RedisCache(String cacheName) {
        this.cacheName = cacheName;
    }

    @Override
    public V get(K k) throws CacheException {
        return (V) getRedisTemplate().opsForHash().get(this.cacheName,k.toString());
    }

    @Override
    public V put(K k, V v) throws CacheException {
         System.out.println("put key:"+k+"    "+"put value"+v);
        getRedisTemplate().opsForHash().put(this.cacheName,k.toString(),v);
         return null;
    }

    @Override
    public V remove(K k) throws CacheException {
        getRedisTemplate().opsForHash().delete(this.cacheName,k.toString());
        return null;
    }

    @Override
    public void clear() throws CacheException {
        getRedisTemplate().opsForHash().delete(this.cacheName);

    }

    @Override
    public int size() {
        return getRedisTemplate().opsForHash().size(this.cacheName).intValue();
    }

    @Override
    public Set<K> keys() {
        return getRedisTemplate().opsForHash().keys(this.cacheName);
    }

    @Override
    public Collection<V> values() {
        return getRedisTemplate().opsForHash().values(this.cacheName);
    }
    public static RedisTemplate getRedisTemplate(){
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        System.out.println(redisTemplate+"对象存在");
        return redisTemplate;
    }




}
