package kr.hansung.medibugiback.controller;

import kr.hansung.medibugiback.domain.Hospital;
import kr.hansung.medibugiback.dto.FavoriteRequestDto;
import kr.hansung.medibugiback.repository.FavoriteRepository;
import kr.hansung.medibugiback.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*",maxAge = 3600)
@RestController
@RequiredArgsConstructor
@RequestMapping("/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;


    @PostMapping("/add")
    public boolean addFavorite(@RequestBody FavoriteRequestDto favoriteRequestDto){
        return favoriteService.addFavorite(favoriteRequestDto);
    }
    @PostMapping("/delete")
    public boolean deleteFavorite(@RequestBody FavoriteRequestDto favoriteRequestDto){
        return favoriteService.deleteFavorite(favoriteRequestDto);
    }

    @GetMapping("/getFavoriteList")
    public List<Hospital> getFavoriteList(@RequestParam("member_id")String member_id){
        return favoriteService.getFavoriteList(member_id);
    }

}
