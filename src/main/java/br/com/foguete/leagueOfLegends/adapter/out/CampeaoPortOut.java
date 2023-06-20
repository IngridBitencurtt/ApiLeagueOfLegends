package br.com.foguete.leagueOfLegends.adapter.out;

import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.repository.CampeaoControl;

import java.time.LocalDateTime;
import java.util.List;

public interface CampeaoPortOut {

    List<CampeaoControl> findAllCampeao(String name,
                                        String gender,
                                        String position,
                                        String species,
                                        String resource,
                                        String rangeType,
                                        String region,
                                        LocalDateTime locationDateTimeyearOfLaunch);
}
