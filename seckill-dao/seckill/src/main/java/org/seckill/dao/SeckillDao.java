package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * @Auther: dudou
 * @Date: 2018-11-06 20:49
 * @Email: 1017825998@qq.com
 * @Description: Seckill实体类的数据操作接口
 */
public interface SeckillDao {

    //减库存
    int reduceNumber(@Param("seckillId")long seckillId, @Param("killTime")Date killTime);

    Seckill queryById(long seckillId);

    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
