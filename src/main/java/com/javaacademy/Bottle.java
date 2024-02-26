package com.javaacademy;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

/**
 * Бутылка
 */
@Data
public class Bottle {
    @NonNull
    final double volume;
    double nestedVolume;
    @NonNull
    @ToString.Exclude
    final String cityProducer;

    public void addLiquid(double liquidVolume) {
        if (liquidVolume > nestedVolume) {
            throw  new RuntimeException("Объем добавляемой жидкости больше чем объем бутылки");
        }
        double newNestedVolume = nestedVolume + liquidVolume;
        if (newNestedVolume > volume) {
            throw  new RuntimeException("Нет места в бутылки, все выливается!");
        }
        setNestedVolume(newNestedVolume);
    }
}
