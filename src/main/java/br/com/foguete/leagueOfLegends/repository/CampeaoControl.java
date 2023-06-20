package br.com.foguete.leagueOfLegends.repository;

import br.com.foguete.leagueOfLegends.domain.Campeao;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import org.springframework.data.annotation.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "league-of-legends")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CampeaoControl {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nome;

    private String genero;

    private String posicao;

    private String especie;

    private String recurso;

    private String tipoDeAlcance;

    private String regiao;

    private LocalDateTime anoDeLancamento;

    public CampeaoControl(String id,
                          String nome,
                          String genero,
                          String posicao,
                          String especie,
                          String recurso,
                          String tipoDeAlcance,
                          String regiao,
                          LocalDateTime anoDeLancamento) {
        this.id = id;
        this.nome = nome;
        this.genero = genero;
        this.posicao = posicao;
        this.especie = especie;
        this.recurso = recurso;
        this.tipoDeAlcance = tipoDeAlcance;
        this.regiao = regiao;
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getId() {
        return id;
    }

    public CampeaoControl setId(String id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public CampeaoControl setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getGenero() {
        return genero;
    }

    public CampeaoControl setGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public String getPosicao() {
        return posicao;
    }

    public CampeaoControl setPosicao(String posicao) {
        this.posicao = posicao;
        return this;
    }

    public String getEspecie() {
        return especie;
    }

    public CampeaoControl setEspecie(String especie) {
        this.especie = especie;
        return this;
    }

    public String getRecurso() {
        return recurso;
    }

    public CampeaoControl setRecurso(String recurso) {
        this.recurso = recurso;
        return this;
    }

    public String getTipoDeAlcance() {
        return tipoDeAlcance;
    }

    public CampeaoControl setTipoDeAlcance(String tipoDeAlcance) {
        this.tipoDeAlcance = tipoDeAlcance;
        return this;
    }

    public String getRegiao() {
        return regiao;
    }

    public CampeaoControl setRegiao(String regiao) {
        this.regiao = regiao;
        return this;
    }

    public LocalDateTime getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public CampeaoControl setAnoDeLancamento(LocalDateTime anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
        return this;
    }

    public CampeaoControl() {
    }

    public static CampeaoControl CampeaoControl(Campeao campeao) {
        return new CampeaoControl()
                .setNome(campeao.getName())
                .setGenero(campeao.getGender())
                .setPosicao(campeao.getPosition())
                .setEspecie(campeao.getSpecies())
                .setRecurso(campeao.getResource())
                .setTipoDeAlcance(campeao.getRangeType())
                .setRegiao(campeao.getRegion())
                .setAnoDeLancamento(campeao.getLocationDateTimeyearOfLaunch());

    }
}