package main.java.utils.serialization;

import java.io.Serializable;

public interface DTOElement<T> extends Serializable {
    T getInstance();
}
