package com.sinapsis.subestacao.dto;

import com.sinapsis.subestacao.model.RedeMTModel;

public class RedeMTResponseDTO {
	
	private int idRedeMT;
	
	private int idSubestacao;
	
	private String codigo;
	
	private String nome;
	
	private double tensaoNominal;
	
	public RedeMTResponseDTO(RedeMTModel redeMTModel) {
		this.idRedeMT = redeMTModel.getIdRedeMT();
		this.idSubestacao = redeMTModel.getIdSubestacao();
		this.codigo = redeMTModel.getCodigo();
		this.nome = redeMTModel.getNome();
		this.tensaoNominal = redeMTModel.getTensaoNominal();
	}	

	public RedeMTResponseDTO() {
	}


	public int getIdRedeMT() {
		return idRedeMT;
	}

	public void setIdRedeMT(int idRedeMT) {
		this.idRedeMT = idRedeMT;
	}

	public int getIdSubestacao() {
		return idSubestacao;
	}

	public void setIdSubestacao(int idSubestacao) {
		this.idSubestacao = idSubestacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getTensaoNominal() {
		return tensaoNominal;
	}

	public void setTensaoNominal(double tensaoNominal) {
		this.tensaoNominal = tensaoNominal;
	}
	
	

}
