package dev.naimsulejmani.grupi2bookcheckmark.mappers;

public interface BasicMapper<DTO, ENTITY> {
    DTO toDto(ENTITY entity);
    ENTITY toEntity(DTO dto);
}
