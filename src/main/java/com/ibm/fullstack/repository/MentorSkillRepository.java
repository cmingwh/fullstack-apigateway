package com.ibm.fullstack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.fullstack.entity.MentorSkill;

@Repository
public interface MentorSkillRepository extends JpaRepository<MentorSkill, String> {

	List<MentorSkill> findByUserName(String userName);

	void deleteByUserName(String userName);
}