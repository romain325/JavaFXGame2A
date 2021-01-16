package main.java.utils.serialization;

import java.io.Serializable;

public interface DTOElement<T> extends Serializable {
    /**
     * return a new instance from the DTO
     * @return Instance of the DTO origin
     */
    T getInstance();
}
