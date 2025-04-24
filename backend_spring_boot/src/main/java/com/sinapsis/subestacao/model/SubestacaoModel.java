package com.sinapsis.subestacao.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_subestacao")
public class SubestacaoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_subestacao")
	private int idSubestacao;
	
	private String codigo;
	
	private String nome;
	
	private double latitude;
	
	private double longitude;
	
	//@OneToMany(mappedBy = "idSubestacao", cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<RedeMTModel> redeMT;


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

	
	@Override
	public String toString() {
		return "SubestacaoModel [idSubestacao=" + idSubestacao + ", codigo=" + codigo + ", nome=" + nome + ", latitude="
				+ latitude + ", longitude=" + longitude + ", ]";
	}

	
	
}
