package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.IndexBannerDao;
import com.xiafei.newsbackend.entity.banner.IndexBannerEntity;
import com.xiafei.newsbackend.pojo.table.IndexBannerTable;
import com.xiafei.newsbackend.pojo.view.IndexBannerView;
import com.xiafei.newsbackend.service.IndexBannerService;
import com.xiafei.newsbackend.util.Common;
import com.xiafei.newsbackend.util.ValidateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qujie on 2019/1/21
 * 首页轮播业务层
 * */
@Service
public class IndexBannerServiceImpl implements IndexBannerService {

    @Autowired
    private IndexBannerDao bannerDao;

    /**
     * 查询首页轮播文章信息
     * @throws Exception
     * */
    @Override
    public List<IndexBannerEntity> getHomeArticleBanner() throws Exception {

        List<IndexBannerView> views = bannerDao.getHomeArticleBanner();
        if(views == null || views.size()==0){
            return null;
        }

        /**
         * 赋值
         * */
        List<IndexBannerEntity> entities = new ArrayList<>();
        for (IndexBannerView view : views
                ) {
            IndexBannerEntity entity = new IndexBannerEntity();
            BeanUtils.copyProperties(view,entity);
            entities.add(entity);
        }
        return entities;
    }
}
