package com.linewell.license.ops.plugin.mysql.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.linewell.license.ops.common.espojo.EsOpsBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Description 类描述
 *    通常InnoDB存储引擎的缓冲池的命中率不应该小于99%。
 *     缓冲池命中率 = (Innodb_buffer_pool_read_requests)/(Innodb_buffer_pool_read_requests + Innodb_buffer_pool_read_ahead + Innodb_buffer_pool_reads)
 *     平均每次读取的字节数 = Innodb_data_read/Innodb_data_reads
 *
 *     Innodb_buffer_pool_reads：表示从物理磁盘读取的页数
 *     Innodb_buffer_pool_read_ahead：预读的页数
 *     Innodb_buffer_pool_read_ahead_evicted：预读的页数，但是没有被读取就从缓冲池中被替换的页的数量，一般用来判断预读的效率。
 *     Innodb_buffer_pool_read_requests：从缓冲池中读取的次数。
 *     Innodb_data_read：总共读入的字节数。
 *     Innodb_data_reads：发起读请求的次数，每次读取可能需要读取多个页
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-06-21
 * Time 10:43
 */
@Getter
@Setter
@ApiModel(value = "mysql所有指标信息", description = "mysql所有指标信息")
public class EsMysqlAllInfo extends EsOpsBaseInfo {

    @JSONField(name = "innodb_buffer_pool_read_requests")
    @ApiModelProperty(value = "从缓冲池中读取的次数", name = "innodbBufferPoolReadRequests", required = false )
    private Long innodbBufferPoolReadRequests;

    @JSONField(name = "innodb_buffer_pool_reads")
    @ApiModelProperty(value = "表示从物理磁盘读取的页数", name = "innodbBufferPoolReads", required = false )
    private Long innodbBufferPoolReads;

}
