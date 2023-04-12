package br.com.ifba.modulologistica.veiculo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.ifba.modulologistica.infrastructure.model.RespostaModelo;
import br.com.ifba.modulologistica.veiculo.model.Veiculo;

public interface IVeiculoService {

    // Salva o veículo.
    public abstract Veiculo saveVeiculo(Veiculo veiculo);
    // Deleta veículo.
    public abstract ResponseEntity<RespostaModelo> deleteVeiculo(Long id);
    // Atualiza o veículo.
    public abstract Veiculo updateVeiculo(Long id, Veiculo veiculo);
    // Método que retorna todos os veículos da base de dados.
    public abstract List<Veiculo> getAllVeiculo();
    // método que retorna um veículo pelo id.
    public abstract Veiculo getByIdVeiculo(Long id);
    // Método que retorna um veículo pela placa.
    public abstract Veiculo getByPlacaVeiculo(String placa);

}
