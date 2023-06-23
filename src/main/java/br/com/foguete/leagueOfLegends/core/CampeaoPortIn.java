package br.com.foguete.leagueOfLegends.core;

import br.com.foguete.leagueOfLegends.domain.Campeao;

import java.util.List;

public interface CampeaoPortIn {

    List<Campeao> findAllCampeao(String nome,
                                 String genero,
                                         String posicao,
                                         String especie,
                                         String recurso,
                                         String tipoDeAlcance,
                                         String regiao,
                                         Integer anoDeLancamento);

    String createCampeao(Campeao campeao);

    Campeao buscaPorId(String id);
}
