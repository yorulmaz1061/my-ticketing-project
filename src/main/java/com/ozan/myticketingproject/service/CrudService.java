package com.ozan.myticketingproject.service;

import java.util.List;

public interface CrudService <T,ID>{
    T save(T object);
    List<T> findAll();
    T findById(ID id);
    void deleteById(ID id);
    //T represents object
    //ID is String or Long
    void update(T object);
    //If anything new come to business logic, you can edit from CRUD.


}
