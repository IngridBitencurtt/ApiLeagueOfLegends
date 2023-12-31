package br.com.foguete.leagueOfLegends.core;

import br.com.foguete.leagueOfLegends.adapter.in.exception.BusinessException;
import br.com.foguete.leagueOfLegends.adapter.out.CampeaoPortOut;
import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.domain.Posicao;
import br.com.foguete.leagueOfLegends.repository.CampeaoControl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampeaoCore implements CampeaoPortIn{

    public final CampeaoPortOut campeaoPortOut;

    public CampeaoCore(CampeaoPortOut campeaoPortOut) {
        this.campeaoPortOut = campeaoPortOut;
    }



    @Override
    public List<Campeao> findAllCampeao(String nome,
                                        String genero,
                                        Posicao posicao,
                                        String especie,
                                        String recurso,
                                        String tipoDeAlcance,
                                        String regiao,
                                        Integer anoDeLancamento) {

       List<CampeaoControl> campeaoControlList = this.campeaoPortOut.findAllCampeao(nome,
               genero,
               posicao,
               especie,
               recurso,
               tipoDeAlcance,
               regiao,
               anoDeLancamento);

        List<Campeao> campeaoList = new ArrayList<>();

        for(CampeaoControl campeaoControl : campeaoControlList){
            Campeao campeao = Campeao.from(campeaoControl);
            campeaoList.add(campeao);
        }

        return campeaoList;
    }

    @Override
    public String createCampeao(Campeao campeao) {
        Optional<CampeaoControl> findNome = this.campeaoPortOut.findByNome(campeao.getName());
        if (findNome.isPresent()){
            throw new BusinessException("Campão " + campeao.getName() + " Já existe" );
        }
        return this.campeaoPortOut.criaCampeao(campeao);
    }

    @Override
    public Campeao buscaPorId(String id) {
        Campeao campeao =  this.campeaoPortOut.buscaPorId(id);

        return campeao;
    }

    @Override
    public void deletaCampeao(String id) {
        this.campeaoPortOut.deletaCampeao(id);

    }

    @Override
    public void deletaCampeaoPorNome(String nome) {
        this.campeaoPortOut.deletaCampeaoPorNome(nome);

    }

    @Override
    public void atualizaCampeaoPorNome(String nome, Campeao campeao) {
        Optional<CampeaoControl> campeaoPorNome =
                this.campeaoPortOut.findByNome(campeao.getName());

        if (campeaoPorNome.isEmpty()){
            this.campeaoPortOut.atualizaCampeaoNome(nome,campeao);
            return;
        }
        if (campeaoPorNome.get().getNome().equals(nome)){
            this.campeaoPortOut.atualizaCampeaoNome(nome,campeao);
            return;
        }
        throw new BusinessException("Campeão "+ campeaoPorNome.get().getNome() + " já existe");

    }
}
