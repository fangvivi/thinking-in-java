package com.wayne.serialization;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author wayne
 */
@Slf4j
public class SerializableMain {
    public static void main(String[] args) {
        try {
            serialize();
            deserialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void serialize() throws IOException {
        Student student = new Student();
        student.setName("小明");
        student.setAge(101);
        student.setScore(1000);
        try(ObjectOutputStream oos
                    = new ObjectOutputStream(
                new FileOutputStream(new File("student.txt")))){
            oos.writeObject(student);
        }
        log.info("序列化成功！");
    }

    public static void deserialize() throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("student.txt"))){
            Student student = (Student)ois.readObject();
            // 反序列化会调用构造方法
            log.info("反序列化的结果为【{}】",student.toString());
        }
    }

}
