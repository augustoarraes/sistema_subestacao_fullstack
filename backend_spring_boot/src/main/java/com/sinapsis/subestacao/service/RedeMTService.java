package com.sinapsis.subestacao.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinapsis.subestacao.dto.RedeMTCreateDTO;
import com.sinapsis.subestacao.dto.RedeMTResponseDTO;
import com.sinapsis.subestacao.model.RedeMTModel;
import com.sinapsis.subestacao.repository.RedeMTRepository;

@Service
public class RedeMTService {
	
	private final RedeMTRepository redeMTRepository;

	public RedeMTService(RedeMTRepository redeMTRepository) {
		this.redeMTRepository = redeMTRepository;
	}
	
	@Transactional
	public RedeMTResponseDTO criarRedeMT(RedeMTCreateDTO redemt) {
		var redeMTModel = new RedeMTModel();
		BeanUtils.copyProperties(redemt, redeMTModel);
		var redemtSalvo = this.redeMTRepository.save(redeMTModel);
		var response = new RedeMTResponseDTO(redemtSalvo);
		return response;
	}

}
