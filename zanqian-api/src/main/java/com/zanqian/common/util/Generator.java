package com.zanqian.common.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.baomidou.mybatisplus.generator.fill.Property;

import java.sql.SQLException;
import java.util.Collections;

/**
 * @Author GanQuan
 * @Date 2023-04-27 12:12
 **/
public class Generator {

    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/zanqian?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8",
            "root",
            "");

    private static final String pkgName = ".app";

    /**
     * 执行 run
     */
    public static void main(String[] args) throws SQLException {
        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                .globalConfig(builder -> { builder
                    .author("GanQuan")        // 设置作者
                    .enableSwagger()        // 开启 swagger 模式 默认值:false
                    .disableOpenDir()       // 禁止打开输出目录 默认值:true
                    .commentDate("yyyy-MM-dd") // 注释日期
                    .dateType(DateType.ONLY_DATE)   //定义生成的实体类中日期类型 DateType.ONLY_DATE 默认值: DateType.TIME_PACK
                    .outputDir(System.getProperty("user.dir") + "/src/main/java"); // 指定输出目录
                })

                .packageConfig(builder -> {
                    builder.parent("com.zanqian") // 父包模块名
                            .controller("controller" + pkgName)   //Controller 包名 默认值:controller
                            .entity("entity" + pkgName)           //Entity 包名 默认值:entity
                            .service("service" + pkgName)         //Service 包名 默认值:service
                            .mapper("mapper" + pkgName)           //Mapper 包名 默认值:mapper
                            //.moduleName("xxx")        // 设置父包模块名 默认值:无
                            .pathInfo(Collections.singletonMap(OutputFile.xml, System.getProperty("user.dir") + "/src/main/resources/mapper")); // 设置mapperXml生成路径
                    //默认存放在mapper的xml下
                })

                .strategyConfig(builder -> {
                    builder.addInclude("z_user") // 设置需要生成的表名 可边长参数“user”, “user1”
                            .addTablePrefix("z_") // 设置过滤表前缀
                            .addFieldPrefix("z_")

                            .entityBuilder()// 实体类策略配置
                            .enableFileOverride()
                            .idType(IdType.ASSIGN_ID)//主键策略  雪花算法自动生成的id
                            .addTableFills(new Column("create_time", FieldFill.INSERT)) // 自动填充配置
                            .addTableFills(new Property("update_time", FieldFill.INSERT_UPDATE))
                            .disableSerialVersionUID()
                            .enableLombok() //开启lombok
                            .logicDeleteColumnName("deleted")// 说明逻辑删除是哪个字段
                            .enableTableFieldAnnotation()// 属性加上注解说明

                            .controllerBuilder() //controller 策略配置
                            .formatFileName("%sController")
                            .enableRestStyle() // 开启RestController注解

                            .serviceBuilder()//service策略配置
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")

                            .mapperBuilder()// mapper策略配置
                            .formatMapperFileName("%sMapper")
                            .formatXmlFileName("%sMapper");
                })
                .execute();
    }
}
