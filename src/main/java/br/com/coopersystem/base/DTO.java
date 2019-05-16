package br.com.coopersystem.base;

public abstract class DTO<T extends Entidade> {

    public DTO(T t) {

    }

    public DTO() {

    }

    public abstract T toEntity();

}
