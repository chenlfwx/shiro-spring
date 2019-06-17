package com.chen.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Chen Dian
 * @date 2019/06/13
 */
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String name;
    private String password;
}
