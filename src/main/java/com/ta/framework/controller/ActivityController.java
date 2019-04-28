package com.ta.framework.controller;

import com.ta.framework.dao.ActivityDao;
import com.ta.framework.entity.Activity;
import com.ta.framework.entity.Dto.Page;
import com.ta.framework.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class ActivityController {

    @Autowired
    private ActivityService activityService;


    @RequestMapping(value = "/activity/addOrUpdate",method = RequestMethod.POST)
    @ResponseBody
    public Integer addAndUpdateActivity(@RequestBody Activity activity){
        return activityService.addAndUpdateActivity(activity);
    }

    @RequestMapping(value = "/activity/page",method = RequestMethod.POST)
    @ResponseBody
    public Page<Activity> page(@RequestBody Page<Activity> activity) {
        return  activityService.select(activity);
    }

}
