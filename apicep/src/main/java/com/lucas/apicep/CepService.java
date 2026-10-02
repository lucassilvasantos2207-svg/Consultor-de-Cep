package com.lucas.apicep;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CepService {

    private final RestTemplate restTemplate = new RestTemplate();

    public Endereco buscar(String cep) {
        String limpo = cep.replaceAll("\\D", "");

        if (limpo.length() != 8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "CEP deve ter 8 dígitos");
        }

        Endereco endereco = restTemplate.getForObject(
                "https://viacep.com.br/ws/" + limpo + "/json/", Endereco.class);

        if (endereco == null || Boolean.TRUE.equals(endereco.erro())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CEP não encontrado");
        }

        return endereco;
    }
}