package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.app.service.PlayerService;

@Controller
public class PlayerController {
public PlayerController() {
	System.out.println("in ctor of "+getClass());
}

@Autowired
private PlayerService playerService;

@RequestMapping("/team_details")
private String getAllPlayersByTeamId(Model map,@RequestParam Integer teamId,HttpSession session) {
	System.out.println("in players list "+teamId);
	session.setAttribute("teamId", teamId);
	map.addAttribute("player_list",playerService.getAllPlayersByTeamId(teamId));
	return "/team_details";
	
}
}
