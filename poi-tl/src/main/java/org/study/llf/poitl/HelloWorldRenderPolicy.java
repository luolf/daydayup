package org.study.llf.poitl;

import com.deepoove.poi.policy.AbstractRenderPolicy;
import com.deepoove.poi.render.RenderContext;
import com.deepoove.poi.render.WhereDelegate;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-04-26
 * Time 21:13
 */
public class HelloWorldRenderPolicy extends AbstractRenderPolicy<String> {

    @Override
    public void doRender(RenderContext<String> context) throws Exception {
        // anywhere delegate
        WhereDelegate where = context.getWhereDelegate();
        // any thing
        //String thing = context.getThing();

        String thing = "Hello, world";
        // do
        where.renderText(thing);
    }

}
