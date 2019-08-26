package com.allen.dubbo.xml.domain;

import com.allen.dubbo.xml.validator.ValidateGroups;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class ValidationParameter implements Serializable {

    @NotNull(groups = ValidateGroups.Add.class, message = "name不能为空") //增加的时候，不允许为空
    @Size(min = 1, max = 20, groups = {ValidateGroups.Add.class, ValidateGroups.Edit.class}, message = "不能少于1个字符，不能大于20个字符") //长度范围
    private String name;

    //@Min(value = 18, message = "")
    //@Max(value = 150, message = "")
    @Range(min = 18, max = 50, message = "age不能小于18，不能大于50")
    private int age;

    @Past(message = "loginDate必须是过去时间")
    private Date loginDate;

    @Future(message = "expireDate必须是未来时间")
    private Date expireDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }
}
