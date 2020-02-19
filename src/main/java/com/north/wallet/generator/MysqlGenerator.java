package com.north.wallet.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class MysqlGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");

        System.out.println(projectPath);
        //TODO 变更项目模块时修改
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("north");
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setEntityName("%sEntity");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/db?useUnicode=true&useSSL=false&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("username");
        dsc.setPassword("password");
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
//        pc.setModuleName(scanner("包名"));
        packageConfig.setParent("com.north")
                .setModuleName("wallet")
                .setEntity("entity")
                .setMapper("mapper");

        mpg.setPackageInfo(packageConfig);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return gc.getOutputDir() + "/../resources/mapper/" + packageConfig.getModuleName()
                        + "/" + tableInfo.getEntityName().substring(0, tableInfo.getEntityName().indexOf("Entity")) + "Mapper" + ".xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
//        mpg.setTemplate(new TemplateConfig().setXml(null));

        // 模版配置
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setController(null)
                      .setXml(null);
//                    .setService(null);
//                    .setServiceImpl(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(false);
        strategy.setVersionFieldName("version");
//        strategy.setControllerMappingHyphenStyle(true);//生成controller控制器
//        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
//        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
//        strategy.setInclude(scanner("tc_batch_transfer_flow"));
        //TODO 变更生成db对象时修改
        strategy.setInclude(new String[]{"ts_invite_reward_flow"});
        strategy.setTablePrefix(new String[] {"t_", "tb_", "ta_", "ts_"});
//        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);
//        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
