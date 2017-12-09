package com.lanou.mapper;

import com.lanou.bean.Account;

public interface AccountMapper {
    int insert(Account record);

    int insertSelective(Account record);
}