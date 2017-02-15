package io.egen.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.api.entity.Role;

@Repository
public class RoleRepositoryImpl implements RoleRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Role> findAll() {
		TypedQuery<Role> query = em.createNamedQuery("Role.findAll", Role.class);
		return query.getResultList();
	}
	
	@Override
	public Role findByName(String name) {
		TypedQuery<Role> query = em.createNamedQuery("Role.findByName", Role.class);
		query.setParameter("pName", name);

		List<Role> roles = query.getResultList();
		if (roles != null && roles.size() == 1) {
			return roles.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Role findOne(String id) {
		return em.find(Role.class, id);
	}

	@Override
	public Role create(Role role) {
		em.persist(role);
		return role;
	}

	@Override
	public Role update(Role role) {
		return em.merge(role);
	}

	@Override
	public void delete(Role role) {
		em.remove(role);
	}
}