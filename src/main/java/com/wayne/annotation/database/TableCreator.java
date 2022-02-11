package com.wayne.annotation.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过解析类中的注解，实现根据类自动构建对应的建数据库表的SQL
 * @author wayne
 */
public class TableCreator {

    private static final Logger log = LoggerFactory.getLogger(TableCreator.class);


    public static void main(String[] args) throws ClassNotFoundException {
        String[] className = {"com.wayne.annotation.database.Member"};
        createSQL(className);
    }

    /**
     * 为指定的类名构造建数据库表的SQL
     * @param className 类的全限定名
     * @throws ClassNotFoundException
     */
    public static void createSQL(String[] className)
            throws ClassNotFoundException {

        if(className.length < 1) {
            log.info("arguments: annotated classes");
            System.exit(0);
        }

        for (String classname : className) {
            Class<?> cl = Class.forName(classname);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if (dbTable == null) {
                log.info("类【{}】上没有 DBTable 注解",classname);
                continue;
            }
            String tableName = dbTable.name();
            // 如果注解的元素值是空的，使用类的名字来作为表名
            if(tableName.length() < 1){
                tableName = cl.getName().toUpperCase();
            }
            List<String> columnList = new ArrayList<>();

            // 获取类的所有字段
            Field[] fields = cl.getDeclaredFields();

            for (Field field : fields) {
                // 获取字段上的注解
                Annotation[] ann = field.getAnnotations();
                // 如果没有注解，说明不是数据库字段
                if(ann.length < 1){
                    continue;
                }
                // 如果注解是 SQLInteger
                if(ann[0] instanceof SQLInteger){
                    String columnName = "";
                    SQLInteger sInt = (SQLInteger) ann[0];
                    // 如果注解没有指定表的字段名，就使用类的字段名
                    if(sInt.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sInt.name();
                    }
                    Constraints constraints = sInt.constraints();
                    String constraintsInt = getConstraints(constraints);
                    columnList.add(columnName +" INT" + constraintsInt);
                }
                // 如果注解是 SQLString
                if(ann[0] instanceof SQLString){
                    String columnName = "";
                    SQLString sStr = (SQLString) ann[0];
                    // 如果注解没有指定表的字段名，就使用类的字段名
                    if(sStr.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    } else {
                        columnName = sStr.name();
                    }
                    Constraints constraints = sStr.constraints();
                    String constraintsStr = getConstraints(constraints);
                    columnList.add(columnName +" VARCHAR(" + sStr.value() + ")" + constraintsStr);
                }
            }
            StringBuilder createTableCommand = new StringBuilder("CREATE TABLE "+tableName+" ( ");
            for (String s : columnList) {
                createTableCommand.append("\n "+s+",");
            }
            String sql = createTableCommand.substring(0, createTableCommand.length() - 1) + ");";
            log.info("为类【{}】创建数据库表的SQL语句为：\n【{}】",classname, sql);
        }
    }


    /**
     * 拼接字段的SQL约束关键字
     * @param con 注解的Constraints元素数组
     * @return 这个数据库字段对应的SQL约束关键字
     */
    private static String getConstraints(Constraints con){
        String constraints = "";
        if(!con.allowNull()){
            constraints += " NOT NULL";
        } else if(con.unique()){
            constraints += " UNIQUE";
        } else if(con.primaryKey()){
            constraints += " PRIMARY KEY";
        }
        return constraints;
    }
}
