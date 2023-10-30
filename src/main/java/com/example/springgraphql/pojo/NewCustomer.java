package com.example.springgraphql.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCustomer {
    private String firstname;
    private String lastname;
    private Integer age;
}
