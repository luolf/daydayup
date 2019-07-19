package org.llf.service.impl;

import org.llf.common.Result;
import org.llf.dao.UserMapper;
import org.llf.pojo.User;
import org.llf.service.UserMgrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;


/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-15
 * Time 9:42
 */
@Service
public class UserMgrServiceImpl implements UserMgrService {
//    @Autowired
//    UserMapper userMapper;
    @Override
    public Result<String> add(User user) {
        Result<String> rst=new Result<>();
        if(user.getPasswd().length()>10){
            rst.setCode("fail");
            rst.setMsg("密码太长，不可超过10个字符!");
            return rst;
        }
        try{
//            userMapper.insert(user);
            rst.setCode("sucess");
            rst.setMsg("保存成功!");
        }catch(DuplicateKeyException duplicateKeyException  ){
            rst.setCode("fail");
            rst.setMsg("用户名已存在！");
        }catch(Exception e){
            rst.setCode("fail");
            rst.setMsg("保存用户失败!");
        }finally {

        }
        return rst;
    }
}
