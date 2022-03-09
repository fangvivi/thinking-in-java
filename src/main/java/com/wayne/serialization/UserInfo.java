package com.wayne.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author wayne
 */
public class UserInfo implements Externalizable {

    private String userName;
    private String userPasswd;
    private int userAge;


    public void setUserName(String userName) {
        this.userName = userName;
    }


    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }


    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public UserInfo() {
        this.userAge = 20;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        //  指定序列化时候写入的属性。这里仍然不写入年龄
        out.writeObject(userName);
        out.writeObject(userPasswd);
    }

    /**
     * 要先调用构造方法，才会调用这个方法
     */
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // 指定反序列化的时候读取属性的顺序以及读取的属性
        // 如果你写反了属性读取的顺序，最后对象的属性值就是错的
        userName = (String)in.readObject();
        userPasswd = (String)in.readObject();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userName='" + userName + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                ", userAge=" + userAge +
                '}';
    }
}
