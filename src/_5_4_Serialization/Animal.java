package _5_4_Serialization;

import java.io.Serializable;
import java.util.Objects;

public class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Animal) {
            return Objects.equals(name, ((Animal) o).name);
        }
        return false;
    }
}
