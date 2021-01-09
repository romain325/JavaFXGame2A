package main.java.core.logic;

public interface Consommable {
    boolean isConsumed();
    boolean hasIllimitedConsommation();
    void consume();
}
