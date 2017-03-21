package org.pasa.sispasa.cargapasa.enumeration;

/**
 *
 * @author Allan Garcia
 */

public enum EnumTipoRespPagamento {

	T("Titular"), 
	C("Curador"),
	U("Tutor");

	private String descricao;

	private EnumTipoRespPagamento(String descricao) {

		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
