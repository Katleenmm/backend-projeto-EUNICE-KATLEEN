package com.example.backend_projeto_EUNICE_KATLEEN.Service;

import com.example.backend_projeto_EUNICE_KATLEEN.Entities.Fruta;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class FrutasService {
    private RestTemplate cliente = new RestTemplate();

    public List<Fruta> getFrutas() {
        Fruta[] frutas = cliente.getForObject("https://www.fruityvice.com/api/fruit/all", Fruta[].class);
        return Arrays.stream(frutas).toList();
    }

    public Fruta findFrutaByName(String name) {
        Fruta[] frutas = cliente.getForObject("https://www.fruityvice.com/api/fruit/all", Fruta[].class);
        for (Fruta fruta : frutas) {
            if (fruta.getName().equals(name)) {
                return fruta;
            }
        }
        return null;
    }
}