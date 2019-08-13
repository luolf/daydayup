package org.llf.service;

import org.llf.common.Result;
import org.llf.pojo.User;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-07-15
 * Time 9:41
 */
public interface UserMgrService {
    public Result<String> add(User user);
}
