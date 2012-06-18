package br.com.dextra.common.persistence;

public interface EntidadeRepository {

	public <T extends Entidade> T buscarPorId(Class<T> classe, Long id);

}
