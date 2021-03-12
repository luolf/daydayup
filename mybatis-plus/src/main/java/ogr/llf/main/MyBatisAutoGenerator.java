package ogr.llf.main;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: luolifeng
 * Date: 2020-12-29 15:53
 */
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class MyBatisAutoGenerator {
    public static void main(String[] args) {
        //代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setAuthor("LinXianSheng");
        //时间类型
        globalConfig.setDateType(DateType.ONLY_DATE);
        //ID增长
        globalConfig.setIdType(IdType.AUTO);
        //打开文件目录
        globalConfig.setOpen(false);
        //Swagger2
        globalConfig.setSwagger2(true);
        //是否覆盖原有文件
        globalConfig.setFileOverride(false);
        //文件输出目录
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/src/main/java");
        autoGenerator.setGlobalConfig(globalConfig);

        //数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        //数据库类型
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setUrl("jdbc:mysql://172.26.11.167:30000/ins?characterEncoding=UTF-8&useSSL=false");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("mysql");
        //驱动名称
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        autoGenerator.setDataSource(dataSourceConfig);

        //包配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setController("controller");
        packageConfig.setEntity("entity");
        packageConfig.setService("service");
        packageConfig.setMapper("mapper");
        packageConfig.setParent("com.llf");
        packageConfig.setModuleName("blogger");
        autoGenerator.setPackageInfo(packageConfig);

        //策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setLogicDeleteFieldName("deleted");
        strategyConfig.setVersionFieldName("version");
        strategyConfig.setInclude("user");
        //生成@RestController
        strategyConfig.setRestControllerStyle(true);
        //生成lombok
        strategyConfig.setEntityLombokModel(true);
        //驼峰转连字符，localhost:8080/hello_id_10，即访问带下划线参数
        strategyConfig.setControllerMappingHyphenStyle(true);
        //自动填充设置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategyConfig.setTableFillList(tableFills);
        autoGenerator.setStrategy(strategyConfig);
        //执行
        autoGenerator.execute();
    }
}
