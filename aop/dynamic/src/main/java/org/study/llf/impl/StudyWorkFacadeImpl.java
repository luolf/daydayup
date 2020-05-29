package org.study.llf.impl;

import org.study.llf.facade.StudyFacade;
import org.study.llf.facade.WorkFacade;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-05-29
 * Time 10:22
 */
public class StudyWorkFacadeImpl implements StudyFacade, WorkFacade {
    @Override
    public String getPlayBook() {
        return "变学习边工作";
    }

    @Override
    public void haha() {
        System.out.println("StudyWorkFacade");
    }

    @Override
    public Integer getWorkHours() {
        return 12;
    }

}
