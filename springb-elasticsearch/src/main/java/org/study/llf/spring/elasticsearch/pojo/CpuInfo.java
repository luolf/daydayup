package org.study.llf.spring.elasticsearch.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "glances-2019.03.30", type = "glances")
@Setter
@Getter
public class CpuInfo {
    public  String id;
    public String timestamp= "2019-03-30T07:51:41.325830";
    public int cpu_system_critical= 90;
    public int cpu_iowait_careful= 20;
    public int cpu_user_warning= 70;
    public String cpu_disable= "False";
    public double time_since_update= 4.980492115020752;
    public int cpu_system_careful= 50;
    public double total= 9.3;
    public int cpucore= 4;
    public int cpu_ctx_switches_critical= 200000;
    public int ctx_switches= 96307;
    public double cpu_iowait_warning= 22.5;
    public String plugin= "cpu";
    public int cpu_user_critical= 90;
    public int history_size= 28800;
    public double user= 6.3;
    public int interrupts= 59026;
    public int cpu_user_careful= 50;
    public int cpu_steal_warning= 70;
    public double system= 11.4;
    public int cpu_iowait_critical= 25;
    public int cpu_steal_careful= 50;
    public String clientIdentifying= "localhost";
    public int cpu_system_warning= 70;
    public int cpu_ctx_switches_warning= 180000;
    public int cpu_ctx_switches_careful= 160000;
    public int cpu_steal_critical= 90;
    public int syscalls= 188259;
    public int soft_interrupts= 0;
    public double idle= 81.3;
    

}
