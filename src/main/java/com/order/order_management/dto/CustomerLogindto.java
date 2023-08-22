package com.order.order_management.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@ToString
public class CustomerLogindto {

    @NotNull
    private String email;
    @NotNull
    private String password;

}
