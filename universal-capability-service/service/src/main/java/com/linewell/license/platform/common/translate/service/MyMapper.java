package com.linewell.license.platform.common.translate.service;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 类的用途
 *
 * @author zgui
 * @version 1.0.0
 * @date 2019/3/22 13:54
 **/


public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错
}
