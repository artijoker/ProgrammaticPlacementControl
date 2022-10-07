package com.example.programmaticplacementcontrol;

public class City {
    private final String _name;
    private final int _population;
    private final int _airports;
    private final int _railwayStations;
    private final int _universities;
    private final int _museums;
    private final int _libraries;
    private final int _parksAndGardens;
    private final String _info;

    public City(String name,
                int population,
                int airports,
                int railwayStations,
                int universities,
                int museums,
                int libraries,
                int parksAndGardens,
                String info) {
        _name = name;
        _population = population;
        _airports = airports;
        _railwayStations = railwayStations;
        _universities = universities;
        _museums = museums;
        _libraries = libraries;
        _parksAndGardens = parksAndGardens;
        _info = info;
    }

    public String getName() {
        return _name;
    }

    public int getPopulation() {
        return _population;
    }

    public int getAirports() {
        return _airports;
    }

    public int getRailwayStations() {
        return _railwayStations;
    }

    public int getUniversities() {
        return _universities;
    }

    public int getMuseums() {
        return _museums;
    }

    public int getLibraries() {
        return _libraries;
    }

    public int getParksAndGardens() {
        return _parksAndGardens;
    }

    public String getInfo() {
        return _info;
    }
}
