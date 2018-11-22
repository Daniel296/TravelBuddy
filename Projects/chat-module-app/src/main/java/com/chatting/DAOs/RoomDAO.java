package com.chatting.DAOs;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.chatting.models.Room;
import com.chatting.utils.Globals;

@Repository
@Transactional
public class RoomDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Room> findAllUsersRooms(long userId){
		List<?> userRooms = null;
		
		try {
			userRooms = entityManager
					.createQuery("FROM Room r WHERE r.user.userProfileId = :userId")
					.setParameter("userId", userId)
					.getResultList();
		}catch(Exception e) {
			Globals.LOGGER.info("ROOM DAO ------ findAllUsersRooms(long userId) ------- userId doesn't exists");
		}
		
		return (List<Room>)userRooms;
	}
}
