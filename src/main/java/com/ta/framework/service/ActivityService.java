package com.ta.framework.service;

import com.ta.framework.entity.Activity;
import com.ta.framework.entity.Dto.Page;

public interface ActivityService {

    public Page<Activity> select(Page<Activity> activityPage);

    public int countByPage(Page<Activity> activityPage);

    public int addAndUpdateActivity(Activity activity);
}
