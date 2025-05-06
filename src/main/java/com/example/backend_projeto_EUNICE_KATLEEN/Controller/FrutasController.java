package com.example.backend_projeto_EUNICE_KATLEEN.Controller;
import com.example.backend_projeto_EUNICE_KATLEEN.Entities.Fruta;
import com.example.backend_projeto_EUNICE_KATLEEN.Entities.Nutrientes;
import com.example.backend_projeto_EUNICE_KATLEEN.Entities.Sobre;
import com.example.backend_projeto_EUNICE_KATLEEN.Service.FrutasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frutas")
public class FrutasController {
    @Autowired
    private FrutasService frutasService;

    @GetMapping
    public List<Fruta> getFrutas() {
        return frutasService.getFrutas();
    }

    @GetMapping("/{name}")
    public Fruta findFrutaByName(@PathVariable String name){
        return frutasService.findFrutaByName(name);
    }

    @GetMapping("/sobre")
    public Sobre getSobre(){
        return new Sobre();
    }

    @PostMapping
    public ResponseEntity<Fruta> addFruta(@RequestBody Fruta novaFruta){
        frutasService.addFruta(novaFruta);
        return new ResponseEntity<>(novaFruta, HttpStatus.CREATED);
    }

    @GetMapping("/armazenadas")
    public List<Fruta> getFrutasArmazenadas() {
        return frutasService.getFrutasArmazenadas();
    }

    @GetMapping("/armazenadas/ordenadas")
    public List<Fruta> getFrutasOrdenadas(){
        return frutasService.getFrutasOrdenadasPorId();
    }

    @GetMapping("armazenadas/menoscaloricas")
    public List<Fruta> getFrutasOrdenadasMenosCaloricas(){
        return frutasService.getFrutasOrdenadasMenosCaloricas();
    }

}
