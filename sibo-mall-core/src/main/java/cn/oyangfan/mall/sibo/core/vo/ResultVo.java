package cn.oyangfan.mall.sibo.core.vo;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * 将所有的接口的响应数据的格式进行统一
 *
 * @auth 张庆生
 * @date 2020/11/20 13:53
 */
@Data
public class ResultVo {

    /**
     * 错误码
     */
    private int code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 具体的内容
     */
    private Object data;

    /**
     * 成功的标识
     */
    public static final String SUCCESS_MESSAGE = "success";

    /**
     * 创建实例
     *
     * @return
     */
    public static ResultVo create() {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(HttpStatus.OK.value());
        resultVo.setMessage(SUCCESS_MESSAGE);
        return resultVo;
    }

    /**
     * 创建实例
     *
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static ResultVo create(int code, String message, Object data) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(HttpStatus.OK.value());
        resultVo.setMessage(SUCCESS_MESSAGE);
        resultVo.setData(data);
        return resultVo;
    }

}
