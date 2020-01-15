package br.com.examplo.clinica.repository.query.impl;

import java.util.Objects;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;

import br.com.examplo.clinica.domain.DomainEntity;
import br.com.examplo.clinica.repository.query.IQueryFactoryHelper;

@Repository
public class QueryFactoryHelperImpl implements IQueryFactoryHelper {

	private final EntityManager entityManager;

	private final JPQLQueryFactory queryFactory;

	@Inject
	public QueryFactoryHelperImpl(final EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
		queryFactory = new JPAQueryFactory(entityManager);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JPQLQueryFactory factory() {
		return queryFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T extends DomainEntity> T save(final T entityObj) {
		if (Objects.nonNull(entityObj)) {
			if (Objects.isNull(entityObj.getId())) {
				entityManager.persist(entityObj);
				return entityObj;
			} else {
				return entityManager.merge(entityObj);
			}
		}
		return entityObj;
	}
}
