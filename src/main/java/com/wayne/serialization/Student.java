package com.wayne.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * 序列化和反序列化测试
 * @author wayne
 */
public class Student implements Serializable {

    /**
     * 使用transient和static修饰的字段不会被序列化
     */
    private transient String name;
    private Integer age;
    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setAge(Integer age) {
        this.age = age;
    }



    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    private void readObject( ObjectInputStream objectInputStream ) throws IOException, ClassNotFoundException {

        // 调用默认的反序列化函数
        objectInputStream.defaultReadObject();

        // 手工检查反序列化后学生成绩的有效性，若发现有问题，即终止操作！
        if( 0 > score || 100 < score ) {
            throw new IllegalArgumentException("学生分数只能在0到100之间！");
        }
    }

}
