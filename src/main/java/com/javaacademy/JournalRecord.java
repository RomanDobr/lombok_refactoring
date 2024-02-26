package com.javaacademy;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)

public class JournalRecord {
    double garbageWeight;
    Bottle bottle;
    Cartoon cartoon;

    public JournalRecord(Bottle bottle) {
        this.bottle = bottle;
    }

    public JournalRecord(double garbageWeight) {
        this.garbageWeight = garbageWeight;
    }

    public JournalRecord(Cartoon cartoon) {
        this.cartoon = cartoon;
    }

    @Override
    public String toString() {
        if (bottle != null) {
            return "Переработан стеклянный мусор, получились бутылки объема " + bottle.getVolume() + " мл\n";
        } else if (cartoon != null) {
            return "Переработан картон, получилось " + cartoon.getWeight() + " кг картона\n";
        }
        return "Не переработано: " + garbageWeight + " килограмм мусора\n";
    }
}
