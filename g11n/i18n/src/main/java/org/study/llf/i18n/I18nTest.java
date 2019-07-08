package org.study.llf.i18n;

import org.testng.annotations.Test;

import com.sun.management.OperatingSystemMXBean;

import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.management.ManagementFactory;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Description 类描述
 *
 * @author  https://www.cnblogs.com/lxnlxn/p/5845388.html
 * @version 1.0.0
 * Date 2019-06-14
 * Time 9:38
 */

public class I18nTest {


    @Test
    public void testGetKey(){
        String language;
        String country;

            language = new String("zh");
            country = new String("CN");


        Locale currentLocale;
        ResourceBundle messages;

        currentLocale = new Locale(language, country);

        messages = ResourceBundle.getBundle("luolf",currentLocale);

        System.out.println(messages.getString("salary"));
        System.out.println("-----");
    }
    /**
     * ResourceBundle: 资源包类.
     *
     * 1. 在类路径下需要有对应的资源文件: baseName.properties. 其中 baseName 是基名.
     * 2. 可以使用 基名_语言代码_国家代码.properties 来添加不同国家或地区的资源文件. i18n_zh_CN.properties
     * 3. 要求所有基名相同的资源文件的 key 必须完全一致.
     * 4. 可以使用 native2ascii 命令来得到 汉字 对一个的 asc 码. Eclipse 内置了工具
     * 5. 可以调用 ResourceBundle 的 getBundle(基名, Locale 实例) 获取获取 ResourceBundle 对象
     * 6. 可以调用 ResourceBundle 的 getString(key) 来获取资源文件的 value 字符串的值.
     * 7. 结合 DateFormat, NumberFormat, MessageFormat 即可实现国际化.
     *
     */
    @Test
    public void testResourceBundle(){
        Locale locale = Locale.CHINA;

        locale = Locale.US;
        ResourceBundle resourceBundle = ResourceBundle.getBundle("test", locale);

        System.out.println(resourceBundle.getString("date"));
        System.out.println(resourceBundle.getString("salary"));

        String dateLabel = resourceBundle.getString("date");
        String salLabel = resourceBundle.getString("salary");

        String str = "{0}:{1}, {2}:{3}";

        Date date = new Date();
        double sal = 12345.12;

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        String dateStr = dateFormat.format(date);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String salStr = numberFormat.format(sal);

        String result = MessageFormat.format(str, dateLabel, dateStr, salLabel, salStr);
        System.out.println(result);
    }

    /**
     * MessageFormat: 可以格式化模式字符串
     * 模式字符串: 带占位符的字符串: "Date: {0}, Salary: {1}"
     * 可以通过 format 方法会模式字符串进行格式化
     */
    @Test
    public void testMessageFormat(){
        String str = "Date: {0}, Salary: {1}";

        Locale locale = Locale.CHINA;
        Date date = new Date();
        double sal = 12345.12;

        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        String dateStr = dateFormat.format(date);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        String salStr = numberFormat.format(sal);

        String result = MessageFormat.format(str, dateStr, salStr);
        System.out.println(result);
    }

    /**
     * NumberFormat: 格式化数字到数字字符串, 或货币字符串的工具类
     * 1. 通过工厂方法获取 NumberFormat 对象
     * NumberFormat.getNumberInstance(locale); //仅格式化为数字的字符串
     * NumberFormat.getCurrencyInstance(locale); //格式为货币的字符串
     *
     * 2. 通过 format 方法来进行格式化
     * 3. 通过 parse 方法把一个字符串解析为一个 Number 类型.
     */
    @Test
    public void testNumberFormat() throws ParseException{
        double d = 123456789.123d;
        Locale locale = Locale.FRANCE;

        //
        NumberFormat numberFormat = NumberFormat.getNumberInstance(locale);

        String str = numberFormat.format(d);
        System.out.println(str);

        NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(locale);
        str = numberFormat2.format(d);
        System.out.println(str);

        str = "123 456 789,123";
        d = (Double) numberFormat.parse(str);
        System.out.println(d);

        str = "123 456 789,12 €";
        d = (Double) numberFormat2.parse(str);
        System.out.println(d);

    }

    /*
     * 7. 若有一个字符串, 如何解析为一个 Date 对象呢 ?
     * I. 先创建 DateFormat 对象: 创建 DateFormat 的子类 SimpleDateFormat 对象
     * SimpleDateFormat(String pattern).
     * 其中 pattern 为日期, 时间的格式, 例如: yyyy-MM-dd hh:mm:ss
     * II. 调用 DateFormat 的 parse 方法来解析字符串到 Date 对象.
     */
    @Test
    public void testDateFormat2() throws ParseException {
        String str = "1990-12-12 12:12:12";
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date date = dateFormat.parse(str);
        System.out.println(date);
    }

