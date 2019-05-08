package com.ta.framework.service;

import com.ta.framework.entity.Activity;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.entity.Vo.tradeAc;

import java.util.List;

public interface ActivityService {

    public Page<Activity> select(Page<Activity> activityPage);

    public int countByPage(Page<Activity> activityPage);

    public int addAndUpdateActivity(Activity activity);

    Integer countTradeAc(Page<tradeAc> page);

    Page<tradeAc> pageTradeAc( Page<tradeAc> page);

}
