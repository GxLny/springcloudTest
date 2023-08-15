package com.lny.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;

}
