package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * @Auther: dudou
 * @Date: 2018-11-08 11:09
 * @Email: 1017825998@qq.com
 * @Description:
 */
public interface SuccessKilledDao {

    //插入购买明细
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") Long userPhone);

    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") Long userPhone);
}
