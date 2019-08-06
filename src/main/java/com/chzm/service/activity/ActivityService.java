package com.chzm.service.activity;

import com.chzm.model.avtivity.ActivityDetail;
import com.chzm.model.avtivity.ActivityInfo;
import com.chzm.model.avtivity.ActivityJoinDetail;
import com.chzm.model.avtivity.PlayRole;
import com.chzm.param.ActivityQueryParam;

import java.util.List;

public interface ActivityService {

	List<ActivityDetail> queryActivityDetail(ActivityQueryParam param);

    List<ActivityDetail> queryActivityDetailById(String id);

    List<ActivityInfo> queryActivityInfo();

    void creatActivity(ActivityQueryParam param);

    void delActivity(String id);

    List<ActivityJoinDetail> queryActivityJoinDetail(String id);

    List<ActivityJoinDetail> checkActivityJoin(String id,String openId);

    void joinActivity(ActivityQueryParam param);

    void quitActivity(ActivityQueryParam param);

    List<PlayRole> queryPlayRoles(ActivityQueryParam param);

    List<ActivityJoinDetail> queryActivityJoinDetailById(String activityJoinDetailId);
}
