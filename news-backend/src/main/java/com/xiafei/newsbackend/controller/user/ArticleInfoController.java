package com.xiafei.newsbackend.controller.user;

import com.xiafei.newsbackend.controller.BaseController;
import com.xiafei.newsbackend.entity.article.ArticleAndTypeEntity;
import com.xiafei.newsbackend.entity.article.ArticleInfoSearchEntity;
import com.xiafei.newsbackend.entity.article.ArticleModifyEntity;
import com.xiafei.newsbackend.entity.article.ArticlePublishEntity;
import com.xiafei.newsbackend.entity.enu.LogActions;
import com.xiafei.newsbackend.entity.log.LogInfoAddEntity;
import com.xiafei.newsbackend.entity.page.PageLimitEntity;
import com.xiafei.newsbackend.entity.page.PageShowEntity;
import com.xiafei.newsbackend.entity.type.ArticleTypeEntity;
import com.xiafei.newsbackend.service.ArticleInfoService;
import com.xiafei.newsbackend.service.ArticleTypeService;
import com.xiafei.newsbackend.service.LogInfoService;
import com.xiafei.newsbackend.util.AddressUtils;
import com.xiafei.newsbackend.util.Constant;
import com.xiafei.newsbackend.util.GetIpAndMac;
import com.xiafei.newsbackend.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/article")
public class ArticleInfoController extends BaseController {

    @Autowired
    private ArticleInfoService service;
    @Autowired
    private ArticleTypeService typeService;
    @Autowired
    private LogInfoService logInfoService;

    /**
     * 文章管理分页列表
     * @param current 当前页
     * @param row 分页条数
     * @throws Exception
     * */
    @GetMapping("/list")
    public String articleList(@RequestParam(value = "current", defaultValue = "1") int current,
                              @RequestParam(value = "row", defaultValue = "7") int row,
                              HttpServletRequest request, HttpServletResponse response) throws Exception{
        /**
         * 获取登录人信息，设置分页条件
         * */
        Long userId = this.getUserId(request, response);
        PageLimitEntity limitEntity = new PageLimitEntity();
        limitEntity.setCurrent(current);
        limitEntity.setRow(row);
        ArticleInfoSearchEntity searchEntity = new ArticleInfoSearchEntity();
        searchEntity.setUserId(userId);
        searchEntity.setLimitEntity(limitEntity);

        /**
         * 调用service，执行分页列表查询
         * */
        PageShowEntity<ArticleAndTypeEntity> showEntity = service.getArticleWithPage(searchEntity);
        request.setAttribute("articles",showEntity);

        return "user/article_list";
    }

    /**
     * 文章发表页
     * */
    @GetMapping("/publish")
    public String newArticle(HttpServletRequest request) throws Exception {
        /**
         * 拉取文章分类列表，跳转到页面并赋值
         * */
        List<ArticleTypeEntity> typeList = typeService.getTypeList();
        request.setAttribute("types",typeList);
        return "user/article_edit";
    }

    /**
     * 文章编辑页
     * @param id
     * */
    @GetMapping(value = "/{id}")
    public String editArticle(@PathVariable Long id,HttpServletRequest request) throws Exception {
        /**
         * 根据文章id获取原文章信息，赋值给页面
         * */
        ArticleAndTypeEntity articleInfo = service.getArticleInfo(id);
        request.setAttribute("contents", articleInfo);
        /**
         * 拉取文章分类列表，并赋值
         * */
        List<ArticleTypeEntity> typeList = typeService.getTypeList();
        request.setAttribute("types",typeList);
        return "user/article_edit";
    }

    /**
     * 文章发表
     * @param publishEntity
     * @param response
     * @throws Exception
     * */
    @PostMapping("/publish")
    @ResponseBody
    public JsonResult publicArticle(@Valid ArticlePublishEntity publishEntity,
                                    BindingResult bindingResult,HttpServletRequest request, HttpServletResponse response) throws Exception{

        /**
         * 字段验证
         * */
        if(bindingResult.hasErrors()){
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            return new JsonResult(Constant.FAILED_CODE,defaultMessage);
        }

        /**
         * 获取登录人信息
         * */
        Long userId = this.getUserId(request, response);
        publishEntity.setAddUser(userId);
        publishEntity.setAddIp(GetIpAndMac.getIp(request));
        publishEntity.setAddTime(new Date());

        /**
         * 调用service
         * */
        service.publishArticle(publishEntity);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.PUBLISH_SUCCESS);
    }

    /**
     * 文章编辑
     * */
    @PostMapping("/modify")
    @ResponseBody
    public JsonResult modifyArticle(@Valid ArticleModifyEntity modifyEntity,
                                    BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws Exception{
        /**
         * 字段验证
         * */
        if(bindingResult.hasErrors()){
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            return new JsonResult(Constant.FAILED_CODE,defaultMessage);
        }

        /**
         * 获取登录人信息
         * */
        Long userId = this.getUserId(request, response);
        modifyEntity.setModifyUser(userId);
        modifyEntity.setModifyTime(new Date());
        modifyEntity.setModifyIp(GetIpAndMac.getIp(request));

        /**
         * 调用service
         * */
        service.modifyArticle(modifyEntity);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.UPDATE_SUCCESS);
    }

    /**
     * 文章删除并上传日志
     * @param id
     * @param request
     * @param response
     * */
    @PostMapping("/delete")
    @ResponseBody
    public JsonResult deleteArticle(@RequestParam Long id,HttpServletRequest request,HttpServletResponse response) throws Exception{
        Long userId = this.getUserId(request, response);
        /**
         * 调用service执行删除
         * */
        service.deleteArticle(id);
        /**
         * 添加系统日志
         * */
        LogInfoAddEntity logInfoAddEntity = new LogInfoAddEntity();
        logInfoAddEntity.setAuthorId(userId);
        logInfoAddEntity.setAction(LogActions.DEL_ARTICLE.getAction());
        logInfoAddEntity.setIpHomeLocation(AddressUtils.getIpDescr(GetIpAndMac.getIp(request)));
        logInfoAddEntity.setLastLoginIp(GetIpAndMac.getIp(request));
        logInfoAddEntity.setLastLoginTime(new Date());

        logInfoService.insertLog(logInfoAddEntity);

        return new JsonResult(Constant.SUCCESS_CODE,Constant.DELETE_SUCCESS);
    }

}
