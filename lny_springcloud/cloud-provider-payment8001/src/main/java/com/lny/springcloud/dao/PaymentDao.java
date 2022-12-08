package com.lny.springcloud.dao;

import com.lny.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    /**
     * 新增
     * @param payment
     * @return
     */
    int add(Payment payment);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Payment queryById(@Param("id")Long id);

}
