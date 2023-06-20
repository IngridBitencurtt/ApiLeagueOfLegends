package br.com.foguete.leagueOfLegends.adapter.in;

import br.com.foguete.leagueOfLegends.adapter.in.dto.CampeaoDto;
import br.com.foguete.leagueOfLegends.core.CampeaoPortIn;
import br.com.foguete.leagueOfLegends.domain.Campeao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/lol/v1/campeoes")
public class HttpCampeaoAdapterIn {

    public final CampeaoPortIn campeaoPortIn;

    public HttpCampeaoAdapterIn(CampeaoPortIn campeaoPortIn) {
        this.campeaoPortIn = campeaoPortIn;
    }


    @GetMapping
    public ResponseEntity<List<CampeaoDto>> consultaGeralCampeoes(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "position", required = false) String position,
            @RequestParam(value = "species", required = false) String species,
            @RequestParam(value = "resource", required = false) String resource,
            @RequestParam(value = "region", required = false) String region,
            @RequestParam(value = "rangeType", required = false) String rangeType,
            @RequestParam(value = "locationDateTimeyearOfLaunch", required = false) LocalDateTime locationDateTimeyearOfLaunch
    ) {
        List<Campeao> findAllCampeaoReturn = this.campeaoPortIn.findAllCampeao(
                name, gender, position, species, resource, rangeType, region, locationDateTimeyearOfLaunch);

        List<CampeaoDto> campeaoDtoList = new ArrayList<>();

        for (Campeao campeao : findAllCampeaoReturn) {
            CampeaoDto campeaoDto = CampeaoDto.from(campeao);
            campeaoDtoList.add(campeaoDto);
        }
        return ResponseEntity.ok(campeaoDtoList);
    }



}
