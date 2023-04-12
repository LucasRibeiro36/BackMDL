package br.com.ifba.modulologistica.veiculo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ifba.modulologistica.infrastructure.model.RespostaModelo;
import br.com.ifba.modulologistica.veiculo.dao.IVeiculoDao;
import br.com.ifba.modulologistica.veiculo.exception.VeiculoExisteException;
import br.com.ifba.modulologistica.veiculo.exception.VeiculoNullException;
import br.com.ifba.modulologistica.veiculo.model.Veiculo;

@Service
public class VeiculoService implements IVeiculoService {

    @Autowired
    public IVeiculoDao veiculoDao;
    @Autowired
    public RespostaModelo rm;
    @Override
    public Veiculo saveVeiculo(Veiculo veiculo) {
        // salva o veículo
        Optional<Veiculo> veiculoExistente = veiculoDao.findByPlaca(veiculo.getPlaca());
        if(veiculoExistente.isPresent()) {
            throw new VeiculoExisteException();
        }
        if (veiculo.getPlaca() == null || veiculo.getMarca() == null || veiculo.getModelo() == null || veiculo.getDataFabricacao() == null || veiculo.getDataRevisao() == null) {
            throw new VeiculoNullException();
        }

        return veiculoDao.save(veiculo);
    }
    

    @Override
    public ResponseEntity<RespostaModelo> deleteVeiculo(Long id) {
        // deleta o veículo
        Optional<Veiculo> veiculoExistente = veiculoDao.findById(id);
        if(veiculoExistente.isPresent()) {
            veiculoDao.deleteById(id);
            rm.setMensagem("Veículo deletado com sucesso!");
            return ResponseEntity.ok(rm);
        }
        rm.setMensagem("Veículo não encontrado!");
        return ResponseEntity.ok(rm);
    }

    @Override
    public Veiculo updateVeiculo(Long id, Veiculo veiculo) {
        // atualiza o veículo
        Optional<Veiculo> veiculoExistente = veiculoDao.findById(id);
        if(veiculoExistente.isPresent()) {
            veiculo.setId(id);
            return veiculoDao.save(veiculo);
        }
        return veiculoExistente.orElseThrow(() -> new VeiculoNullException());
    }


    @Override
    public List<Veiculo> getAllVeiculo() {
        // obtem todos os veículos
        return veiculoDao.findAll();
    }


    @Override
    public Veiculo getByIdVeiculo(Long id) {
        // obtem o veículo pelo id
        Optional<Veiculo> veiculoExistente = veiculoDao.findById(id);
        if(veiculoExistente.isPresent()) {
            return veiculoExistente.get();
        }
        return veiculoExistente.orElseThrow(() -> new VeiculoNullException());
    }


    @Override
    public Veiculo getByPlacaVeiculo(String placa) {
        //obtem o veículo pela placa
        Optional<Veiculo> veiculoExistente = veiculoDao.findByPlaca(placa);
        if(veiculoExistente.isPresent()) {
            return veiculoExistente.get();
        }
        return veiculoExistente.orElseThrow(() -> new VeiculoNullException());
    }

    


}
