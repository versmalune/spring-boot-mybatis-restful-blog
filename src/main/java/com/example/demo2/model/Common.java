package com.example.demo2.model;

import com.example.demo2.common.Criteria;
import com.example.demo2.common.PaginationInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Common extends Criteria {
    private PaginationInfo paginationInfo;
}
