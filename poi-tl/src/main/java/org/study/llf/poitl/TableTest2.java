package org.study.llf.poitl;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.config.Configure;
import com.deepoove.poi.data.RowRenderData;
import com.deepoove.poi.data.TextRenderData;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-04-26
 * Time 17:21
 */
public class TableTest2 {
    public static void main(String[] args) throws IOException {



        RowRenderData header = RowRenderData.build(new TextRenderData("FFFFFF", "姓名"), new TextRenderData("FFFFFF", "学历"));
        RowRenderData row0 = RowRenderData.build("张三", "研究生");
        RowRenderData row1 = RowRenderData.build("李四", "博士");
        RowRenderData row2 = RowRenderData.build("王五", "小学生");
        List<Goods> goods = new ArrayList<>();
        for(int i=1;i<0;i++){
            Goods g=new Goods();
            g.setDesc("王五"+i);
            goods.add(g);
        }

        String path="F:\\code\\linewell\\daydayup\\poi-tl\\src\\main\\resources\\";


        MyHackLoopTableRenderPolicy policy = new MyHackLoopTableRenderPolicy();
//
//        Configure config = Configure.newBuilder()
//                .bind("goods", policy).bind("labors", policy).build();
        Configure config = Configure.newBuilder()
                .bind("star_table_tag", policy).build();

        XWPFTemplate template = XWPFTemplate.compile(path+"test.docx", config).render(
                new HashMap<String, Object>() {{
                    put("star_table_tag", goods);
                    put("go", "{{go}}");
                }}
        );

        FileOutputStream out = new FileOutputStream(path+"rst1.docx");
        template.write(out);
        out.flush();
        out.close();
        template.close();

        List<Goods> goods2 = new ArrayList<>();
        for(int i=0;i<1;i++){
            Goods g=new Goods();
            g.setDesc("王五"+i);
            goods2.add(g);
        }


        try {
            XWPFTemplate template2 = XWPFTemplate.compile(path + "rst1.docx").render(new HashMap<String, Object>() {{
                put("go", "王五0");
            }});
            FileOutputStream out2 = new FileOutputStream(path+"out_test.docx");
            template2.write(out2);
            out2.flush();
            out2.close();
            template2.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
