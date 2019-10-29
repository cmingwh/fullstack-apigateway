package com.ibm.fullstack.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mentor_skills", schema = "fullstack")
@IdClass(MentorSkillPK.class)
public class MentorSkill {

	@Id
	@Column(name="user_id")
	private Long userId;
	
	@Id
	@Column(name="skill_id")
	private Long skillId;
	
	@Column(name="level")
	private Integer level;
}
