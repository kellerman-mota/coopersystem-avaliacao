package br.com.coopersystem.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente extends Entidade<Long> {

}
