package main.java.utils;

import java.io.*;

public class SerializationManager<T> {
    public void serializeObject(String filename, T obj){
        try{
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(filename));
            file.writeObject(obj);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T deserializeObject(String filename){
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(filename));
            T val = (T) obj.readObject();
            obj.close();
            return val;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
