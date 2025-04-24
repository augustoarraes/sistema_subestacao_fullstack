package com.sinapsis.subestacao.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinapsis.subestacao.dto.RedeMTResponseDTO;
import com.sinapsis.subestacao.dto.SubestacaoCreateDTO;
import com.sinapsis.subestacao.dto.SubestacaoResponseDTO;
import com.sinapsis.subestacao.model.RedeMTModel;
import com.sinapsis.subestacao.model.SubestacaoModel;
import com.sinapsis.subestacao.service.SubestacaoService;

@RestController
@RequestMapping("/subestacao")
public class SubestacaoController {

	private final SubestacaoService subestacaoService;

	public SubestacaoController(SubestacaoService subestacaoService) {
		this.subestacaoService = subestacaoService;
	}

	@PostMapping
	public ResponseEntity<SubestacaoResponseDTO> criarSubestacao(@RequestBody SubestacaoCreateDTO subestacao) {
		return ResponseEntity.status(HttpStatus.CREATED).body( this.subestacaoService.criarSubestacao(subestacao) );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getSubestacao(@PathVariable int id) {
		Optional<SubestacaoModel> subestacaoModel = this.subestacaoService.getSubestacao(id);
		if (!subestacaoModel.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Subestacao não encontrada!");
		}
		SubestacaoResponseDTO response = new SubestacaoResponseDTO(  subestacaoModel.get());
		return ResponseEntity.status(HttpStatus.OK).body( response );
	}
	
	@GetMapping("/{id}/redesMT")
	public ResponseEntity<List<RedeMTResponseDTO>> getRedesMTSubestacao(@PathVariable int id){
		List<RedeMTModel> redesMT = this.subestacaoService.listaRedesMT(id);
		return ResponseEntity.status(HttpStatus.OK).body( redesMT.stream().map(RedeMTResponseDTO::new).toList() );
	}
	
	@GetMapping
	public ResponseEntity<List<SubestacaoResponseDTO>> listaSubestacao(){
		return ResponseEntity.status(HttpStatus.OK).body( this.subestacaoService.listaSubestacoes().stream()
	            .map(SubestacaoResponseDTO::new) // usando o construtor direto
	            .toList() );
	}

	@PutMapping
	public ResponseEntity<SubestacaoResponseDTO> alterarSubestacao(@RequestBody SubestacaoCreateDTO subestacao) {
		return ResponseEntity.status(HttpStatus.OK).body( this.subestacaoService.criarSubestacao(subestacao) );
	}

	@DeleteMapping("/{id}")
	public void deleteSubestacao(@PathVariable int id) {
		this.subestacaoService.deleteSubestacao(id);
	}
	
	@DeleteMapping("/redesMT/{idRedeMT}")
	public void deleteRedesMTSubestacao(@PathVariable int idRedeMT) {
		this.subestacaoService.deleteRedesMTSubestacao(idRedeMT);
	}

	@GetMapping("/home")
	public String index() {
		return "It's work!";
	}

}
