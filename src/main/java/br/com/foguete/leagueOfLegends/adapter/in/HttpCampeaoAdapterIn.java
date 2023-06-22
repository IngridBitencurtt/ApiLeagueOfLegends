package br.com.foguete.leagueOfLegends.adapter.in;

import br.com.foguete.leagueOfLegends.adapter.in.dto.CampeaoDto;
import br.com.foguete.leagueOfLegends.core.CampeaoPortIn;
import br.com.foguete.leagueOfLegends.domain.Campeao;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
            @RequestParam(value = "nome", required = false) String nome,
            @RequestParam(value = "genero", required = false) String genero,
            @RequestParam(value = "posicao", required = false) String posicao,
            @RequestParam(value = "especie", required = false) String especie,
            @RequestParam(value = "recurso", required = false) String recurso,
            @RequestParam(value = "regiao", required = false) String regiao,
            @RequestParam(value = "tipoDeAlcance", required = false) String tipoDeAlcance,
            @RequestParam(value = "anoDeLancamento", required = false) Integer anoDeLancamento
    ) {
        List<Campeao> findAllCampeaoReturn = this.campeaoPortIn.findAllCampeao(
                nome, genero, posicao, especie, recurso, tipoDeAlcance, regiao, anoDeLancamento);

        List<CampeaoDto> campeaoDtoList = new ArrayList<>();

        for (Campeao campeao : findAllCampeaoReturn) {
            CampeaoDto campeaoDto = CampeaoDto.from(campeao);
            campeaoDtoList.add(campeaoDto);
        }
        return ResponseEntity.ok(campeaoDtoList);
    }

    @PostMapping
    public  ResponseEntity<String> criacaoCampeao(@RequestBody @Valid CampeaoDto campeaoDto){
        Campeao campeao = new Campeao(campeaoDto.getNome()
                ,campeaoDto.getGenero()
                ,campeaoDto.getPosicao()
                ,campeaoDto.getEspecie()
                ,campeaoDto.getRecurso()
                ,campeaoDto.getTipoDeAlcance()
                ,campeaoDto.getRegiao()
                ,campeaoDto.getAnoDeLancamento());

        String idPersonagem = this.campeaoPortIn.createCampeao(campeao);

        return  ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idPersonagem).toUri()).build();
    }



}
