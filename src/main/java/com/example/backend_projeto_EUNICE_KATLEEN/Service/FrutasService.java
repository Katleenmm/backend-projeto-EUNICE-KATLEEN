package com.example.backend_projeto_EUNICE_KATLEEN.Service;

import com.example.backend_projeto_EUNICE_KATLEEN.Entities.Fruta;
import com.example.backend_projeto_EUNICE_KATLEEN.Entities.Nutrientes;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;

@Service
public class FrutasService {
    private RestTemplate cliente = new RestTemplate();
    private List<Fruta> frutasArmazenadas = new ArrayList<>();


    public List<Fruta> getFrutas() {
        Fruta[] frutas = cliente.getForObject("https://www.fruityvice.com/api/fruit/all", Fruta[].class);
        return Arrays.stream(frutas).toList();
    }

    public Fruta findFrutaByName(String name) {
        Fruta[] frutas = cliente.getForObject("https://www.fruityvice.com/api/fruit/all", Fruta[].class);
        for (Fruta fruta : frutas) {
            if (fruta.getName().equalsIgnoreCase(name)) {
                return fruta;
            }
        }
        return null;
    }

    public void addFruta(Fruta novaFruta) {
        frutasArmazenadas.add(novaFruta);
    }

    public Fruta buscarFrutaArmazenada(String name) {
        for (Fruta frutaArmazenada : frutasArmazenadas) {
            if (frutaArmazenada.getName() != null && frutaArmazenada.getName().equalsIgnoreCase(name)) {
                return frutaArmazenada;
            }
        }
        return null;
    }

    public List<Fruta> getFrutasArmazenadas() {
        return frutasArmazenadas;
    }

    public List<Fruta> getFrutasOrdenadasPorId() {
        return frutasArmazenadas.stream()
                .sorted(Comparator.comparing(Fruta::getId))
                .collect(Collectors.toList());
    }

    public List<Fruta> getFrutasOrdenadasMenosCaloricas() {
        return frutasArmazenadas.stream()
                .sorted(Comparator.comparingInt(fruta -> fruta.getNutrientes().getCalories()))
                .collect(Collectors.toList());
    }
}