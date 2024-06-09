package com.example.Pathfinder.web;


import com.example.Pathfinder.service.DTO.RouteShortDTO;
import com.example.Pathfinder.service.RouteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RouteController {

    private static final Logger log = LoggerFactory.getLogger(RouteController.class);
    private RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/routes")
    public String route(Model model){

        List<RouteShortDTO> routes = routeService.allRoutes();

        model.addAttribute("allRoutes", routes);

        return "routes";
    }
}
