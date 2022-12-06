package ru.netology.Radio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class RadioTest {
    @Test
    public void zeroNumberOfStationsSettingLimitsTest() {
        Radio radio = new Radio(0);

        int expected = 10;
        int actual = radio.getNumberOfStations();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void moreThan1000numberOfStationsSettingLimitsTest() {
        Radio radio = new Radio(1001);

        int expected = 1000;
        int actual = radio.getNumberOfStations();

        Assertions.assertEquals(expected, actual);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/stationFlexibleTestData.csv", numLinesToSkip = 1)
    public void stationNumberFlexibleTest(String testName, int numberOfStations, int stationNum, int expected) {
        Radio radio = new Radio(numberOfStations);

        radio.setStationNumber(stationNum);
        int actual = radio.getStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/nextStationTestData.csv", numLinesToSkip = 1)
    public void nexStationTest(String testName, int numberOfStations, int stationNum, int expected) {
        Radio radio = new Radio(numberOfStations);
        radio.setStationNumber(stationNum);

        radio.next();
        int actual = radio.getStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/prevStationTestData.csv", numLinesToSkip = 1)
    public void prevStationTest(String testName, int numberOfStations, int stationNum, int expected) {
        Radio radio = new Radio(numberOfStations);
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
    @CsvFileSource(resources = "/technical100PercCoverageTestData.csv", numLinesToSkip = 1)
    public void volumeTechnicalTest(String testName, int volLevel, int expected) {
        Radio radio = new Radio();

        radio.setVolumeLevel(volLevel);
        int actual = radio.getVolumeLevel();

        Assertions.assertEquals(expected, actual);

    }
}