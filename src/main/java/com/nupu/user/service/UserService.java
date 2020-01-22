package com.nupu.user.service;

import com.nupu.common.domain.Result;
import com.nupu.common.domain.ResultEnum;
import com.nupu.user.domain.User;
import com.nupu.user.domain.UserLog;
import com.nupu.user.repository.UserLogRepository;
import com.nupu.user.repository.UserRepository;
import com.nupu.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 处理用户登录数据
 *
 * @author liwei
 * @date 2018/03/09 15:15
 */
@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLogRepository userLogRepository;

    /**
     * 登录数据管理系统，并记录登录信息
     *
     * @param userName 用户名
     * @param password 密码
     * @param ip       登录ip
     * @param place    登录地点
     * @param date     登录时间
     *                 return Result
     */
    public Result login(String userName, String password, String ip, String place, String date) {
        User user = userRepository.findByUserNameAndPassword(userName, password);
        if (user == null) {
            logger.error("登录失败：用户不存在");
            return ResultUtil.error(ResultEnum.LOGIN_ERROR.getCode(), ResultEnum.LOGIN_ERROR.getMsg());
        }
        UserLog userLog = new UserLog(userName, password, ip, place, date);
        userLogRepository.save(userLog);
        return ResultUtil.success(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), "用户登录成功");
    }

}
