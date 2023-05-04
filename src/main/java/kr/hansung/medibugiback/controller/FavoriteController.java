package kr.hansung.medibugiback.controller;

import kr.hansung.medibugiback.repository.FavoriteRepository;
import kr.hansung.medibugiback.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*",maxAge = 3000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/favorite")
public class FavoriteController {
    private final FavoriteService favoriteService;


    @PostMapping("/add")
    public boolean addFavorite(@RequestParam("hoscnt") Long hoscnt, @RequestParam("member_id") String member_id){
        return favoriteService.addFavorite(hoscnt,member_id);
    }
    @PostMapping("/delete")
    public boolean deleteFavorite(@RequestParam("hoscnt") Long hoscnt, @RequestParam("member_id") String member_id){
        return favoriteService.deleteFavorite(hoscnt,member_id);
    }

    @GetMapping("/getFavoriteList")
    public JSONArray getFavoriteList(@RequestParam("member_id")String member_id){
        return favoriteService.getFavoriteList(member_id);
    }

}
