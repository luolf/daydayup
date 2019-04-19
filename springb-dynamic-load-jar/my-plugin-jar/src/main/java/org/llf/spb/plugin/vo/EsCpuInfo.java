package org.llf.spb.plugin.vo;

import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public class EsCpuInfo {
    public int cpu_system_critical;
    public int cpu_iowait_careful;
    public int cpu_user_warning;
    public Boolean cpu_disable;
    public double time_since_update;
    public int cpu_system_careful;
    public double total;
    public int cpucore;
    public int cpu_ctx_switches_critical;
    public int ctx_switches;
    public double cpu_iowait_warning;
    public int cpu_user_critical;
    public int history_size;
    public double user;
    public int interrupts;
    public int cpu_user_careful;
    public int cpu_steal_warning;
    public double system;
    public int cpu_iowait_critical;
    public int cpu_steal_careful;
    public int cpu_system_warning;
    public int cpu_ctx_switches_warning;
    public int cpu_ctx_switches_careful;
    public int cpu_steal_critical;
    public int syscalls;
    public int soft_interrupts;
    public double idle;
    

}
