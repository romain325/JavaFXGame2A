package main.java.utils.serialization;

import java.io.*;
import java.nio.file.Path;
import java.util.stream.Stream;

public class SerializationManager {
    /**
     * serialize a given object
     * @param filename file where object while be saved
     * @param obj the object to serialize
     * @param <T> the object type
     */
    public static <T extends SerializableDTO> void serializeObject(String filename, T obj){
        try{
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(filename));
            file.writeObject(obj.getDTO());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * deserialize an object
     * @param filename file where the object is stored
     * @param <T> type of the object to deserialize
     * @return deserialized object
     */
    public static <T extends DTOElement> T deserializeObject(String filename){
        try {
            return deserializeStream(new FileInputStream(filename));
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    /**
     * Deserialize an object from resources
     * @param filename file where the object is serialized in the resources
     * @param <T> type of the serialized oibject
     * @return deserialized object
     */
    public static <T extends DTOElement> T deserializeObjectFromResource(String filename){
        return deserializeStream(SerializationManager.class.getResourceAsStream(filename));
    }

    /**
     * deserialize an object from InputStream
     * @param objStream InputStream containing a serialized object
     * @param <T> type of the serialized object
     * @return deserialized object
     */
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
