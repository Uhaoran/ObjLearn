/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objlearn.service;

import java.util.ArrayList;
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

    /**
     * ユーザー作成
     *
     * @param userInfoDto
     */
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

    /**
     * 全件検索
     */
    public List<UserInfoDto> selectAll() {

        List<UserInfoEntity> list = userInfoDao.selectUserInfo();

        List<UserInfoDto> dto = new ArrayList<>();

        for (UserInfoEntity e : list) {
            UserInfoDto d = new UserInfoDto();
            d.setName(e.getName());
            d.setUserId(e.getUserId());
            d.setAge(e.getAge());
            dto.add(d);
        }

        return dto;

    }

}
