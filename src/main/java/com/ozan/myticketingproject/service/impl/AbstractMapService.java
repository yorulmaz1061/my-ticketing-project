package com.ozan.myticketingproject.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapService<T,ID> {
    /*
    We have no database, Whenever I say save this object. Where is this gonna be saved??
    In this case we will use HashMap <Key,Value> for crud operations.
    Actually repository section is designed with HashMap.
    In our case key is ID, value is object, with generic combination.
     */
    protected Map<ID,T> map=new HashMap<>();
    T save (ID id, T object){
        map.put(id,object);
        return object;
    }
    List<T> findAll(){
        return new ArrayList<>(map.values());
    }
    T findById(ID id){
        return map.get(id);
    }
    void deleteById(ID id){
        map.remove(id);
    }
    void update(ID id, T object){
        map.put(id,object);
    }


}
