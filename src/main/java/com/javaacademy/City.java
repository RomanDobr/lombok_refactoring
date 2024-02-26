package com.javaacademy;

import lombok.*;
import lombok.experimental.FieldDefaults;

import static com.javaacademy.GarbageType.*;




/**
 * Город
 */
@ToString
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City {
    @NonNull
    final String name;
    @ToString.Exclude
    int peopleCount;

    public Garbage[] createGarbage() {
        return new Garbage[] {
            new Garbage(GLASS, 1_000, this.name),
            new Garbage(PAPER, 15_000, this.name),
            new Garbage(MIXED, 200_000, this.name),
        };
    }

    public void setPeopleCount(Integer peopleCount) {
        this.peopleCount = peopleCount;
    }
}
