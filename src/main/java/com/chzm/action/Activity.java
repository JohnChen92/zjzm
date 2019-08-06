package com.chzm.action;

import javax.servlet.http.HttpServletRequest;

import com.chzm.model.avtivity.ActivityInfo;
import com.chzm.model.avtivity.ActivityDetail;
import com.chzm.model.avtivity.ActivityJoinDetail;
import com.chzm.model.avtivity.PlayRole;
import com.chzm.model.user.User;
import com.chzm.service.user.UserService;
import com.chzm.utils.EmptyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.chzm.model.sys.RespenseBean;
import com.chzm.param.ActivityQueryParam;
import com.chzm.service.activity.ActivityService;

import java.util.List;


@Controller
@RequestMapping("/activity")
public class Activity {
	
	private static final Logger logger = LoggerFactory.getLogger(Activity.class);
	
	@Autowired
	private ActivityService activityService;

	@Autowired
	private UserService userService;
	
	
	//---------------------------------------------------------------   创建活动    -------------------------------------------------------------------------------//
	
	/**
	 * //查询列表
	 * @param request
	 * @param param
	 * @return
	 */
	@RequestMapping("queryActivity")
	@ResponseBody
	public RespenseBean<?> queryActivity(HttpServletRequest request,ActivityQueryParam param){
		logger.info("queryActivity:{}",JSON.toJSONString(param));
		List<ActivityDetail> activityDetail = null;
		try {
			//查询列表
			activityDetail = activityService.queryActivityDetail(param);
			logger.info(JSON.toJSONString(activityDetail));
		} catch (Exception e) {
			logger.info("queryActivity error!",e);
			return new RespenseBean("FAIL", "ActivityQueryFail", "查询失败！");
		}
		return  new RespenseBean("SUCCESS", "ActivityQuerySuccess", "查询成功！",activityDetail,null);
	}
	
	
	/**
	 *   创建
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping("creatActivity")
	@ResponseBody
	public RespenseBean<?> creatActivity(HttpServletRequest request,ActivityQueryParam param){
		logger.info("creatActivity:{}",JSON.toJSONString(param));
		try {
			activityService.creatActivity(param);
		} catch (Exception e) {
			logger.info("creatActivity error!",e);
			return new RespenseBean("FAIL", "ActivityCreatFail", "保存失败！");
		}
		return  new RespenseBean("SUCCESS", "ActivityCreatSuccess", "保存成功！");
	}
	
	
	
	/**
	 * 修改的回显
	 * @param request
	 * @param
	 * @return
	 */
	@RequestMapping("updateActivity")
	@ResponseBody
	public RespenseBean<?> updateActivity(HttpServletRequest request,ActivityQueryParam param){
		logger.info("updateActivity:{}",JSON.toJSONString(param));
		try {

		} catch (Exception e) {
			logger.info("updateActivity error!",e);
			return new RespenseBean("FAIL", "ActivityUpdateFail", "修改失败！");
		}
		return  new RespenseBean("SUCCESS", "ActivityUpdateSuccess", "修改成功！");
	}
	
	/**
	 * 修改保存
	 */

	
	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping("delActivity")
	@ResponseBody
	public RespenseBean<?> delActivity(HttpServletRequest request,ActivityQueryParam param){
		logger.info("delActivity:{}",JSON.toJSONString(param));
		try {
			activityService.delActivity(param.getId());
		} catch (Exception e) {
			logger.info("delActivity error!",e);
			return new RespenseBean("FAIL", "ActivityDelFail", "删除失败！");
		}
		return  new RespenseBean("SUCCESS", "ActivityDelSuccess", "删除成功！");
	}
	
	/**
	 * 查询副本的信息
	 */
	
	
	//---------------------------------------------------------------   加入活动  --------------------------------------------------------------------------//


	/**
	 * 	查询已加入活动名单
	 * @param request
	 * @param param
	 * @return
	 */
	@RequestMapping("queryActivityJoinDetail")
	@ResponseBody
	public RespenseBean<?> queryActivityJoinDetail(HttpServletRequest request,ActivityQueryParam param){
		logger.info("queryActivityJoinDetail:{}",JSON.toJSONString(param));
		List<ActivityJoinDetail> list = null;
		try {
			// TODO 添加筛选条件
			list = activityService.queryActivityJoinDetail(param.getId());
			logger.info(JSON.toJSONString(list));
		} catch (Exception e) {
			logger.info("queryActivityJoinDetail error!",e);
			return new RespenseBean("FAIL", "ActivityJoinDetailFail", "查询失败！");
		}
		return  new RespenseBean("SUCCESS", "ActivityJoinDetailSuccess", "查询成功！",list,null);
	}

