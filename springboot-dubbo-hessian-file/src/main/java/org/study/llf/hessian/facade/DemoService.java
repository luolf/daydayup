package org.study.llf.hessian.facade;

import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-18
 * Time 11:14
 */
public interface DemoService {

    List<BookVo> findAllBook(BookVo vo);

    String testMe(String value);
}
