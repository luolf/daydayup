package org.llf.test;
import com.sun.tools.attach.*;

import java.io.IOException;
import java.util.List;

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
        String jar="F:\\code\\linewell\\daydayup\\byte-code\\javassist\\target\\javassist-1.0-SNAPSHOT.jar";
        // 传入目标 JVM pid
//        VirtualMachine virtualMachine = VirtualMachine.attach("660");
//        virtualMachine.loadAgent(jar);
//        virtualMachine.detach();
        List<VirtualMachineDescriptor> list = VirtualMachine.list();
        for (VirtualMachineDescriptor vmd : list) {
            if (vmd.displayName().endsWith("MyBizApp")) {
                VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                virtualMachine.loadAgent(jar, "cxs");
                virtualMachine.detach();
                System.out.println("ok");
            }
        }

    }
}
