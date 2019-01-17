package com.xiafei.newsbackend.controller.user;

import com.xiafei.newsbackend.controller.BaseController;
import com.xiafei.newsbackend.entity.enu.LogActions;
import com.xiafei.newsbackend.entity.log.LogInfoAddEntity;
import com.xiafei.newsbackend.entity.message.MessageArticleEntity;
import com.xiafei.newsbackend.entity.message.MessageInfoSearchEntity;
import com.xiafei.newsbackend.entity.message.MessageInfoUpdateEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.service.LogInfoService;
import com.xiafei.newsbackend.service.MessageInfoService;
import com.xiafei.newsbackend.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;

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
    @Autowired
    private LogInfoService logInfoService;

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

    /**
     * 修改留言状态
     * @param updateEntity
     * @param bindingResult
     * @param request
     * @param response
     * @throws Exception
     * */
    @RequestMapping("/updateStatus")
    @ResponseBody
    public JsonResult updateStatus(@RequestBody @Valid MessageInfoUpdateEntity updateEntity,BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response) throws Exception{
        /**
         * 字段验证
         * */
        if(bindingResult.hasErrors()){
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            return new JsonResult(Constant.FAILED_CODE,defaultMessage);
        }

        /**
         * 获取登录用户id
         * */
        Long userId = this.getUserId(request, response);
        updateEntity.setModifyUser(userId);
        /**
         * 调用service执行修改
         * */
        messageInfoService.updateMessage(updateEntity);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.UPDATE_SUCCESS);
    }

    /**
     * 删除留言并上传日志
     * */
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delComment(@RequestParam Long id,HttpServletRequest request,HttpServletResponse response) throws Exception{
        /**
         * 获取登录人用户id
         * */
        Long userId = this.getUserId(request, response);
        /**
         * 调用service删除
         * */
        messageInfoService.delComment(id);

        /**
         * 添加系统日志
         * */
        LogInfoAddEntity logInfoAddEntity = new LogInfoAddEntity();
        logInfoAddEntity.setAuthorId(userId);
        logInfoAddEntity.setAction(LogActions.DEL_COMMENT.getAction());
        logInfoAddEntity.setIpHomeLocation(AddressUtils.getIpDescr(GetIpAndMac.getIp(request)));
        logInfoAddEntity.setLastLoginIp(GetIpAndMac.getIp(request));
        logInfoAddEntity.setLastLoginTime(new Date());

        logInfoService.insertLog(logInfoAddEntity);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.DELETE_SUCCESS);
    }

}
