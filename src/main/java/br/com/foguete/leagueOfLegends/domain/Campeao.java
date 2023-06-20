package br.com.foguete.leagueOfLegends.domain;

import br.com.foguete.leagueOfLegends.repository.CampeaoControl;

import java.time.LocalDateTime;

public class Campeao {

    private String name;
    private String gender;
    private String position;
    private String species;
    private String resource;
    private String rangeType;
    private String region;
    private LocalDateTime LocationDateTimeyearOfLaunch;


    public Campeao(String name,
                   String gender,
                   String position,
                   String species,
                   String resource,
                   String rangeType,
                   String region,
                   LocalDateTime locationDateTimeyearOfLaunch) {
        this.name = name;
        this.gender = gender;
        this.position = position;
        this.species = species;
        this.resource = resource;
        this.rangeType = rangeType;
        this.region = region;
        LocationDateTimeyearOfLaunch = locationDateTimeyearOfLaunch;
    }

    public Campeao() {

    }

    public static Campeao from(CampeaoControl campeaoControl) {
        return new Campeao()
                .setName(campeaoControl.getNome())
                .setGender(campeaoControl.getGenero())
                .setPosition(campeaoControl.getPosicao())
                .setSpecies(campeaoControl.getEspecie())
                .setResource(campeaoControl.getRecurso())
                .setRangeType(campeaoControl.getTipoDeAlcance())
                .setRegion(campeaoControl.getRegiao());
    }

    public String getName() {
        return name;
    }

    public Campeao setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Campeao setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public Campeao setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getSpecies() {
        return species;
    }

    public Campeao setSpecies(String species) {
        this.species = species;
        return this;
    }

    public String getResource() {
        return resource;
    }

    public Campeao setResource(String resource) {
        this.resource = resource;
        return this;
    }

    public String getRangeType() {
        return rangeType;
    }

    public Campeao setRangeType(String rangeType) {
        this.rangeType = rangeType;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public Campeao setRegion(String region) {
        this.region = region;
        return this;
    }

    public LocalDateTime getLocationDateTimeyearOfLaunch() {
        return LocationDateTimeyearOfLaunch;
    }

    public Campeao setLocationDateTimeyearOfLaunch(LocalDateTime locationDateTimeyearOfLaunch) {
        LocationDateTimeyearOfLaunch = locationDateTimeyearOfLaunch;
        return this;
    }
}