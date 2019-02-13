package com.xiafei.newsbackend.controller.admin;

import com.xiafei.newsbackend.controller.BaseController;
import com.xiafei.newsbackend.entity.type.ArticleTypeAddEntity;
import com.xiafei.newsbackend.entity.type.ArticleTypeEntity;
import com.xiafei.newsbackend.entity.type.ArticleTypeModifyEntity;
import com.xiafei.newsbackend.service.ArticleTypeService;
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

/**
 * Created by qujie on 2019/1/30
 * 管理员分类管理控制器
 * */
@Controller
@RequestMapping("/admin/category")
public class ArticleTypeController extends BaseController {

    @Autowired
    ArticleTypeService typeService;

    @GetMapping("")
    public String categoryList(HttpServletRequest request) throws Exception{
        List<ArticleTypeEntity> typeList = typeService.getTypeList();
        request.setAttribute("categorys",typeList);
        return "admin/category";
    }

    @PostMapping("/delete")
    @ResponseBody
    public JsonResult deleteCategory(@RequestParam Long id) throws Exception{
        typeService.deleteCategory(id);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.DELETE_SUCCESS);
    }

    @PostMapping("/add")
    @ResponseBody
    public JsonResult addCategory(@Valid ArticleTypeAddEntity addEntity,
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
        Long userId = this.getAdminUserId(request, response);
        addEntity.setAddUser(userId);
        addEntity.setAddTime(new Date());
        addEntity.setAddIp(GetIpAndMac.getIp(request));

        /**
         * 调用服务
         * */
        typeService.addCategory(addEntity);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.ADD_SUCCESS);
    }

    @PostMapping("/modify")
    @ResponseBody
    public JsonResult modifyCategory(@Valid ArticleTypeModifyEntity modifyEntity,
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
        Long userId = this.getAdminUserId(request, response);
        modifyEntity.setModifyUser(userId);
        modifyEntity.setModifyTime(new Date());
        modifyEntity.setModifyIp(GetIpAndMac.getIp(request));

        /**
         * 调用服务
         * */
        typeService.modifyCategory(modifyEntity);
        return new JsonResult(Constant.SUCCESS_CODE,Constant.UPDATE_SUCCESS);
    }

}
