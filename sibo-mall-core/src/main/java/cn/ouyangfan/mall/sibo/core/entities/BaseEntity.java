package cn.ouyangfan.mall.sibo.core.entities;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

/**
 * entity基类
 */
@Setter
@Getter
public class BaseEntity implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建人
     */
    private Long creater;

    /**
     * 创建时间
     */
    private Long createDate;

    /**
     * 修改人
     */
    private Long modifiedBy;

    /**
     * 修改时间
     */
    private Long modifyDate;

    /**
     * equals()
     *
     * @param obj
     * @return 是否相等
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        BaseEntity that = (BaseEntity) obj;
        return id.equals(that.id);
    }

    /**
     * hashCode()
     *
     * @return hash值
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
