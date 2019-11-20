package org.study.llf;
import org.apache.commons.exec.LogOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * 如果不是要把脚本的日志输出到文件或者流中，而是实时处理每一行输出，需要实现LogOutputStream，类似下面的实现类CollectingLogOutputStrea
 */
public class CollectingLogOutputStream extends LogOutputStream {

    private static Logger logger = LoggerFactory.getLogger(CollectingLogOutputStream.class);
    private final List<String> lines = new LinkedList<String>();
    @Override protected void processLine(String line, int level) {

        lines.add(line);
        logger.info("日志级别{}：{}",level,line);
    }
    public List<String> getLines() {
        return lines;
    }
}
