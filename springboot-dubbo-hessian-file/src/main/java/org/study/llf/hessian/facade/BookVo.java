package org.study.llf.hessian.facade;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-10-18
 * Time 11:16
 */
public class BookVo implements java.io.Serializable{
    private static final long serialVersionUID = -7782665556358408062L;
    private int id;
    private String name;

    public BookVo(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "BookVo [id=" + id + ", name=" + name + "]";
    }


}