package cn.chenzw.springboot.redis.cache.service;

import cn.chenzw.springboot.redis.cache.domain.entity.SysUser;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class SysUserService {


    /**
     * @param id
     * @param name
     * @return
     * @Cacheable - 执行前会先查看缓存中是否有数据（有，则直接返回缓存数据）
     */
    @Cacheable(value = "userCache", key = "#id")
    public SysUser findOne(Long id, String name) {
        System.out.println("--------------数据库查询-----------------");

        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setName(name);
        return sysUser;
    }

    /**
     * 删除缓存
     *
     * @param id
     */
    @CacheEvict(value = "userCache", key = "#id")
    public void deleteOne(Long id) {
        System.out.println("---------------数据库删除------------------");
    }

    /**
     * @param sysUser
     * @CachePut - 总是添加缓存
     */
    @CachePut(value = "userCache", key = "#sysUser.id")
    public void save(SysUser sysUser) {
        System.out.println("---------------数据库保存------------------");
    }
}
