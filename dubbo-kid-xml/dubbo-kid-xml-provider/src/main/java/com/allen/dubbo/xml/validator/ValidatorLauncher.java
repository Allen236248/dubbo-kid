package com.allen.dubbo.xml.validator;

import com.allen.dubbo.xml.domain.ValidationParameter;

public class ValidatorLauncher {

    public static void main(String...args) {
        ValidationParameter validationParameter = new ValidationParameter();
        //validationParameter.setAge(20);
        //validationParameter.setName("validation");
        //BeanValidator.validate(validationParameter); //对指定了Group的属性不做校验
        BeanValidator.validate(validationParameter, ValidateGroups.Add.class); //校验指定了Add Group的属性
    }
}
