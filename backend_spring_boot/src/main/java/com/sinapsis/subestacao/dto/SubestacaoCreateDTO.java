package com.sinapsis.subestacao.dto;

import com.sinapsis.subestacao.model.SubestacaoModel;
import java.util.List;

public class SubestacaoCreateDTO {
	
	private int idSubestacao;

	private String codigo;
	
	private String nome;
	
	private double latitude;
	
	private double longitude;
	
	private List<RedeMTCreateDTO> redeMT;
	
	
	public SubestacaoCreateDTO(SubestacaoModel subestacaoModel) {
		this.codigo = subestacaoModel.getCodigo();
		this.nome = subestacaoModel.getNome();
		this.latitude = subestacaoModel.getLatitude();
		this.longitude = subestacaoModel.getLongitude();
	}
	

	public SubestacaoCreateDTO() {
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


	public double getLatitude() {
		return latitude;
	}


	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public List<RedeMTCreateDTO> getRedeMT() {
		return redeMT;
	}


	public void setRedeMT(List<RedeMTCreateDTO> redeMT) {
		this.redeMT = redeMT;
	}

}
