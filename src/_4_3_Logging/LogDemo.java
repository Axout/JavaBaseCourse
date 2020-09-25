package _4_3_Logging;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Программка демонстрирует что такое логирование.
 */

public class LogDemo {
    // gerLogger() - возвращает логер с указанным именем
    // по сути так создаётся объект для логирования
    private static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

    public static void main(String[] args) {
        // вывод сообщения в лог
        LOGGER.info("my first message");

        // По умолчанию логгер настроен на уровень INFO, поэтому логгер с уровнем FINE записываться не будет.
        // Но это можно переопределить в конфиг файле (logging.properties)
        // Для этого нужно в настройках конфигурации запуска ввести команду:
        // -Djava.util.logging.config.file=ПолныйАдресФайла

        // Запишем в лог сообщение (с уровнем FINE) о входном массиве. Сам входной массив мы прописываем в "Edit Configurations..." - конфигурация запуска
        LOGGER.log(Level.FINE, "Started with argument: {0}", Arrays.toString(args));

        try {
            randomlyFailingAlgorithm();
        } catch (IllegalStateException e) {
            // Если всё же сгенерированное число меньше 0.5, то поймав исключение, запишем его в лог. И завершим программу с кодом 2.
            LOGGER.log(Level.SEVERE, "Exception caught", e);
            System.exit(2);
        }

    }

    // метода генерерует случайное число и записывает его в лог.
    // Если число меньше 0.5, то бросаем исключение. Если больше, то программа просто завршит работу.
    private static void randomlyFailingAlgorithm() {
        double randomNumber = Math.random();
        LOGGER.log(Level.FINE, "Generated random number: {0}", randomNumber);
        if (randomNumber < 0.5) {
            throw new IllegalStateException("Invalid phase of the Moon");
        }
    }
}
