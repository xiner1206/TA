package com.ta.framework.service.Impl;

import com.ta.framework.dao.PictureDao;
import com.ta.framework.dao.ScoreDao;
import com.ta.framework.dao.StoreDao;
import com.ta.framework.entity.Picture;
import com.ta.framework.entity.Score;
import com.ta.framework.entity.Store;
import com.ta.framework.entity.Vo.Ids;
import com.ta.framework.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreSeriveImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;
    @Autowired
    private StoreDao storeDao;
    @Autowired
    private PictureDao pictureDao;

    @Override
    public List<Store> betterStore(List<Store> stores) {
        List<Score> scoreList = new LinkedList<>();
        for (Store store:stores) {
            Score score = scoreDao.avgScore(store);
            if(score.getTotalScore()==null){
                scoreList.add(new Score(0d,0d,0d,0d,0,store));
            }else {
                scoreList.add(score);
            }
        }
        int tatlStore = scoreList.size();
        int betterStore = 0;

        if(tatlStore!=0) {
            betterStore = tatlStore / 5;
            for(int i=0;i<tatlStore-1;i++){
                for(int j=0;j<tatlStore-1-i;j++) {
                    if (scoreList.get(j).getTotalScore() < scoreList.get(j + 1).getTotalScore()) {
                        Collections.swap(scoreList,j,j+1);
                    }
                }
            }
            for(Score score:scoreList){
                System.out.println(score.toString());
            }
            for(int i=0;i<betterStore;i++) {
                for (Store store : stores) {
                    if (scoreList.get(i).getStore().getStoreId() == store.getStoreId()) {
                        store.setBetterStore(true);
                    }
                }
            }
        }
        return stores;
    }

    @Override
    public List<Score> compareStore(Ids storeIds) {
        List<Score> scoreList = new ArrayList<>();
        for(Integer i:storeIds.getStoreIds()){
            Store store = storeDao.selectById(i);
            if(scoreDao.avgScore(store).getTotalScore()==null){
                scoreList.add(new Score(0d,0d,0d,0d,0,store));
            }else {
                scoreList.add(scoreDao.avgScore(store));
            }
        }
        for (Score score : scoreList) {
            List<Integer> picIdList = score.getStore().getStorePicIdList();
            List<Picture> storePicList = new ArrayList<>();
            for (Integer picId : picIdList) {
                storePicList.add(pictureDao.selectById(picId));
            }
            score.getStore().setUrl(storePicList.get(0).getUrl());
        }
        return scoreList;
    }

}
