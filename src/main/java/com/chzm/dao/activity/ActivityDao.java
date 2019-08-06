package com.chzm.dao.activity;

import com.chzm.model.avtivity.ActivityDetail;
import com.chzm.model.avtivity.ActivityInfo;
import com.chzm.model.avtivity.ActivityJoinDetail;
import com.chzm.model.avtivity.PlayRole;
import com.chzm.param.ActivityQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityDao {

    List<ActivityDetail> queryActivityDetail(ActivityQueryParam param);

    List<ActivityDetail> queryActivityDetailById(@Param("id")String id);

    List<ActivityInfo> queryActivityInfo();

    void creatActivity(@Param("activityId")String activityId,
                       @Param("openId")String openId,
                       @Param("startTime")String startTime,
                       @Param("endTime")String endTime);

    void delActivity(@Param("id")String id);

    List<ActivityJoinDetail> queryActivityJoinDetail(@Param("activityDetailId") String activityDetailId);

    void joinActivity(@Param("openId")String openId,
                      @Param("activityId")String activityId,
                      @Param("playRoleId")String playRoleId);

    void quitActivity(@Param("activityId")String activityId, @Param("openId")String openId);

    List<PlayRole> queryPlayRoles(ActivityQueryParam param);

    List<ActivityJoinDetail> checkActivityJoin(@Param("activityDetailId")String id, @Param("openId")String openId);

    List<ActivityJoinDetail> queryActivityJoinDetailById(@Param("id")String id);
}
