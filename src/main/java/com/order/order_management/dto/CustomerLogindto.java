package com.order.order_management.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Getter
@Setter
@ToString
public class CustomerLogindto {

    private String email;

    private String password;

}
