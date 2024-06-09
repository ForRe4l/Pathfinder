package com.example.Pathfinder.service;

import com.example.Pathfinder.model.Pictures;
import com.example.Pathfinder.model.Route;
import com.example.Pathfinder.repo.RouteRepository;
import com.example.Pathfinder.service.DTO.RouteShortDTO;
import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {

    private RouteRepository routeRepository;
    private ModelMapper modelMapper;
    private Random random;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;

        this.modelMapper = new ModelMapper();
        this.random = new Random();
    }
    @Transactional
    public List<RouteShortDTO> allRoutes(){
        return routeRepository.findAll()
                .stream()
                .map(this :: mapToShortDTO)
                .toList();
    }
    @Transactional
    public RouteShortDTO getRandomRoute() {
        long routeCount = routeRepository.count();

        long randomId = random.nextLong(routeCount) + 1;


        Optional<Route> route = routeRepository.findById(randomId);

        if(route.isEmpty()){
            //throw exception!
        }
        RouteShortDTO dto = modelMapper.map(route.get(), RouteShortDTO.class);

        Optional<Pictures> pictures= route.get().getPictures().stream().findFirst();

        dto.setImageUrl(pictures.get().getUrl());
        return dto;
    }


    private RouteShortDTO mapToShortDTO (Route route){
        RouteShortDTO dto = modelMapper.map(route, RouteShortDTO.class);

        Optional<Pictures> pictures = route.getPictures().stream().findFirst();

        dto.setImageUrl(pictures.get().getUrl());

        return dto;
    }
}
