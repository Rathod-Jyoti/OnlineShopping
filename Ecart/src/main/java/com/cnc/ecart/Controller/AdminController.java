package com.cnc.ecart.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.ecart.model.Admin;
import com.cnc.ecart.service.AdminService;

@RestController
public class AdminController 
{
	@Autowired 
	private AdminService adminService;
	
	@PostMapping("/admin-login")
	public String adminLogin(@RequestBody Admin admin)
	{
		if(adminService.loginAdmin(admin)>0)
		{
			return "success";
		}
		else {
			return "unsuccess";
		}

    }
}
