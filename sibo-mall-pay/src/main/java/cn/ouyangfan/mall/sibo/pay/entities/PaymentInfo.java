package cn.ouyangfan.mall.sibo.pay.entities;

import cn.ouyangfan.mall.sibo.core.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * 支付信息实体类
 */
@Setter
@Getter
public class PaymentInfo extends BaseEntity {

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 系统支付号
     */
    private String systemPaymentNo;

    /**
     * 第三方支付号
     */
    private String thirdPaymentNo;

    /**
     * 支付金额
     */
    private BigDecimal paymentAmount;

    /**
     * 支付类型
     */
    private String paymentType;

    /**
     * 支付状态
     */
    private String paymentStatus;

    /**
     * 支付失败原因
     */
    private String paymentFailSeason;

    /**
     * 附加信息
     */
    private String attachInfo;

}
