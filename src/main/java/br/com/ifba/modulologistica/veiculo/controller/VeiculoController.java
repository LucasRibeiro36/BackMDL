package br.com.ifba.modulologistica.veiculo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import br.com.ifba.modulologistica.veiculo.service.VeiculoService;
import br.com.ifba.modulologistica.infrastructure.model.RespostaModelo;
import br.com.ifba.modulologistica.veiculo.model.Veiculo;

@RestController
@RequestMapping("/api")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;
    
    @GetMapping("/veiculos")
    public List<Veiculo> readVeiculos() {
        // retorna todos os veiculos
        return veiculoService.getAllVeiculo();
    }

    @GetMapping(value="/veiculo/id/{id}")
    public Veiculo getByIdVeiculo(@PathVariable("id") long id) {
        // retorna um veiculo pelo id
        return veiculoService.getByIdVeiculo(id);
    }

    @GetMapping(value="/veiculo/placa/{placa}")
    public Veiculo getByPlacaVeiculo(@PathVariable("placa") String placa) {
        // retorna um veiculo pela placa
        return veiculoService.getByPlacaVeiculo(placa);
    }

    @PostMapping("/veiculo")
    public Veiculo createVeiculo(Veiculo veiculo) {
        // salva um veiculo
        return veiculoService.saveVeiculo(veiculo);
    }

    @PutMapping("/veiculo/id/{id}")
    public Veiculo updateVeiculo(@PathVariable("id") long id, Veiculo veiculo) {
        // atualiza um veiculo
        return veiculoService.updateVeiculo(id, veiculo);
    }

    @DeleteMapping("/veiculo/id/{id}")
    public ResponseEntity<RespostaModelo> deleteVeiculo(@PathVariable("id") long id) {
        // deleta um veiculo
        return veiculoService.deleteVeiculo(id);
    }
    
}
