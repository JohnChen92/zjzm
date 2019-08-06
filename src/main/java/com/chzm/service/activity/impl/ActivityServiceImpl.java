package com.chzm.service.activity.impl;

import com.chzm.dao.activity.ActivityDao;
import com.chzm.model.avtivity.ActivityDetail;
import com.chzm.model.avtivity.ActivityInfo;
import com.chzm.model.avtivity.ActivityJoinDetail;
import com.chzm.model.avtivity.PlayRole;
import com.chzm.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chzm.param.ActivityQueryParam;
import com.chzm.service.activity.ActivityService;

import java.util.List;

@Service("activityService")
public class ActivityServiceImpl implements ActivityService{

	private static final Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);

	@Autowired
	private ActivityDao activityDao;

	@Autowired
	private UserService userService;

	@Override
	public List<ActivityDetail> queryActivityDetail(ActivityQueryParam param) {
		//查询活动列表
		return activityDao.queryActivityDetail(param);
	}

	@Override
	public List<ActivityInfo> queryActivityInfo() {
		return activityDao.queryActivityInfo();
	}

	@Override
	public void creatActivity(ActivityQueryParam param) {
		activityDao.creatActivity(param.getActivityId(),param.getOpenId(),param.getStartTime(),param.getEndTime());
	}

	@Override
	public void delActivity(String id) {
		activityDao.delActivity(id);
	}

	@Override
	public List<ActivityJoinDetail> queryActivityJoinDetail(String id) {
		return activityDao.queryActivityJoinDetail(id);
	}

	@Override
	public List<ActivityJoinDetail> checkActivityJoin(String id, String openId) {
		return activityDao.checkActivityJoin(id,openId);
	}

	@Override
	public void joinActivity(ActivityQueryParam param) {
		//幂等

		//加入
		activityDao.joinActivity(param.getOpenId(),param.getActivityId(),param.getPlayRoleId());
	}

	@Override
	public void quitActivity(ActivityQueryParam param) {
		if(userService.checkAdmin(param.getOpenId())){

		}

		activityDao.quitActivity(param.getActivityId(),param.getOpenId());
	}

	@Override
	public List<PlayRole> queryPlayRoles(ActivityQueryParam param) {
		return activityDao.queryPlayRoles(param);
	}

	@Override
	public List<ActivityJoinDetail> queryActivityJoinDetailById(String activityJoinDetailId) {
		return activityDao.queryActivityJoinDetailById(activityJoinDetailId);
	}


	@Override
	public List<ActivityDetail> queryActivityDetailById(String id) {
		return activityDao.queryActivityDetailById(id);
	}
}
