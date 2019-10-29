package com.ibm.fullstack.dto;

import java.util.List;

import com.ibm.fullstack.entity.MentorSkill;
import com.ibm.fullstack.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDtl {
	private Long userId;
	private String userName;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String regCode;
	private List<Role> roles;
	private String linedinUrl;
	private Float yearsOfExperience;
	private Boolean active = false;
	private Boolean confirmedSignUp = false;
	private String timezone;
	private String introduction;
	private String facilities;
	private String examples;
	private List<MentorSkill> skills;
}
