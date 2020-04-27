package org.llf.processor.common.msg;

import com.linewell.license.generator.processor.common.util.ProtostuffUtil;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

/**
 * 任务消息的反序列号
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-04-26
 * Time 15:13
 */
public class TaskMsgDeserializer  implements Deserializer<TaskMessage> {
    @Override
    public void configure(Map map, boolean b) {

    }

    @Override
    public TaskMessage deserialize(String topic, byte[] bytes) {
        return ProtostuffUtil.deserializer(bytes, TaskMessage.class);
    }

    @Override
    public void close() {

    }
}
