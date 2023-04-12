package br.com.ifba.modulologistica.veiculo.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.context.annotation.RequestScope;

import br.com.ifba.modulologistica.veiculo.model.Veiculo;

@RequestScope
public interface IVeiculoDao extends JpaRepository<Veiculo, Long> {
    
    // find by placa
    Optional<Veiculo> findByPlaca(String placa);
  
}
