package com.ibm.fullstack.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.fullstack.dto.UserDtl;
import com.ibm.fullstack.entity.AuthParameters;
import com.ibm.fullstack.entity.MentorSkill;
import com.ibm.fullstack.entity.User;
import com.ibm.fullstack.service.UserService;
import com.ibm.fullstack.utils.Utils;

@RestController
@CrossOrigin
@RequestMapping("/info")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthParameters authParameters;
    
    @GetMapping(value = "")
    public UserDtl getUser(HttpServletRequest request) {
    	String token = Utils.getJwtFromRequest(request);
    	if (token != null) {
            String userName = Utils.getUserIdFromJwt(token, authParameters.getJwtTokenSecret());
            return userService.findUserDtlByUserName(userName);
    	}
		return null;
    }
    
    @Transactional
    @PostMapping(value = "/saveMentor")
    public String saveMentor(@RequestBody User  user) {
    	User useDtl = userService.findByUserName(user.getUserName());
    	if(useDtl != null) {
    		List<MentorSkill> skills = user.getSkills();
    		if(skills != null && skills.size() > 0) {
    			userService.deleteSkills(user.getUserId());
    			userService.saveSkills(skills);
    		}
    		useDtl.setContactNumber(user.getContactNumber());
    		useDtl.setFirstName(user.getFirstName());
    		useDtl.setLastName(user.getLastName());
    		useDtl.setTimezone(user.getTimezone());
    		useDtl.setFacilities(user.getFacilities());
    		useDtl.setExamples(user.getExamples());
    		useDtl.setYearsOfExperience(user.getYearsOfExperience());
    		useDtl.setIntroduction(user.getIntroduction());
    		useDtl.setLinedinUrl(user.getLinedinUrl());
    		return userService.save(useDtl) == null ? "{\"result\": \"failed\"}" : "{\"result\": \"success\"}";
    	}else {
    		return "{\"result\": \"exists\"}";
    	}
    }
}