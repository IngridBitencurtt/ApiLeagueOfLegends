package br.com.foguete.leagueOfLegends.core;

import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.domain.Posicao;

import java.util.List;

public interface CampeaoPortIn {

    List<Campeao> findAllCampeao(String nome,
                                 String genero,
                                         Posicao posicao,
                                         String especie,
                                         String recurso,
                                         String tipoDeAlcance,
                                         String regiao,
                                         Integer anoDeLancamento);

    String createCampeao(Campeao campeao);

    Campeao buscaPorId(String id);

    void deletaCampeao(String id);

    void deletaCampeaoPorNome(String nome);

    void atualizaCampeaoPorNome(String nome, Campeao campeao);
}
