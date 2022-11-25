package com.sn.dtai.admin.service.mapper;

import com.sn.dtai.admin.domain.Localite;
import com.sn.dtai.admin.domain.TypeLocalite;
import com.sn.dtai.admin.service.dto.LocaliteDTO;
import com.sn.dtai.admin.service.dto.TypeLocaliteDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Localite} and its DTO {@link LocaliteDTO}.
 */
@Mapper(componentModel = "spring")
public interface LocaliteMapper extends EntityMapper<LocaliteDTO, Localite> {
    @Mapping(target = "localites", source = "localites", qualifiedByName = "localiteId")
    @Mapping(target = "typeLocalite", source = "typeLocalite", qualifiedByName = "typeLocaliteId")
    LocaliteDTO toDto(Localite s);

    @Named("localiteId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    LocaliteDTO toDtoLocaliteId(Localite localites);

    @Named("typeLocaliteId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TypeLocaliteDTO toDtoTypeLocaliteId(TypeLocalite typeLocalite);
}
