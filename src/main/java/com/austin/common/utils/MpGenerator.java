package com.austin.common.utils;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;


/**
 * @Description: 代码自动生成工具
 * @Author: GongJun
 * @Date: Created in 12:34 2021/1/29
 */
public class MpGenerator {

    private static final String package_name = "com.austin.common";  //包名
    private static final String driver_class_name = "com.mysql.cj.jdbc.Driver";   //数据库驱动
    private static final String url = "jdbc:mysql://127.0.0.1:3306/common?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8&&useSSL=true";
    private static final String username = "root"; //用户名
    private static final String password = "123";  //密码

    public static void main(String args[]) {

        String[] table_prefix = new String[]{"ce_", "upms_"};  //表前缀

        String[] table_names = new String[]{"upms_user"};  //表名

        new MpGenerator().generateCode(
                package_name,
                table_prefix,
                table_names
        );
    }

    public void generateCode(String packageName, String[] prefix, String... tableName) {
//        boolean serviceNameStartWithI = true;//user -> IUserService, 设置成true: user -> IUserService
        generateByTables(packageName, prefix, tableName);
    }

    private void generateByTables(String packageName, String[] prefix, String... tableNames) {

        GlobalConfig config = new GlobalConfig();
        String dbUrl = url;
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig
                .setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername(username)
                .setPassword(password)
                .setDriverName(driver_class_name);
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setTablePrefix(prefix)
                .setNaming(NamingStrategy.underline_to_camel)  //转驼峰
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config
                .setActiveRecord(false)
                .setEnableCache(false)
                .setAuthor("AustinGJ")
                .setOutputDir("d:/tmp")
                .setFileOverride(true);
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setEntity("entity")
                                .setMapper("mapper")
                                .setXml("resource.mapper")
                                .setController("controller")
                                .setService("service")
                                .setServiceImpl("service.impl")
                ).execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(packageName, tableNames);
    }

}
