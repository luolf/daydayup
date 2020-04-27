package org.llf.processor.common.util;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 序列化工具
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-04-26
 * Time 15:53
 */
public class ProtostuffUtil {


    /**
     * 序列化
     *
     * @param message 序列化数据
     * @param tClass  .class
     * @param <T>     类型
     * @return byte[]
     */
    public static <T> byte[] serializer(T message, Class<T> tClass) {
        LinkedBuffer linkedBuffer=LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            Schema<T> schema = RuntimeSchema.getSchema(tClass);
            return ProtostuffIOUtil.toByteArray(message, schema,linkedBuffer);
        }   finally {
            linkedBuffer.clear();
        }
    }

    /**
     * 反序列化
     *
     * @param bytes  bytes
     * @param tClass .class
     * @param <T>    类型
     * @return T
     */
    public static <T> T deserializer(byte[] bytes, Class<T> tClass) {
        Schema<T> schema = RuntimeSchema.getSchema(tClass);
        T message = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(bytes, message, schema);
        return message;
    }

}