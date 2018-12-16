package com.xiafei.newsbackend.util;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by tiziano on 2018/3/2
 */
public class InteceptorResultUtil {

    public static void returnResult(HttpServletResponse response, JsonResult<Object> jsonResult) throws Exception{
        response.setContentType("application/json");
        PrintWriter printWriter = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(jsonResult);
        printWriter.write(result);
        printWriter.flush();
        if(printWriter != null){
            printWriter.close();
        }
    }
}
