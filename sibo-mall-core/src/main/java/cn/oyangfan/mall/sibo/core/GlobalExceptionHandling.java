package cn.oyangfan.mall.sibo.core;

import cn.oyangfan.mall.sibo.core.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 *
 * @auth 张庆生
 * @date 2020/11/20 14:23
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandling {

    /**
     * 通用异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultVo exception(Exception e) {
        e.printStackTrace();
        return ResultVo.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), null);
    }
}
