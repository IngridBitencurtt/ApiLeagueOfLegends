package br.com.foguete.leagueOfLegends.adapter.out;


import br.com.foguete.leagueOfLegends.repository.CampeaoControl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CampeaoAdapterOut implements CampeaoPortOut {

    private final MongoTemplate mongoTemplate;

    public CampeaoAdapterOut(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<CampeaoControl> findAllCampeao(String name,
                                               String gender,
                                               String position,
                                               String species,
                                               String resource,
                                               String rangeType,
                                               String region,
                                               LocalDateTime locationDateTimeyearOfLaunch) {
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




    private Query buildQuery(String nome, String genero, String posicao,
                             String especie, String recurso,
                             String tipoDeAlcance, String regiao,
                             LocalDateTime anoDeLancamento) {
        Query query = new Query();


        if (!ObjectUtils.isEmpty(nome)) {
            query.addCriteria(Criteria.where("name").is(nome));
        }
        if (!ObjectUtils.isEmpty(genero)) {
            query.addCriteria(Criteria.where("gender").is(genero));
        }
        if (!ObjectUtils.isEmpty(posicao)) {
            query.addCriteria(Criteria.where("position").is(posicao));
        }
        if (!ObjectUtils.isEmpty(especie)) {
            query.addCriteria(Criteria.where("species").is(especie));
        }
        if (!ObjectUtils.isEmpty(recurso)) {
            query.addCriteria(Criteria.where("resource").is(recurso));
        }
        if (!ObjectUtils.isEmpty(tipoDeAlcance)) {
            query.addCriteria(Criteria.where("rangeType").is(tipoDeAlcance));
        }
        if (!ObjectUtils.isEmpty(regiao)) {
            query.addCriteria(Criteria.where("region").is(regiao));
        }
        if (!ObjectUtils.isEmpty(anoDeLancamento)) {
            query.addCriteria(Criteria.where("locationDateTimeyearOfLaunch").is(anoDeLancamento));
        }

        return query;
    }

}
