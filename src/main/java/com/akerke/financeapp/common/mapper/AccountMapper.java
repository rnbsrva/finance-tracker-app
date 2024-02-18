package com.akerke.financeapp.common.mapper;

import com.akerke.financeapp.model.dto.AccountDTO;
import com.akerke.financeapp.model.dto.UserDTO;
import com.akerke.financeapp.model.entity.*;
import org.mapstruct.*;

import java.util.ArrayList;

@Mapper(
        imports = {ArrayList.class, User.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface AccountMapper {

    Account toModel(AccountDTO accountDTO);

    @Mapping(target = "userId", expression = "java(account.getUser().getId())")
    AccountDTO toDTO(Account account);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void update(AccountDTO accountDTO, @MappingTarget Account account);

}