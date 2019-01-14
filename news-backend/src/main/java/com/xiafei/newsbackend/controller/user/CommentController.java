package com.xiafei.newsbackend.controller.user;

import com.xiafei.newsbackend.controller.BaseController;
import com.xiafei.newsbackend.entity.message.MessageArticleEntity;
import com.xiafei.newsbackend.entity.message.MessageInfoSearchEntity;
import com.xiafei.newsbackend.entity.message.MessageInfoUpdateEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.service.MessageInfoService;
import com.xiafei.newsbackend.util.Constant;
import com.xiafei.newsbackend.util.JsonResult;
import com.xiafei.newsbackend.util.ValidateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by qujie on 2019/1/14
 * 留言管理，目前只允许未登录游客留言
 * 暂时没有回复评论功能
 * */
@Controller
@RequestMapping("/user/comments")
public class CommentController extends BaseController {

    @Autowired
    private MessageInfoService messageInfoService;

    @GetMapping("")
    public String commentPage(@RequestParam(value = "current", defaultValue = "1") int current,
                              @RequestParam(value = "row", defaultValue = "7") int row,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
        /**
         * 获取登录人信息，设置分页条件
         * */
        Long userId = this.getUserId(request, response);
        PageLimitEntity limitEntity = new PageLimitEntity();
        limitEntity.setCurrent(current);
        limitEntity.setRow(row);
        MessageInfoSearchEntity searchEntity = new MessageInfoSearchEntity();
        searchEntity.setUserId(userId);
        searchEntity.setLimitEntity(limitEntity);

        /**
         * 调用service，执行分页查询
         * */
        PageShowEntity<MessageArticleEntity> showEntity = messageInfoService.getMessageWithPage(searchEntity);
        request.setAttribute("comments",showEntity);
        return "user/comment_list";
    }

    @PostMapping("/updateStatus")
    @ResponseBody
    public JsonResult updateStatus(@Valid MessageInfoUpdateEntity updateEntity) throws Exception{



//        /**
//         * 验证字段
//         * */
//        if(ValidateUtil.isNull(status)){
//            return new JsonResult(Constant.FAILED_CODE,Constant.PARAMETER_NOT_NULL);
//        }
//
//        if(status == 2){
//            messageInfoService.updateMessage();
//        }
//
        return null;
    }

}
