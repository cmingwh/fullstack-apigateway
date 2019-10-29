package com.ibm.fullstack.utils;

import javax.servlet.http.HttpServletRequest;

import com.ibm.fullstack.dto.UserDtl;
import com.ibm.fullstack.entity.User;

import io.jsonwebtoken.Jwts;

public class Utils {
	public static String getJwtFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer")) {
            return token.replace("Bearer ", "");
        }
        return null;
    }
	
	public static String getUserIdFromJwt(String token, String signKey) {
        return Jwts.parser().setSigningKey(signKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

	public static UserDtl convertUserDto(User user) {
		UserDtl userDtl = new UserDtl();
		userDtl.setActive(user.getActive());
		userDtl.setContactNumber(user.getContactNumber());
		userDtl.setUserId(user.getUserId());
		userDtl.setUserName(user.getUserName());
		userDtl.setFirstName(user.getFirstName());
		userDtl.setLastName(user.getLastName());
		userDtl.setLinedinUrl(user.getLinedinUrl());
		userDtl.setRoles(user.getRoles());
		userDtl.setYearsOfExperience(user.getYearsOfExperience());
		userDtl.setTimezone(user.getTimezone());
		userDtl.setFacilities(user.getFacilities());
		userDtl.setExamples(user.getExamples());
		userDtl.setIntroduction(user.getIntroduction());
		userDtl.setSkills(user.getSkills());
		return userDtl;
	}
}
