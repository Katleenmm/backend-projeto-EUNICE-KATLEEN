package com.example.backend_projeto_EUNICE_KATLEEN.Controller;
import com.example.backend_projeto_EUNICE_KATLEEN.Entities.Fruta;
import com.example.backend_projeto_EUNICE_KATLEEN.Entities.Sobre;
import com.example.backend_projeto_EUNICE_KATLEEN.Service.FrutasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FrutasController {
    @Autowired
    private FrutasService frutasService;

    @GetMapping("/frutas")
    public List<Fruta> getFrutas() {
        return frutasService.getFrutas();
    }

    @GetMapping("/frutas/{name}")
    public Fruta findFrutaByName(@PathVariable String name){
        return frutasService.findFrutaByName(name);
    }

    @GetMapping("/sobre")
    public Sobre getSobre(){
        return new Sobre();
    }

}
