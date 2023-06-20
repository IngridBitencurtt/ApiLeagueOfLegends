package br.com.foguete.leagueOfLegends.core;

import br.com.foguete.leagueOfLegends.domain.Campeao;

import java.time.LocalDateTime;
import java.util.List;

public interface CampeaoPortIn {

    List<Campeao> findAllCampeao(String name,
                                 String gender,
                                 String position,
                                 String species,
                                 String resource,
                                 String rangeType,
                                 String region,
                                 LocalDateTime locationDateTimeyearOfLaunch);
}
