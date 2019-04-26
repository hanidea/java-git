package com.example.firstapp.repository;

import com.example.firstapp.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link User} {@link Repository}
 */
@Repository
public class UserRepository {
    /**
     * 采用内存型的存储方式 -> Map
     */
    private final ConcurrentMap<Integer,User> respository
            = new ConcurrentHashMap<>(16);
    private final static AtomicInteger idGenerator =
            new AtomicInteger();
    /**
     * 保存用户对象
     * @param user {@link User} 对象
     * @return 如果保存成功，返回<code>true</code>,否则，返回<code>false</code>
     */
    public boolean save(User user){
        // ID 从1 开始
        Integer id = idGenerator.incrementAndGet();
        //设置 ID
        user.setId(id);
        // put 方法返回 null 时表示保存成功
        return respository.put(id,user) == null;
    }
    /**
     * 返回所有用户列表
     * @return 所有用户列表
     */
    public Collection<User> findAll(){
        return respository.values();
    }
}
