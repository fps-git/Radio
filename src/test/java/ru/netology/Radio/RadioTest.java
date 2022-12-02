package ru.netology.Radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class RadioTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/stationNumberTestData.csv", numLinesToSkip = 1)
    public void stationNumberTest(String testName, int stationNum, int expected) {
        Radio radio = new Radio();

        radio.setStationNumber(stationNum);
        int actual = radio.getStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/nextStationTestData.csv", numLinesToSkip = 1)
    public void nexStationTest(String testName, int stationNum, int expected) {
        Radio radio = new Radio();
        radio.setStationNumber(stationNum);

        radio.next();
        int actual = radio.getStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/prevStationTestData.csv", numLinesToSkip = 1)
    public void prevStationTest(String testName, int stationNum, int expected) {
        Radio radio = new Radio();
        radio.setStationNumber(stationNum);

        radio.prev();
        int actual = radio.getStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/volumeUpTestData.csv", numLinesToSkip = 1)
    public void volumeUpTest(String testName, int volLevel, int expected) {
        Radio radio = new Radio();
        radio.setVolumeLevel(volLevel);

        radio.volumeUp();
        int actual = radio.getVolumeLevel();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/volumeDownTestData.csv", numLinesToSkip = 1)
    public void volumeDownTest(String testName, int volLevel, int expected) {
        Radio radio = new Radio();
        radio.setVolumeLevel(volLevel);

        radio.volumeDown();
        int actual = radio.getVolumeLevel();

        Assertions.assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/technical100PercCoverageTestData", numLinesToSkip = 1)
    public void volumeTechnicalTest(String testName, int volLevel, int expected) {
        Radio radio = new Radio();

        radio.setVolumeLevel(volLevel);
        int actual = radio.getVolumeLevel();

        Assertions.assertEquals(expected, actual);

    }
}