package com.prx.project.library.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prx.project.library.dao.StaffDAO;
import com.prx.project.library.model.Staff;
import com.prx.project.library.utils.EncrytedPasswordUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private StaffDAO staffDao; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Staff appUser = staffDao.getStaffByUser(username);
		
		if (appUser == null) {
            System.out.println("User not found! " + username);
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
		
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		
		grantList.add(new SimpleGrantedAuthority("USER"));
		
		UserDetails userDetails = new User(appUser.getEmail(), EncrytedPasswordUtils.encrytePassword(appUser.getPassword()), grantList);

		return userDetails;
	}
	
}
