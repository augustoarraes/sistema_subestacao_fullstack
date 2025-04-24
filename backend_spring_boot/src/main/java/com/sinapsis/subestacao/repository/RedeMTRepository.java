package com.sinapsis.subestacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinapsis.subestacao.model.RedeMTModel;

public interface RedeMTRepository extends JpaRepository<RedeMTModel, Integer>{

	void deleteByIdSubestacao(int idSubestacao);
	
	List<RedeMTModel> findByIdSubestacao(int idSubestacao);
	
}
