package com.ruoyi.generator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 读取代码生成相关配置
 * 
 * @author ruoyi
 */
@Component
@ConfigurationProperties(prefix = "gen")
@PropertySource(value = { "classpath:generator.yml" })
public class GenConfig
{
    /** 作者 */
    public static String author;

    /** 生成包路径 */
    public static String packageName;

    /** 自动去除表前缀，默认是false */
    public static boolean autoRemovePre;

    /** 表前缀(类名不会包含表前缀) */
    public static String tablePrefix;

    /** 项目空间路径 */
    private static  String PROJECT_PATH = "D:/IdeaProjects/faceAttendace/ruoyi-admin/src/main/java";
    /** mybatis空间路径 */
    private static  String MYBATIS_PATH = "D:/IdeaProjects/faceAttendace/ruoyi-admin/src/main/resources/mapper";
    /** html空间路径 */
    private static  String TEMPLATES_PATH = "D:/IdeaProjects/faceAttendace/ruoyi-admin/src/main/resources/templates";


    public static String getProjectPath() {
        return PROJECT_PATH;
    }

    public static String getMybatisPath() {
        return MYBATIS_PATH;
    }

    public static String getTemplatesPath() {
        return TEMPLATES_PATH;
    }

    public static String getAuthor()
    {
        return author;
    }

    @Value("${author}")
    public void setAuthor(String author)
    {
        GenConfig.author = author;
    }

    public static String getPackageName()
    {
        return packageName;
    }

    @Value("${packageName}")
    public void setPackageName(String packageName)
    {
        GenConfig.packageName = packageName;
    }

    public static boolean getAutoRemovePre()
    {
        return autoRemovePre;
    }

    @Value("${autoRemovePre}")
    public void setAutoRemovePre(boolean autoRemovePre)
    {
        GenConfig.autoRemovePre = autoRemovePre;
    }

    public static String getTablePrefix()
    {
        return tablePrefix;
    }

    @Value("${tablePrefix}")
    public void setTablePrefix(String tablePrefix)
    {
        GenConfig.tablePrefix = tablePrefix;
    }
}
