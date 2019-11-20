package com.ibm.fullstack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.fullstack.dto.UserDtl;
import com.ibm.fullstack.entity.MentorSkill;
import com.ibm.fullstack.entity.User;
import com.ibm.fullstack.repository.MentorSkillRepository;
import com.ibm.fullstack.repository.UserRepository;
import com.ibm.fullstack.utils.Utils;

@Service("userService")
public class UserService {
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
    private MentorSkillRepository mentorSkillRepository;
	
//	@Autowired
//    private RoleRepository roleRepository;
	
//	@Autowired
//    private UserRoleMapRepository userRoleRepository;
	
	public UserDtl findUserDtlByUserName(String userName) {
		User user = userRepository.findByUserName(userName);
		return Utils.convertUserDto(user);
	}
	
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName);
	}
	
	public boolean existsUserName(String userName) {
		UserDtl user = this.findUserDtlByUserName(userName);
		return user != null;
	}

	public UserDtl save(User user) {
		User user0 = userRepository.save(user);
		return Utils.convertUserDto(user0);
	}

	public void saveSkills(List<MentorSkill> skills) {
		mentorSkillRepository.saveAll(skills);
	}

	public void deleteSkills(String userName) {
		mentorSkillRepository.deleteByUserName(userName);
	}
	
}
