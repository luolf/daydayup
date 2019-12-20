package org.llf.test;
import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-12-20
 * Time 18:13
 */


public class AttacherMain {
    public static void main(String[] args) throws IOException, AgentLoadException, AgentInitializationException, AttachNotSupportedException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("6500");
        vm.loadAgent("F:\\code\\linewell\\daydayup\\byte-code\\javassist\\javassist-1.0-SNAPSHOT.jar");
    }
}
