package com.blissofgiving.repository;

import com.mongodb.DBObject;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class DBUtil {

    //return Update object
    public static Update fromDBObjectExcludeNullFields(DBObject object) {
        Update update = new Update();
        for (String key : object.keySet()) {
            Object value = object.get(key);
            if(value!=null){
                update.set(key, value);
            }
        }
        return update;
    }

}
