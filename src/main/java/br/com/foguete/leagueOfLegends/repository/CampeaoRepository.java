package br.com.foguete.leagueOfLegends.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeaoRepository  extends MongoRepository<CampeaoControl, String> {
}

