package com.javaacademy;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
@EqualsAndHashCode
public class Garbage {
    GarbageType garbageType;
    double weight;
    String cityFrom;
}