    /**
     * DateFormat: 格式化日期的工具类.
     * DateFormate 本身是一个抽象类.
     *
     * 1. 若只希望通过 DateFormat 把一个 Date 对象转为一个字符串, 则可以通过 DateFormat 的工厂方法来获取 DateFormat 对象
     * 2. 可以获取只格式化 Date 的 DateFormat 对象: getDateInstance(int style, Locale aLocale)
     * 3. 可以获取只格式化 Time 的 DateFormat 对象: getTimeInstance(int style, Locale aLocale)
     * 4. 可以获取既格式化 Date, 也格式化 Time 的 DateFormat 对象:
     * getDateTimeInstance(int dateStyle, int timeStyle, Locale aLocale)
     * 5. 其中 style 可以取值为: DateFormat 的常量: SHORT, MEDIUM, LONG, FULL. Locale 则为代表国家地区的 Locale 对象
     * 6. 通过 DateFormat 的 format 方法来格式化个 Date 对象到字符串.
     */
    @Test
    public void testDateFormat(){
        Locale locale = Locale.US;

        Date date = new Date();
        System.out.println(date);

        //获取 DateFormat 对象
        DateFormat dateFormat =
                DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM, locale);
        String str = dateFormat.format(date);
        System.out.println(str);

    }

    /**
     * Locale: Java 中表示国家或地区的类. JDK 中提供了很多常量.
     * 也可以通过 Locale(languageCode, countryCode) 的方式来创建
     * 在 WEB 应用中可以通过 request.getLocale() 方法来获取.
     */
    @Test
    public void testLocale(){
        Locale locale = Locale.CHINA;

        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getLanguage());

        locale = new Locale("en", "US");
        System.out.println(locale.getDisplayCountry());
        System.out.println(locale.getLanguage());
    }


    /**
     * 获取内存使用率
     * @return
     */
    @Test
    public static String getMemery() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long totalvirtualMemory = osmxb.getTotalSwapSpaceSize();// 总的物理内存+虚拟内存
        long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize();    // 剩余的物理内存
        Double compare = (Double) (1 - freePhysicalMemorySize * 1.0 / totalvirtualMemory) * 100;
        String str = "内存使用率:" + compare.intValue() + "%";
        return str;
    }

    /**
     * 获取CPU使用率
     * @return
     */
    @Test
    public static String getCpuRatio() {
        try {
            String procCmd = System.getenv("windir") + "//system32//wbem//wmic.exe process get Caption,CommandLine,KernelModeTime,ReadOperationCount,ThreadCount,UserModeTime,WriteOperationCount";
            long[] c0 = readCpu(Runtime.getRuntime().exec(procCmd));    // 取进程信息
            Thread.sleep(200);
            long[] c1 = readCpu(Runtime.getRuntime().exec(procCmd));
            if (c0 != null && c1 != null) {
                long idletime = c1[0] - c0[0];
                long busytime = c1[1] - c0[1];
                return "CPU使用率:"+ Double.valueOf(100 * (busytime) * 1.0 / (busytime + idletime)).intValue() + "%";
            } else {
                return "CPU使用率:" + 0 + "%";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "CPU使用率:" + 0 + "%";
        }
    }

    public static void  main(String[] args){

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("CPU:%s,内存:%s",getCpuRatio(),getMemery()));


        }
    }
    /**
     * 获取系统cpu负载
     * @return
     */
    public static double getSystemCpuLoad() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        double SystemCpuLoad = osmxb.getSystemCpuLoad();
        return SystemCpuLoad;
    }
    /**
     * 获取jvm线程负载
     * @return
     */
    public static double getProcessCpuLoad(){
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        double ProcessCpuLoad = osmxb.getProcessCpuLoad();
        return ProcessCpuLoad;
    }

    /**
     * 获取剩余的物理内存
     * @return
     */
    public static long getFreePhysicalMemorySize() {
        int kb = 1024;
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        // 剩余的物理内存
        long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize() / kb/kb;
        return freePhysicalMemorySize;
    }
    private static long[] readCpu(final Process proc) {
        long[] retn = new long[2];
        try {
            proc.getOutputStream().close();
            InputStreamReader ir = new InputStreamReader(proc.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            String line = input.readLine();
            if (line == null || line.length() < 10) {
                return null;
            }
            int capidx = line.indexOf("Caption");
            int cmdidx = line.indexOf("CommandLine");
            int rocidx = line.indexOf("ReadOperationCount");
            int umtidx = line.indexOf("UserModeTime");
            int kmtidx = line.indexOf("KernelModeTime");
            int wocidx = line.indexOf("WriteOperationCount");
            long idletime = 0;
            long kneltime = 0;
            long usertime = 0;
            while ((line = input.readLine()) != null) {
                if (line.length() < wocidx) {
                    continue;
                }
                String caption = substring(line, capidx, cmdidx - 1).trim();
                String cmd = substring(line, cmdidx, kmtidx - 1).trim();
                if (cmd.indexOf("wmic.exe") >= 0) {
                    continue;
                }
                String s1 = substring(line, kmtidx, rocidx - 1).trim();
                String s2 = substring(line, umtidx, wocidx - 1).trim();
                if (caption.equals("System Idle Process") || caption.equals("System")) {
                    if (s1.length() > 0)
                        idletime += Long.valueOf(s1).longValue();
                    if (s2.length() > 0)
                        idletime += Long.valueOf(s2).longValue();
                    continue;
                }
                if (s1.length() > 0)
                    kneltime += Long.valueOf(s1).longValue();
                if (s2.length() > 0)
                    usertime += Long.valueOf(s2).longValue();
            }
            retn[0] = idletime;
            retn[1] = kneltime + usertime;
            return retn;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                proc.getInputStream().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    private static String substring(String src, int start_idx, int end_idx) {
        byte[] b = src.getBytes();
        String tgt = "";
        for (int i = start_idx; i <= end_idx; i++) {
            tgt += (char) b[i];
        }
        return tgt;
    }
}
