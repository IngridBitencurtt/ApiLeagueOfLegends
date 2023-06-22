package br.com.foguete.leagueOfLegends.adapter.out;

import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.repository.CampeaoControl;

import java.util.List;
import java.util.Optional;

public interface CampeaoPortOut {

    List<CampeaoControl> findAllCampeao(String name,
                                        String gender,
                                        String position,
                                        String species,
                                        String resource,
                                        String rangeType,
                                        String region,
                                        Integer locationDateTimeyearOfLaunch);

    Optional<CampeaoControl> findByNome(String nome);

    String criaCampeao(Campeao campeao);

}
