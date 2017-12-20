package com.icusin.dao.mapper;

import com.icusin.dao.constant.ContextConst;
import com.icusin.dao.po.UserInfoPO;
import com.icusin.dao.util.MockUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

/**
 * @author brainy
 * @date 2017-12-20 9:49
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ContextConst.CONTEXT_CONFIG_STR)
public class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void insertTest() {

        UserInfoPO userInfoPO = MockUtils.mockUserInfo();
        int result = userInfoMapper.insert(userInfoPO);
        assertTrue(result > 0);

        userInfoMapper.deleteByPrimaryKeyDangerously(userInfoPO.getId());
    }

    @Test
    public void insertSelectiveTest() {

        UserInfoPO userInfoPO = MockUtils.mockUserInfo();
        int result = userInfoMapper.insertSelective(userInfoPO);
        assertTrue(result > 0);

        userInfoMapper.deleteByPrimaryKeyDangerously(userInfoPO.getId());
    }

    @Test
    public void updateByPrimaryKeySelectiveTest() {

        UserInfoPO userInfoPO = MockUtils.mockUserInfo();
        userInfoMapper.insert(userInfoPO);

        UserInfoPO readyToUpdate = new UserInfoPO();
        readyToUpdate.setId(userInfoPO.getId());
        readyToUpdate.setMarkStatus((byte) 0);

        int result = userInfoMapper.updateByPrimaryKeySelective(readyToUpdate);
        assertTrue(result > 0);

        userInfoMapper.deleteByPrimaryKeyDangerously(userInfoPO.getId());
    }

    @Test
    public void updateByPrimaryKeyTest() {

        UserInfoPO userInfoPO = MockUtils.mockUserInfo();
        userInfoMapper.insert(userInfoPO);

        UserInfoPO readyToUpdate = new UserInfoPO();
        readyToUpdate.setId(userInfoPO.getId());
        readyToUpdate.setMarkStatus((byte) 0);

        int result = userInfoMapper.updateByPrimaryKey(readyToUpdate);
        assertTrue(result > 0);

        userInfoMapper.deleteByPrimaryKeyDangerously(userInfoPO.getId());
    }

    @Test
    public void selectByIdentifierTest() {

        UserInfoPO userInfoPO = MockUtils.mockUserInfo();
        userInfoMapper.insert(userInfoPO);

        UserInfoPO query = userInfoMapper.selectByIdentifier(userInfoPO.getUserAccount());
        assertTrue(userInfoPO.getUserAccount().equals(query.getUserAccount()));

        query = userInfoMapper.selectByIdentifier(userInfoPO.getUserMobile());
        assertTrue(userInfoPO.getUserMobile().equalsIgnoreCase(query.getUserMobile()));

        query = userInfoMapper.selectByIdentifier(userInfoPO.getUserEmail());
        assertTrue(userInfoPO.getUserEmail().equalsIgnoreCase(query.getUserEmail()));

        userInfoMapper.deleteByPrimaryKeyDangerously(userInfoPO.getId());
    }

    @Test
    public void selectByUserAccount() {

        UserInfoPO userInfoPO = MockUtils.mockUserInfo();
        userInfoMapper.insert(userInfoPO);

        UserInfoPO query = userInfoMapper.selectByUserAccount(userInfoPO.getUserAccount());
        assertTrue(userInfoPO.getUserAccount().equalsIgnoreCase(query.getUserAccount()));

        userInfoMapper.deleteByPrimaryKeyDangerously(userInfoPO.getId());
    }
}
