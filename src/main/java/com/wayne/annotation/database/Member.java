package com.wayne.annotation.database;


/**
 * @author wayne
 */
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)
    String firstName;

    @SQLString(50)
    String lastName;

    @SQLInteger
    Integer age;

    /** 如果要同时给多个元素赋值，这里就不可以像上面一样使用快捷方式了 */
    @SQLString(value = 30,
            constraints = @Constraints(primaryKey = true))
    String reference;

    static int memberCount;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getReference() {
        return reference;
    }

    public static int getMemberCount() {
        return memberCount;
    }

    @Override
    public String toString() {
        return this.reference;
    }
}
