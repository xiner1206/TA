package com.ta.framework.service.Impl;

import com.ta.framework.dao.PictureDao;
import com.ta.framework.dao.StoreDao;
import com.ta.framework.dao.UserDao;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Picture;
import com.ta.framework.entity.Store;
import com.ta.framework.entity.User;
import com.ta.framework.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;
    @Autowired
    private PictureDao pictureDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Page<Store> select(Page<Store> page) {
        assert page.getPageSize() > 0;
        if(page.getCondition() == null) {
            page.setCondition(new Store());
        }
        if(page.getPageNum() == null || page.getPageNum() <= 0) {
            page.setPageNum(1);
        }
        page.setTotalRecord(countByPage(page));
        Page<Store> pg = new Page<>(page.getPageNum(),page.getPageSize(),page.getTotalRecord());
        pg.setCondition(page.getCondition());
        List<Store> storeList = storeDao.selectByPage(pg);
        for (Store store:storeList) {
            List<Integer> picIdList = store.getStorePicIdList();
            List<Picture> storePicList = new ArrayList<>();
            for (Integer picId: picIdList) {
                storePicList.add(pictureDao.selectById(picId));
            }
            store.setStorePicList(storePicList);
        }
        pg.setList(storeList);
        return pg;

    }

    @Override
    public int countByPage(Page<Store> page) {
        assert page.getPageSize() > 0;
        if(page.getCondition() == null) {
            page.setCondition(new Store());
        }
        if(page.getPageNum() == null || page.getPageNum() <= 0) {
            page.setPageNum(1);
        }

        return storeDao.countByPage(page);
    }

    @Override
    public int addAndUpdateStore(Store store) {

        List<Integer> storeIdList = new ArrayList<>();
        store.setStorePicIdList(storeIdList);
        storeIdList.clear();
        storeIdList.addAll(getPicIdList(store));
        if(store.getStoreId() == null || store.getStoreId() == 0) {
            addUser(store);
            return storeDao.insert(store);
        }
        else {
            addUser(store);
            return storeDao.update(store);
        }
    }

    public int  addUser(Store store) {
        if (store.getUser() != null){
                List<User> users = userDao.select(new User(store.getUser().getUserNum()));
            if (users.size() != 0)
                return 0;
            else {
                store.getUser().setUserState(3);
                return userDao.insert(store.getUser());
            }
        }else{
            return 0;
        }
    }

    public List<Integer> getPicIdList(Store store){
        List<Integer> listid = new ArrayList<>();
        for(Picture picture:store.getStorePicList()){
            listid.add(picture.getPictureId());
            pictureDao.update(picture);
        }
        return  listid;
    }
}
