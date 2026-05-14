package br.com.rafaellbarros.shared.mapper;

import java.util.List;

public interface BaseMapper<M, D> {

    D toDTO(M model);

    M toDomain(D dto);

    List<D> toDTO(List<M> models);

    List<D> toDTO(Iterable<M> models);

    List<M> toDomain(List<D> dtos);

}