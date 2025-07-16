package com.springboot.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.techhub.model.Users_Master;

@Repository
public interface Users_Master_Repository extends JpaRepository<Users_Master, Long>{

	Users_Master findByUsername(String username);
	@Modifying
	@Query(value = "EXECUTE Role_code_Decider",nativeQuery = true)
	public void executeRole_code_Decider();
}
