package com.task.chain.util;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pengj on 2017-03-10.
 */
public class SerializContext {

    public static String serializeMap(Map map){
        ObjectOutputStream oos = null;
        final StringBuilder sb = new StringBuilder();
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    sb.append(b).append(" ");
                }
            }));
            oos.writeObject(map);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    public static Map deserializeMap(String str){
        FileInputStream freader;
        final String[] arr = str.split(" ");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new InputStream(){
                int i=0;
                @Override
                public int read() throws IOException {

                    if(i<arr.length){
                        return Integer.parseInt(arr[i++]);
                    }else{
                        return -1;
                    }
                }
            });
           Map map = (HashMap) objectInputStream.readObject();

           // System.out.println("The name is " + map.get("name"));

            return map;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
