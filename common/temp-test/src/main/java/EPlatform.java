/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2020-01-12
 * Time 15:31
 */
/**
 * 获取操作系统名字
 * @return 操作系统名
 */
public enum EPlatform {
    Any("any"),
    Linux("Linux"),
    Mac_OS("Mac OS"),
    Mac_OS_X("Mac OS X"),
    Windows("Windows"),
    OS2("OS/2"),
    Solaris("Solaris"),
    SunOS("SunOS"),
    MPEiX("MPE/iX"),
    HP_UX("HP-UX"),
    AIX("AIX"),
    OS390("OS/390"),
    FreeBSD("FreeBSD"),
    Irix("Irix"),
    Digital_Unix("Digital Unix"),
    NetWare_411("NetWare"),
    OSF1("OSF1"),
    OpenVMS("OpenVMS"),
    Others("Others");

    private EPlatform(String desc) {
        this.description = desc;
    }

    public String toString() {
        return description;
    }

    private String description;
}