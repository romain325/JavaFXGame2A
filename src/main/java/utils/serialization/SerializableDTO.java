package main.java.utils.serialization;

public interface SerializableDTO<T> {
    /**
     * return a DTO from the current instance
     * @return adapted DTO from current instance
     */
    T getDTO();
}
