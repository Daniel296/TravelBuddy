package com.travel.buddy.coreproject.repository;

import com.travel.buddy.coreproject.model.ChatHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ChatHistoryRepository extends JpaRepository<ChatHistory, Serializable> {

}
