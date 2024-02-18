package com.akerke.financeapp.common.mapper;

import com.akerke.financeapp.model.dto.UserDTO;
import com.akerke.financeapp.model.entity.Transaction;
import com.akerke.financeapp.model.entity.User;
import org.mapstruct.*;

import java.util.ArrayList;

@Mapper(
        imports = {ArrayList.class, Transaction.class},
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
)
public interface UserMapper {

    @Mapping(target = "transactions", expression = "java(new ArrayList<Transaction>())")
    User toModel(UserDTO userDTO);

    UserDTO toDTO(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "email", ignore = true)
    void update(UserDTO userDTO, @MappingTarget User user);

}