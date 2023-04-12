package br.com.ifba.modulologistica.usuario.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

import br.com.ifba.modulologistica.infrastructure.model.PersistenceEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;


@Entity
@Table(name = "usuario")
@Data
@EqualsAndHashCode(callSuper=false)
public class Usuario extends PersistenceEntity implements Serializable {
    
    public Usuario() {
    }

    @NonNull
    private String email;
    @NonNull
    private String senha;
    @NonNull
    private String nome;
    @NonNull
    private String telefone;
}
