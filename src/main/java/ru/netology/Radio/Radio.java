package ru.netology.Radio;

public class Radio {
    private int stationNumber;
    private int volumeLevel = 1; //Зададим значение громкости по умолчанию при включении радио

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int stationNumber) {
        if (stationNumber < 0) {
            return;
        }
        if (stationNumber > 9) {
            return;
        }
        this.stationNumber = stationNumber;
    }

    public void next() {
        if (stationNumber == 9) {
            setStationNumber(0);
        } else {
            setStationNumber(stationNumber + 1);
        }
    }

    public void prev() {
        if (stationNumber == 0) {
            setStationNumber(9);
        } else {
            setStationNumber(stationNumber - 1);
        }
    }

    public int getVolumeLevel() {
        return volumeLevel;
    }

    public void setVolumeLevel(int volumeLevel) {
        if (volumeLevel < 0) {
            return;
        }
        if (volumeLevel > 10) {
            return;
        }
        this.volumeLevel = volumeLevel;
    }

    public void volumeUp() {
        if (volumeLevel < 10) {
            volumeLevel = volumeLevel + 1;
        }
    }

    public void volumeDown() {
        if (volumeLevel > 0) {
            volumeLevel = volumeLevel - 1;
        }
    }
}
