package com.example.ejerciciojenkins.Controlador;


import com.example.ejerciciojenkins.Service.YoutubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MusicController {
    private final YoutubeService youTubeService;



    @GetMapping("/search")
    public List<String> searchMusic(@RequestParam String query) {
        try {
            return youTubeService.searchVideos(query);
        } catch (IOException e) {
            e.printStackTrace();
            return List.of("Error: Unable to search videos.");
        }
    }


    @GetMapping("/hola")
    public String hola(){
        return "Hola como estan";
    }

    @GetMapping("/holamundo")
    public String holamundo(){
        return "Hola como estan mundo";
    }


}
