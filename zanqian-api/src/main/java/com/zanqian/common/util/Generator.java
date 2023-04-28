package com.zanqian.common.util;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import com.zanqian.controller.BaseController;
import com.zanqian.entity.BaseEntity;
import com.zanqian.service.BaseService;
import com.zanqian.service.impl.BaseServiceImpl;

/**
 * @Author GanQuan
 * @Date 2023-04-27 12:12
 **/
public class Generator {

    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/zanqian?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8", "root", "")
            .schema("zanqian")
            .build();

    private static final GlobalConfig GLOBAL_CONFIG = new GlobalConfig.Builder()
            .outputDir("src\\main\\java")
            .author("Ganquan")
            .dateType(DateType.TIME_PACK)
            .commentDate("yyyy-MM-dd")
            .build();

    private static final StrategyConfig ENTITY_STRATEGY_CONFIG = new StrategyConfig.Builder()
            .addTablePrefix("zq_")
            .entityBuilder()
            .superClass(BaseEntity.class)
            .disableSerialVersionUID()
            .enableChainModel()
            .enableLombok()
            .enableRemoveIsPrefix()
            .enableTableFieldAnnotation()
            .logicDeleteColumnName("deleted")
            .logicDeletePropertyName("deleteFlag")
            .naming(NamingStrategy.underline_to_camel)
            .columnNaming(NamingStrategy.underline_to_camel)
            .addSuperEntityColumns("created_time", "updated_time", "deleted")
            .addTableFills(new Column("create_time", FieldFill.INSERT))
            .addTableFills(new Column("updated_time", FieldFill.INSERT_UPDATE))
            .idType(IdType.ASSIGN_UUID)
            .formatFileName("%s")
            .build();

    private static final StrategyConfig CONTROLLER_STRATEGY_CONFIG = new StrategyConfig.Builder()
            .addTablePrefix("zq_")
            .controllerBuilder()
            .superClass(BaseController.class)
            .enableHyphenStyle()
            .enableRestStyle()
            .formatFileName("%sController")
            .build();

    private static final StrategyConfig SERVICE_STRATEGY_CONFIG = new StrategyConfig.Builder()
            .addTablePrefix("zq_")
            .serviceBuilder()
            .superServiceClass(BaseService.class)
            .superServiceImplClass(BaseServiceImpl.class)
            .formatServiceFileName("%sService")
            .formatServiceImplFileName("%sServiceImpl")
            .build();

    private static final StrategyConfig MAPPER_STRATEGY_CONFIG = new StrategyConfig.Builder()
            .addTablePrefix("zq_")
            .mapperBuilder()
            .superClass(BaseMapper.class)
            .enableMapperAnnotation()
            .enableBaseResultMap()
            .enableBaseColumnList()
            .formatMapperFileName("%sMapper")
            .formatXmlFileName("%sMapper")
            .build();

    public static void main(String[] args) {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(ENTITY_STRATEGY_CONFIG)
                .strategy(CONTROLLER_STRATEGY_CONFIG)
                .strategy(SERVICE_STRATEGY_CONFIG)
                .strategy(MAPPER_STRATEGY_CONFIG);
        generator.global(GLOBAL_CONFIG);
        generator.packageInfo(new PackageConfig.Builder().parent("com.zanqian").build());
        generator.execute();
    }
}
