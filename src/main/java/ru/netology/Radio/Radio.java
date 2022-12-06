package ru.netology.Radio;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Radio {
    private int numberOfStations;
    private final int minVolumeLevel = 0;
    private final int maxVolumeLevel = 100;
    private int stationNumber;
    private int volumeLevel = 1; //Зададим значение громкости по умолчанию при включении радио

    public Radio(int numberOfStations) {
        //Ограничим максимальное количество станций осмысленным числом с запасом
        if (numberOfStations > 1 && numberOfStations <= 1000) {
            this.numberOfStations = numberOfStations;
        } else {
            if (numberOfStations < 1) { //Если будет задано нулевое или отрицательное кол-во то установим по умолчанию
                this.numberOfStations = 10;
            } else {
                this.numberOfStations = 1000; //Если будет задано больше 1000 то установим 1000
            }
        }
    }

    public void setStationNumber(int stationNumber) {
        if (stationNumber < 0) {
            return;
        }
        if (stationNumber >= numberOfStations) {
            return;
        }
        this.stationNumber = stationNumber;
    }

    public void next() {
        if (stationNumber == (numberOfStations - 1)) {
            setStationNumber(0);
        } else {
            setStationNumber(stationNumber + 1);
        }
    }

    public void prev() {
        if (stationNumber == 0) {
            setStationNumber(numberOfStations - 1);
        } else {
            setStationNumber(stationNumber - 1);
        }
    }

    public void setVolumeLevel(int volumeLevel) {
        if (volumeLevel < minVolumeLevel) {
            return;
        }
        if (volumeLevel > maxVolumeLevel) {
            return;
        }
        this.volumeLevel = volumeLevel;
    }

    public void volumeUp() {
        if (volumeLevel < maxVolumeLevel) {
            volumeLevel = volumeLevel + 1;
        }
    }

    public void volumeDown() {
        if (volumeLevel > minVolumeLevel) {
            volumeLevel = volumeLevel - 1;
        }
    }
}
