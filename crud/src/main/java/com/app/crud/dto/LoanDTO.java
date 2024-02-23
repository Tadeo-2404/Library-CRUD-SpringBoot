package com.app.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
public class LoanDTO implements Serializable {
    final private String ID;
    final private LocalDateTime dateBorrow;
    final private LocalDateTime dateLimit;
    final private MemberDTO memberDTO;
}
