package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auther: dudou
 * @Date: 2018-11-08 15:30
 * @Email: 1017825998@qq.com
 * @Description:
 */
/*
 *配置spring和junit整合，junit启动时加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() {
        Date KillTime=new Date();
        int updateCount=seckillDao.reduceNumber(1000,KillTime);
        System.out.println("updateCount="+updateCount);
    }

    @Test
    public void queryById() {
        long id = 1000;
        Seckill seckill=seckillDao.queryById(id);
        System.out.println(seckill.toString());
    }


    @Test
    public void queryAll() {
        List<Seckill> seckills = seckillDao.queryAll(0,4);
        for (Seckill seckill:seckills){
            System.out.println(seckill.toString());
        }
    }
}