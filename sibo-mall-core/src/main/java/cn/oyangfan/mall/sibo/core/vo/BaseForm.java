package cn.oyangfan.mall.sibo.core.vo;

/**
 * vo 抽象类
 *
 * @auth 张庆生
 * @date 2020/11/20 14:15
 */
public abstract class BaseForm<T> {

    /**
     * 获取实例
     *
     * @return 返回实体类
     */
    public abstract T buildEntity();

}
