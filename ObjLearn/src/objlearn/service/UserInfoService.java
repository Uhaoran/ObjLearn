/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objlearn.service;

import java.util.List;
import objlearn.dao.UserInfoDao;
import objlearn.dto.UserInfoDto;
import objlearn.entity.UserInfoEntity;

/**
 *
 * @author WU HAORAN
 */
public class UserInfoService {

    UserInfoDao userInfoDao = new UserInfoDao();

    public void createUserInfo(UserInfoDto userInfoDto) {

        System.out.println(userInfoDto.getName());
        System.out.println(userInfoDto.getUserId());
        System.out.println(userInfoDto.getAge());

        UserInfoEntity entity = new UserInfoEntity();
        entity.setName(userInfoDto.getName());
        entity.setUserId(userInfoDto.getUserId());
        entity.setAge(userInfoDto.getAge());

        userInfoDao.createUserInfo(entity);

    }

    public void selectAll() {

        List<UserInfoEntity> list = userInfoDao.selectUserInfo();
        for (UserInfoEntity e : list) {
            System.out.println(e.getName() + ":" + e.getUserId() + ":" + e.getAge());
        }

    }

}
