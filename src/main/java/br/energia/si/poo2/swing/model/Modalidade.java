package br.energia.si.poo2.swing.model;

public class Modalidade {
	
	private Integer idModalidade;
	private String descricaoModalidade;
	
	public Integer getIdModalidade() {
		return idModalidade;
	}
	public void setIdModalidade(Integer idModalidade) {
		this.idModalidade = idModalidade;
	}
	public String getdescricaoModalidade() {
		return descricaoModalidade;
	}
	public void setdescricaoModalidade(String descricaoModalidade) {
		this.descricaoModalidade = descricaoModalidade;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idModalidade == null) ? 0 : idModalidade.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modalidade other = (Modalidade) obj;
		if (idModalidade == null) {
			if (other.idModalidade != null)
				return false;
		} else if (!idModalidade.equals(other.idModalidade))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Modalidade [idModalidade=" + idModalidade
				+ ", descricaoModalidade=" + descricaoModalidade + "]";
	}
	
}
