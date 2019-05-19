package com.ta.framework.controller;

import com.ta.framework.dao.ScoreDao;
import com.ta.framework.dao.StoreDao;
import com.ta.framework.entity.Score;
import com.ta.framework.entity.Store;
import com.ta.framework.entity.Vo.Ids;
import com.ta.framework.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ScoreControllrt {

    @Autowired
    private ScoreDao scoreDao;
    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/score/insert",method = RequestMethod.POST)
    @ResponseBody
    public int insert(@RequestBody Score Score){
        return scoreDao.insert(Score);
    }

    @RequestMapping(value = "/score/avgScore",method = RequestMethod.POST)
    @ResponseBody
    public Score avgScore(@RequestBody Store store){
        if(scoreDao.avgScore(store).getTotalScore()==null){
         return new Score(0d,0d,0d,0d,0,store);
        }else {
            return scoreDao.avgScore(store);
        }

    }

    @RequestMapping(value = "/score/compareStore",method = RequestMethod.POST)
    @ResponseBody
    public  List<Score> compareStore(@RequestBody Ids storeIds){
        return scoreService.compareStore(storeIds);
    }
}
