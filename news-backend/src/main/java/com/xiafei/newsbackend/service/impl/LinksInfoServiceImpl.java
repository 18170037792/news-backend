package com.xiafei.newsbackend.service.impl;

import com.xiafei.newsbackend.dao.LinksInfoDao;
import com.xiafei.newsbackend.entity.links.LinksInfoAddEntity;
import com.xiafei.newsbackend.entity.links.LinksInfoEntity;
import com.xiafei.newsbackend.exception.ServiceException;
import com.xiafei.newsbackend.pojo.table.LinksInfoTable;
import com.xiafei.newsbackend.service.LinksInfoService;
import com.xiafei.newsbackend.util.Constant;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class LinksInfoServiceImpl implements LinksInfoService {

    @Autowired
    private LinksInfoDao infoDao;

    /**
     * 新增友情链接
     * @param entity
     * @throws Exception
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insert(LinksInfoAddEntity entity) throws Exception {
        LinksInfoTable table = new LinksInfoTable();
        BeanUtils.copyProperties(entity,table);
        int result = infoDao.insert(table);
        if(result <1){
            throw new ServiceException(Constant.SYSTEM_ERROR);
        }
    }

    /**
     * 友情链接列表
     * @throws Exception
     * @return List<LinksInfoEntity>
     * */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<LinksInfoEntity> getList() throws Exception {
        List<LinksInfoTable> tables = infoDao.getList();
        List<LinksInfoEntity> entities = new ArrayList<>();
        for (LinksInfoTable table :tables
                ) {
            LinksInfoEntity entity = new LinksInfoEntity();
            BeanUtils.copyProperties(table,entity);
            entities.add(entity);
        }
        return entities;
    }
}
