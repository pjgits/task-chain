package com.task.chain.lang;

import com.task.chain.util.SerializContext;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pengj on 2017-03-10.
 */
public class SerializeTest {

    @org.junit.Test
    public void serialize(){
        Map<String,Integer> map = new HashMap<String, Integer>();
        map.put("test2",2);
        map.put("test3",3);
        map.put("test4",4);
        String s = SerializContext.serializeMap(map);
        System.out.println(s.length());
        System.out.println(s);
        map = SerializContext.deserializeMap(s);
        for(Map.Entry entry:map.entrySet()){
            System.out.println(entry.getKey().toString()+"::"+entry.getValue().toString());
        }
    }
}
