package br.com.ifba.modulologistica.veiculo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.ifba.modulologistica.infrastructure.model.PersistenceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "veiculo")
@Data
@EqualsAndHashCode(callSuper=false)
public class Veiculo extends PersistenceEntity implements Serializable {
    
    public Veiculo() {}
    private String placa;
    private String modelo;
    private String marca;
    private Date dataFabricacao;
    private Date dataRevisao;

}
