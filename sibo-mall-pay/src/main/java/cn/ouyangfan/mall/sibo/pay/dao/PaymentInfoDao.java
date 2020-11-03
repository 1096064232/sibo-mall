package cn.ouyangfan.mall.sibo.pay.dao;

import cn.ouyangfan.mall.sibo.pay.entities.PaymentInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * dao
 */
@Mapper
public interface PaymentInfoDao {

    /**
     * 创建支付
     *
     * @param paymentInfo 支付信息
     * @return
     */
    public int createPay(PaymentInfo paymentInfo);
}
