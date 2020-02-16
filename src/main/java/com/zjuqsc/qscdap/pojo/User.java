package com.zjuqsc.qscdap.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String nickname;
    private String realName;
    private Integer studentId;
    private Integer cardId;
    private String cardPhoto;
}
