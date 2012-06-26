package br.com.dextra.common.persistence;

public interface BaseEntityRepository {

	public <T extends BaseEntity> T findByIdId(Class<T> clazz, Long id);

}
