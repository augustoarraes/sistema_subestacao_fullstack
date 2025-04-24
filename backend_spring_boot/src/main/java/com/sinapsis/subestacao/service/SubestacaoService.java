package com.sinapsis.subestacao.service;

import org.springframework.transaction.annotation.Transactional;

import com.sinapsis.subestacao.dto.RedeMTCreateDTO;
import com.sinapsis.subestacao.dto.RedeMTResponseDTO;
import com.sinapsis.subestacao.dto.SubestacaoCreateDTO;
import com.sinapsis.subestacao.dto.SubestacaoResponseDTO;
import com.sinapsis.subestacao.model.RedeMTModel;
import com.sinapsis.subestacao.model.SubestacaoModel;
import com.sinapsis.subestacao.repository.RedeMTRepository;
import com.sinapsis.subestacao.repository.SubestacaoRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubestacaoService {

	@Autowired
	private final SubestacaoRepository subestacaoRepository;
	private final RedeMTRepository redeMTRepository;

	public SubestacaoService(SubestacaoRepository subestacaoRepository, RedeMTRepository redeMTRepository) {
		this.subestacaoRepository = subestacaoRepository;
		this.redeMTRepository = redeMTRepository;
	}

	@Transactional
	public SubestacaoResponseDTO criarSubestacao(SubestacaoCreateDTO subestacao) {
		var subestacaoModel = new SubestacaoModel();
		BeanUtils.copyProperties(subestacao, subestacaoModel);
		var subestacaoSalvo = subestacaoRepository.save(subestacaoModel);
		var subestacaoDTO = new SubestacaoResponseDTO(subestacaoSalvo);
		
		System.out.println(subestacaoSalvo.toString());
		if ( subestacao.getRedeMT() != null && !subestacao.getRedeMT().isEmpty() ) {
			for (RedeMTCreateDTO redeMT : subestacao.getRedeMT()) {
				var redeMTModel = new RedeMTModel();
	            BeanUtils.copyProperties(redeMT, redeMTModel);
	            redeMTModel.setIdSubestacao( subestacaoDTO.getIdSubestacao() );
				var redeMTSalvo = this.redeMTRepository.save(redeMTModel);
			}
		}
		
		return subestacaoDTO;
	}

	
	public SubestacaoResponseDTO cadastrar(SubestacaoCreateDTO dto) {
        SubestacaoModel sub = new SubestacaoModel();
        sub.setNome(dto.getNome());
        sub.setCodigo(dto.getCodigo());

        List<RedeMTModel> redes = dto.getRedeMT().stream().map(redeDTO -> {
            RedeMTModel rede = new RedeMTModel();
            rede.setCodigo(redeDTO.getCodigo());
            rede.setTensaoNominal(redeDTO.getTensaoNominal());
            //rede.setIdSubestacao(sub); // relacionamento bidirecional
            return rede;
        }).collect(Collectors.toList());

        //sub.setRedeMT(redes);

        SubestacaoModel saved = subestacaoRepository.save(sub);
        return new SubestacaoResponseDTO(saved);
    }
	
	
	public Optional<SubestacaoModel> getSubestacao(int id) {
		return subestacaoRepository.findById(id);
	}
	
	public List<SubestacaoModel> listaSubestacoes(){
		return subestacaoRepository.findAll();
	}
	
	public List<RedeMTModel> listaRedesMT(int idSubestacao){
		return this.redeMTRepository.findByIdSubestacao(idSubestacao);
	}

	public void deleteSubestacao(int id) {
		
		this.subestacaoRepository.deleteById(id);
		this.redeMTRepository.deleteByIdSubestacao(id);
	}
	
	public void deleteRedesMTSubestacao(int idRedeMT) {
		this.redeMTRepository.deleteById(idRedeMT);
	}
}
