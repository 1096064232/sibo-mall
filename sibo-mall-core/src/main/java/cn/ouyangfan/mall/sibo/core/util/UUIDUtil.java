package cn.ouyangfan.mall.sibo.core.util;

public class UUIDUtil {


    /**
     * 生成订单号
     *
     * @return 订单号
     */
    public static String generateOrderNo() {

        StringBuilder orderNo = new StringBuilder("ONO-");
        // 获取当前时间串
        orderNo.append(DateUtils.getCurrentTimeSeriesToMillisecond());
        // 从redis取出当天的订单增编号，
        synchronized (UUIDUtil.class) {
            orderNo.append("从redis取出当天的订单增编号加一，并更新redis的订单自增编号 ");
        }
        return orderNo.toString();
    }

    /**
     * 生成支付号
     *
     * @return 支付号
     */
    public static String generatePaymentNo() {


        StringBuilder orderNo = new StringBuilder("PNO-");
        // 获取当前时间串
        orderNo.append(DateUtils.getCurrentTimeSeriesToMillisecond());
        // 从redis取出当天的支付自增编号，
        synchronized (UUIDUtil.class) {
            orderNo.append("从redis取出当天的支付自增编号加一，并更新redis的支付自增编号 ");
        }
        return orderNo.toString();
    }

    /**
     * 根据用户类型生成用户编号
     *
     * @return 用户编号
     */
    public static String generateUserNoByUserType() {

        return null;
    }


}

