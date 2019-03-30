import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * author: luolifeng
 * Date: 2019-03-18
 * Time: 14:58
 */

public class AuthenticationTest {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationTest.class);
    @Test
    public void testHelloworld() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
//得到一个身份集合，其包含了Realm验证成功的身份信息
//        PrincipalCollection principalCollection = subject.getPrincipals();
        try {
            //4、登录，即身份验证
            subject.login(token);
            log.info("身份验通过");
        }  catch ( UnknownAccountException uae ) {
            log.warn("用户帐号不正确");

        } catch ( IncorrectCredentialsException ice ) {
            log.warn("用户密码不正确");

        } catch ( LockedAccountException lae ) {
            log.warn("用户帐号被锁定");

        } catch ( AuthenticationException ae ) {
            log.warn("登录出错");
        }

//        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6、退出
        subject.logout();
    }
}
