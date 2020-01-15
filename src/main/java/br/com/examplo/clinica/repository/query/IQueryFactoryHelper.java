package br.com.examplo.clinica.repository.query;

import com.querydsl.jpa.JPQLQueryFactory;

import br.com.examplo.clinica.domain.DomainEntity;

public interface IQueryFactoryHelper {

	JPQLQueryFactory factory();

	<T extends DomainEntity> T save(final T entityObj);
}
