package com.wayne.serialization;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author wayne
 */
@Slf4j
public class ExternalizableMain {

    public static void main(String[] args) {
        try {
            // serialize();
            deserialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void serialize() throws IOException {
        UserInfo user = new UserInfo();
        user.setUserAge(30);
        user.setUserPasswd("abc");
        user.setUserName("张三");
        try(ObjectOutputStream oos
                    = new ObjectOutputStream(
                new FileOutputStream(new File("user.txt")))){
            oos.writeObject(user);
        }
        log.info("序列化成功！");
    }

    public static void deserialize() throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois =
                    new ObjectInputStream(new FileInputStream("user.txt"))){
            UserInfo userInfo = (UserInfo) ois.readObject();
            log.info("反序列化的结果为【{}】",userInfo.toString());
        }
    }
}
