package com.javaacademy;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import java.io.BufferedWriter;
import static com.javaacademy.GarbageType.GLASS;
import static com.javaacademy.GarbageType.PAPER;

/**
 * Фабрика по переработке мусора
 */
@NoArgsConstructor
public class UtilizationFactory {
    public static final double BOTTLE_SIZE = 500;

    @SneakyThrows
    private static Bottle refactorGlassGarbage(Garbage garbage) {
        if (garbage.getGarbageType() != GLASS) {
            throw new GarbageNotRefactorableException("Мусор не состоит полностью из стекла!");
        }
        return new Bottle(BOTTLE_SIZE, garbage.getCityFrom());
    }

    @SneakyThrows
    private static Cartoon refactorPaperGarbage(Garbage garbage) {
        if (garbage.getGarbageType() != PAPER) {
            throw new GarbageNotRefactorableException("Мусор не состоит полностью из бумаги!");
        }
        return new Cartoon(garbage.getWeight() / 2);
    }

    @SneakyThrows
    public static void refactorGarbage(Garbage[] garbageArray, BufferedWriter journal) {
        for (Garbage garbage : garbageArray) {
            refactorGarbageHelper(garbage, garbage.getGarbageType(), journal);
        }
    }

    @SneakyThrows
    public static void refactorGarbageHelper(Garbage garbage, GarbageType garbageType, BufferedWriter journal) {
        switch (garbageType) {
            case GLASS -> journal.write(new JournalRecord(UtilizationFactory.refactorGlassGarbage(garbage)).toString());
            case PAPER -> journal.write(new JournalRecord(UtilizationFactory.refactorPaperGarbage(garbage)).toString());
            default -> journal.write(new JournalRecord(garbage.getWeight()).toString());
        }
    }
}
