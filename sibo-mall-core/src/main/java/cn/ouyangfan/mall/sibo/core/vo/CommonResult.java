package cn.ouyangfan.mall.sibo.core.vo;

import org.springframework.http.HttpStatus;

/**
 * 通用的返回结果格式
 */
public class CommonResult<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 返回单额数据
     */
    private T data;


    public CommonResult() {
        this(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), null);
    }


    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


}
