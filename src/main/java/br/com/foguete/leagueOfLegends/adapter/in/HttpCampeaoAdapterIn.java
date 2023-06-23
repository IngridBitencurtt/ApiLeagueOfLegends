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
    public ResponseEntity<String> criacaoCampeao(@RequestBody @Valid CampeaoDto campeaoDto) {
        Campeao campeao = new Campeao(campeaoDto.getNome()
                , campeaoDto.getGenero()
                , campeaoDto.getPosicao()
                , campeaoDto.getEspecie()
                , campeaoDto.getRecurso()
                , campeaoDto.getTipoDeAlcance()
                , campeaoDto.getRegiao()
                , campeaoDto.getAnoDeLancamento());

        String idCampeao = this.campeaoPortIn.createCampeao(campeao);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(idCampeao).toUri()).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CampeaoDto> buscaCampeaoPorId(@PathVariable("id") String id) {

        Campeao campeao = this.campeaoPortIn.buscaPorId(id);
        return ResponseEntity.ok(CampeaoDto.from(campeao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletaCampeaoPorId(@PathVariable("id") String id) {

        this.campeaoPortIn.deletaCampeao(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<CampeaoDto>> buscaCampeoesPorNome(@PathVariable("nome") String nome) {
        List<Campeao> findAllCampeaoReturn = this.campeaoPortIn.findAllCampeao(nome
                , null
                , null
                , null
                , null
                , null
                , null
                , null);

        List<CampeaoDto> campeaoDtoList = new ArrayList<>();

        for (Campeao campeao : findAllCampeaoReturn) {
            CampeaoDto campeaoDto = CampeaoDto.from(campeao);
            campeaoDtoList.add(campeaoDto);
        }

        return ResponseEntity.ok(campeaoDtoList);
    }
}
