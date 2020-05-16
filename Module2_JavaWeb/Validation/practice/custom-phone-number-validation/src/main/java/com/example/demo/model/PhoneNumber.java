package com.example.demo.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PhoneNumber implements Validator {
    private String number;

    public PhoneNumber() {}

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        // Class PhoneNumber được gán từ đối tượng aClass của lớp
        return PhoneNumber.class.isAssignableFrom(aClass);
    }

    @Override
    // xác minh đối tượng được truyền vào, trong trường hợp xác minh thấy lỗi, chúng sẽ được đưa vào trong đối tượng Errors.
    public void validate(Object o, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) o;
        String number = phoneNumber.getNumber();
        //từ chối thuộc tính ‘name’ nếu nó là null hoặc chuỗi trống
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length() > 11 || number.length() < 10) {
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")) {
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("number", "number.matches");
        }
    }
}