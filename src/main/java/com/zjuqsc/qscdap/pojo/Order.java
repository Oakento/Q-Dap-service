package com.zjuqsc.qscdap.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private String expressStation;
    private String expressCompany;
    private String trackingNumber;
    private String shelfNumber;
    private Date createdTime;
    private String remarks;
    private Long userId;
    private User user;
}
