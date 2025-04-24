package com.sinapsis.subestacao.model;

import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_rede_mt")
public class RedeMTModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_rede_mt")
	private int idRedeMT;
	
	//@ManyToOne
    //@JoinColumn(name = "subestacao_id")
    //private SubestacaoModel idSubestacao;
	
	@Column(name="id_subestacao")
	private int idSubestacao;
	
	private String codigo;
	
	private String nome;
	
	@Column(name="tensao_nominal")
	private double tensaoNominal;


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
