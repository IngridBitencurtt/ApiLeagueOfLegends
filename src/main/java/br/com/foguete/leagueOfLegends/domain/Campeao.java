package br.com.foguete.leagueOfLegends.domain;

import br.com.foguete.leagueOfLegends.adapter.in.dto.CampeaoDto;
import br.com.foguete.leagueOfLegends.repository.CampeaoControl;

public class Campeao {

    private String name;
    private String gender;
    private Posicao position;
    private String species;
    private String resource;
    private String rangeType;
    private String region;
    private Integer LocationDateTimeyearOfLaunch;


    public Campeao(String name,
                   String gender,
                   Posicao position,
                   String species,
                   String resource,
                   String rangeType,
                   String region,
                   Integer locationDateTimeyearOfLaunch) {
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
                .setRegion(campeaoControl.getRegiao())
                .setLocationDateTimeyearOfLaunch(campeaoControl.getAnoDeLancamento());
    }

    public static Campeao fromDto(CampeaoDto campeaoDto) {
        return new Campeao()
                .setName(campeaoDto.getNome())
                .setGender(campeaoDto.getGenero())
                .setPosition(campeaoDto.getPosicao())
                .setSpecies(campeaoDto.getEspecie())
                .setResource(campeaoDto.getRecurso())
                .setRangeType(campeaoDto.getTipoDeAlcance())
                .setRegion(campeaoDto.getRegiao())
                .setLocationDateTimeyearOfLaunch(campeaoDto.getAnoDeLancamento());
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

    public Posicao getPosition() {
        return position;
    }

    public Campeao setPosition(Posicao position) {
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

    public Integer getLocationDateTimeyearOfLaunch() {
        return LocationDateTimeyearOfLaunch;
    }

    public Campeao setLocationDateTimeyearOfLaunch(Integer locationDateTimeyearOfLaunch) {
        LocationDateTimeyearOfLaunch = locationDateTimeyearOfLaunch;
        return this;
    }
}
