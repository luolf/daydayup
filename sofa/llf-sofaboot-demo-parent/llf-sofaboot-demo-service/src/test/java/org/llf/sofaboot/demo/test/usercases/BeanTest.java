package org.llf.sofaboot.demo.test.usercases;

import org.llf.sofaboot.demo.facade.SampleService;
import org.llf.sofaboot.demo.test.base.AbstractTestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BeanTest extends AbstractTestBase {

    @Autowired
    private SampleService sampleService;

    @Test
    public void testRpcSimple(){
        String result = sampleService.message();
        Assert.assertEquals("Hello, Service slitecore", result);
        Assert.assertTrue(result != null && result.length() > 0);
    }

    @Override
    protected void childSetUp() {

    }
}
