package com.sinapsis.subestacao.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinapsis.subestacao.model.SubestacaoModel;

@Repository
public interface SubestacaoRepository extends JpaRepository<SubestacaoModel, Integer>{

}
