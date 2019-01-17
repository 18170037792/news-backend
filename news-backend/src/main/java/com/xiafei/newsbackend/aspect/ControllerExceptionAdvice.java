package com.xiafei.newsbackend.aspect;

import com.alibaba.fastjson.JSONException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qujie on 2019/1/15
 * 统一controller异常处理
 */
@ControllerAdvice
public class ControllerExceptionAdvice {

    /**
     * 异常处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map controllerExceptionHandler(Exception e){
        Map map = new HashMap();
        if(e instanceof RuntimeException){
            map.put("code",500);
        }else {
            map.put("code",400);
        }
        if(e instanceof HttpMessageNotReadableException){
            map.put("msg","参数错误");
        }else if(e instanceof JSONException){
            map.put("msg","参数错误");
        }else {
            map.put("msg",e.getMessage());
        }
        return map;
    }
}
