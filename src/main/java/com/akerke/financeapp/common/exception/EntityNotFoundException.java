package com.akerke.financeapp.common.exception;

public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(Class<?> entityClass, Object id){
        super(entityClass.getSimpleName() + " with id " + id
                .toString() + " not found");
    }
}
