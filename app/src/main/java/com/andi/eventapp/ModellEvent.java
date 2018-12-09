package com.andi.eventapp;

public class ModellEvent {

    String name;
    String ort;
    String beschreibung;
    String datum;
    String key;

    public ModellEvent() {
    }

    public ModellEvent(String name, String ort, String beschreibung, String datum, String key) {

        this.name = name;
        this.ort = ort;
        this.beschreibung = beschreibung;
        this.datum = datum;
        this.key = key;
    }

    @Override
    public String toString() {
        return getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
