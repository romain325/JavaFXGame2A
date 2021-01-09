package main.java.utils.serialization;

import java.io.*;
import java.util.stream.Stream;

public class SerializationManager {
    public static <T extends SerializableDTO> void serializeObject(String filename, T obj){
        try{
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(filename));
            file.writeObject(obj.getDTO());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T extends DTOElement> T deserializeObject(String filename){
        try {
            return deserializeStream(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public static <T extends DTOElement> T deserializeObjectFromResource(String filename){
        return deserializeStream(SerializationManager.class.getResourceAsStream(filename));
    }

    private static <T extends DTOElement> T deserializeStream(InputStream objStream){
        try {
            ObjectInputStream obj = new ObjectInputStream(objStream);
            T val = (T) obj.readObject();
            obj.close();
            return val;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
