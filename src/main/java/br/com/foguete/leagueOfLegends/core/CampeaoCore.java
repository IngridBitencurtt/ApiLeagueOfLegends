package br.com.foguete.leagueOfLegends.core;

import br.com.foguete.leagueOfLegends.adapter.out.CampeaoPortOut;
import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.repository.CampeaoControl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CampeaoCore implements CampeaoPortIn{

    public final CampeaoPortOut campeaoPortOut;

    public CampeaoCore(CampeaoPortOut campeaoPortOut) {
        this.campeaoPortOut = campeaoPortOut;
    }



    @Override
    public List<Campeao> findAllCampeao(String name,
                                        String gender,
                                        String position,
                                        String species,
                                        String resource,
                                        String rangeType,
                                        String region,
                                        LocalDateTime locationDateTimeyearOfLaunch) {

       List<CampeaoControl> CampeaoControlList = this.campeaoPortOut.findAllCampeao(name,
               gender,
               position,
               species,
               resource,
               rangeType,
               region,
               locationDateTimeyearOfLaunch);

        List<Campeao> campeaoList = new ArrayList<>();

        for(CampeaoControl campeaoControl : CampeaoControlList){
            Campeao campeao = Campeao.from(campeaoControl);
            campeaoList.add(campeao);
        }

        return campeaoList;
    }
}
