package org.llf.processor.common.msg;

import com.linewell.license.generator.processor.common.util.ProtostuffUtil;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-04-26
 * Time 15:12
 */
public class TaskMsgSerializer implements Serializer<TaskMessage> {
    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public byte[] serialize(String topic, TaskMessage taskMessage) {
        return   ProtostuffUtil.serializer(taskMessage, TaskMessage.class);
    }

    @Override
    public void close() {

    }
}
