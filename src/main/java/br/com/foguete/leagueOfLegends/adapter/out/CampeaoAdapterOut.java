package br.com.foguete.leagueOfLegends.adapter.out;


import br.com.foguete.leagueOfLegends.domain.Campeao;
import br.com.foguete.leagueOfLegends.repository.CampeaoControl;
import br.com.foguete.leagueOfLegends.repository.CampeaoRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class CampeaoAdapterOut implements CampeaoPortOut {

    private final MongoTemplate mongoTemplate;
    private final CampeaoRepository campeaoRepository;
    public CampeaoAdapterOut(MongoTemplate mongoTemplate, CampeaoRepository campeaoRepository) {
        this.mongoTemplate = mongoTemplate;
        this.campeaoRepository = campeaoRepository;
    }


    @Override
    public List<CampeaoControl> findAllCampeao(String name,
                                               String gender,
                                               String position,
                                               String species,
                                               String resource,
                                               String rangeType,
                                               String region,
                                               Integer locationDateTimeyearOfLaunch) {
        Query query = this.buildQuery(name,
                gender,
                position,
                species,
                resource,
                rangeType,
                region,
                locationDateTimeyearOfLaunch);
        return mongoTemplate.find(query, CampeaoControl.class);
    }

    @Override
    public Optional<CampeaoControl> findByNome(String nome) {
        return this.campeaoRepository.findByNome(nome);
    }

    @Override
    public String criaCampeao(Campeao campeao) {
        CampeaoControl campeaoControl = CampeaoControl.campeaoControl(campeao);
        CampeaoControl campeaoSave = this.campeaoRepository.save(campeaoControl);
        return campeaoSave.getId();
    }


    private Query buildQuery(String name,
                             String gender,
                             String position,
                             String species,
                             String resource,
                             String rangeType,
                             String region,
                             Integer locationDateTimeyearOfLaunch) {
        Query query = new Query();


        if (!ObjectUtils.isEmpty(name)) {
            query.addCriteria(Criteria.where("nome").is(name));
        }
        if (!ObjectUtils.isEmpty(gender)) {
            query.addCriteria(Criteria.where("genero").is(gender));
        }
        if (!ObjectUtils.isEmpty(position)) {
            query.addCriteria(Criteria.where("posicao").is(position));
        }
        if (!ObjectUtils.isEmpty(species)) {
            query.addCriteria(Criteria.where("especie").is(species));
        }
        if (!ObjectUtils.isEmpty(resource)) {
            query.addCriteria(Criteria.where("recurso").is(resource));
        }
        if (!ObjectUtils.isEmpty(rangeType)) {
            query.addCriteria(Criteria.where("tipoDeAlcance").is(rangeType));
        }
        if (!ObjectUtils.isEmpty(region)) {
            query.addCriteria(Criteria.where("regiao").is(region));
        }
        if (!ObjectUtils.isEmpty(locationDateTimeyearOfLaunch)) {
            query.addCriteria(Criteria.where("anoDeLancamento").is(locationDateTimeyearOfLaunch));
        }

        return query;
    }

}
