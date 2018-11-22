package com.chatting.DAOs;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class MessageDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	
}
