package com.imooc.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * create by tyler on 2019/2/1 14:38,
 * reach me by tyler4400@foxmail.com
 */
@Component
@ConfigurationProperties(prefix = "girl")
public class GirlProperties {
    private String cipSize;

    public String getCipSize() {
        return cipSize;
    }

    public void setCipSize(String cipSize) {
        this.cipSize = cipSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;
}
