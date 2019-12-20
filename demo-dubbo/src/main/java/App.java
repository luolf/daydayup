import org.apache.commons.io.FilenameUtils;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-12-12
 * Time 18:19
 */
public class App {
    public static void main(String[] args) {
        Parent Dau=new Dau("Dau");
//        Parent p2=new Son("Son");


        Dau.callMe();
        Dau p=(Dau)Dau;
//        p2.callMe();
        p.callMe();
    String logFilePath="/app/ansible/playbooks/logs/20191213/8e26b705d7ec45558188eb1c4e03f8de-e808dc82f8094e9abbc0ca0dc2e2a93c-20191213173840.log";
//        logFilePath="/a";
        System.out.println( FilenameUtils.getFullPath(logFilePath)+"**"+FilenameUtils.getBaseName(logFilePath));
       String path= FilenameUtils.getFullPath(logFilePath);
       if(path.length()>0){
           path= path.substring(0,path.length()-1);
       }
                System.out.println(FilenameUtils.getBaseName(path)+"/"+FilenameUtils.getBaseName(logFilePath));

    }


}
