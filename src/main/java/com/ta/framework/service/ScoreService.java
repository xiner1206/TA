package com.ta.framework.service;

import com.ta.framework.entity.Score;
import com.ta.framework.entity.Store;
import com.ta.framework.entity.Vo.Ids;

import java.util.List;

public interface ScoreService {

    List<Store> betterStore(List<Store> stores);

    List<Score> compareStore(Ids storeIds);
}