	//幂等校验
	@RequestMapping("checkActivityJoin")
	@ResponseBody
	public RespenseBean<?> checkActivityJoin(HttpServletRequest request,ActivityQueryParam param){
		logger.info("checkActivityJohn:{}",JSON.toJSONString(param));
		List<ActivityJoinDetail> list = null;
		try {
			// TODO 添加筛选条件
			list = activityService.checkActivityJoin(param.getActivityId(),param.getOpenId());
			logger.info(JSON.toJSONString(list));
		} catch (Exception e) {
			logger.info("checkActivityJohn error!",e);
			return new RespenseBean("FAIL", "checkActivityJohnFail", "校验失败！");
		}
		if(EmptyUtil.isEmpty(list)){
			return  new RespenseBean("SUCCESS", "1", "校验成功！");

		}else{
			return  new RespenseBean("SUCCESS", "0", "校验成功！");
		}
	}

	//加入活动
	@RequestMapping("joinActivity")
	@ResponseBody
	public RespenseBean<?> joinActivity(HttpServletRequest request,ActivityQueryParam param){
		logger.info("joinActivity:{}",JSON.toJSONString(param));
		try {
			activityService.joinActivity(param);
		} catch (Exception e) {
			logger.info("joinActivity error!",e);
			return new RespenseBean("FAIL", "JoinActivityFail", "加入失败！");
		}
		return  new RespenseBean("SUCCESS", "JoinActivitySuccess", "加入成功！");
	}

	//删除活动
	@RequestMapping("quitActivity")
	@ResponseBody
	public RespenseBean<?> quitActivity(HttpServletRequest request,ActivityQueryParam param){
		logger.info("quitActivity:{}",JSON.toJSONString(param));
		try {
			activityService.quitActivity(param);
		} catch (Exception e) {
			logger.info("quitActivity error!",e);
			return new RespenseBean("FAIL", "quitActivityFail", "退出失败！");
		}
		return  new RespenseBean("SUCCESS", "quitActivitySuccess", "退出成功！");
	}
	//修改活动





	//---------------------------------------------------------------   查询活动信息  --------------------------------------------------------------------------//
	@RequestMapping("queryActivityInfo")
	@ResponseBody
	public RespenseBean<?> queryActivityInfo(HttpServletRequest request,ActivityQueryParam param){
		logger.info("queryActivityInfo:{}",JSON.toJSONString(param));
		List<ActivityInfo> list = null;
		try {
			list = activityService.queryActivityInfo();
		} catch (Exception e) {
			logger.info("queryActivityInfo error!",e);
			return new RespenseBean("FAIL", "ActivityInfoFail", "查询失败！");
		}
		return  new RespenseBean("SUCCESS", "ActivityInfoSuccess", "查询成功！",list,null);
	}

	//---------------------------------------------------------------   查询角色信息  --------------------------------------------------------------------------//
	@RequestMapping("queryPlayRoles")
	@ResponseBody
	public RespenseBean<?> queryPlayRoles(HttpServletRequest request,ActivityQueryParam param){
		logger.info("queryPlayRoles:{}",JSON.toJSONString(param));
		List<PlayRole> list = null;
		try {
			list = activityService.queryPlayRoles(param);
		} catch (Exception e) {
			logger.info("queryPlayRoles error!",e);
			return new RespenseBean("FAIL", "queryPlayRolesFail", "查询失败！");
		}
		return  new RespenseBean("SUCCESS", "queryPlayRolesSuccess", "查询成功！",list,null);
	}
	
	
	
	//---------------------------------------------------------------   登录  --------------------------------------------------------------------------//

	//初次登录查询
	@RequestMapping("login")
	@ResponseBody
	public RespenseBean<?> login(HttpServletRequest request, User param){
		logger.info("login:{}",JSON.toJSONString(param));
		List<User> list = null;
		try {
			list = userService.loginAndCreate(param);
		} catch (Exception e) {
			logger.info("login error!",e);
			return new RespenseBean("FAIL", "loginFail", "登录失败！");
		}
		return  new RespenseBean("SUCCESS", "loginSuccess", "登录成功！",list,null);
	}


	//设置昵称
	@RequestMapping("setNickName")
	@ResponseBody
	public RespenseBean<?> setNickName(HttpServletRequest request, User param){
		logger.info("setNickName:{}",JSON.toJSONString(param));
		try {
			userService.UpdateUser(param);
		} catch (Exception e) {
			logger.info("setNickName error!",e);
			return new RespenseBean("FAIL", "setNickNameFail", "设置失败！");
		}
		return  new RespenseBean("SUCCESS", "setNickNameSuccess", "设置成功！");
	}

	//查询
	@RequestMapping("queryUser")
	@ResponseBody
	public RespenseBean<?> queryUser(HttpServletRequest request, User param){
		logger.info("queryUser:{}",JSON.toJSONString(param));
		List<User> list = null;
		try {
			list = userService.queryUser(param);
		} catch (Exception e) {
			logger.info("queryUser error!",e);
			return new RespenseBean("FAIL", "queryUserFail", "查询失败！");
		}
		return  new RespenseBean("SUCCESS", "queryUserSuccess", "查询成功！",list,null);
	}
}




