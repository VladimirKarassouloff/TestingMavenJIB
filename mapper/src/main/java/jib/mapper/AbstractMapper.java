package jib.mapper;

import com.joanzapata.mapper.Hook;
import com.joanzapata.mapper.Mapper;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractMapper<ENTITY, DTO> {

    protected Mapper mapper;
    protected Class<ENTITY> clazzEntityReference;
    protected Class<DTO> clazzDTOReference;

    public AbstractMapper(Class<ENTITY> clazz1, Class<DTO> clazz2) {
        mapper = new Mapper()
                .strictMode(true)
                .hook(new Hook<ENTITY, DTO>() {
                    @Override
                    public void extraMapping(ENTITY source, DTO dest) {
                        extraMappingToDTO(source, dest);
                    }
                })
                .hook(new Hook<DTO, ENTITY>() {
                    @Override
                    public void extraMapping(DTO source, ENTITY dest) {
                        extraMappingToEntity(source, dest);
                    }
                });
    }


    public abstract void extraMappingToEntity(DTO dto, ENTITY entity);

    public abstract void extraMappingToDTO(ENTITY entity, DTO dto);

    public DTO toDTO(ENTITY entity) {
        return mapper.map(entity, clazzDTOReference);
    }

    public ENTITY toEntity(DTO dto) {
        return mapper.map(dto, clazzEntityReference);
    }

    public List<DTO> toDtoList(Collection<ENTITY> entities) {
        if (entities != null) {
            return entities.stream().map(this::toDTO).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public Set<DTO> toDtoSet(Collection<ENTITY> entities) {
        if (entities != null) {
            return entities.stream().map(this::toDTO).collect(Collectors.toSet());
        } else {
            return new HashSet<>();
        }
    }

}
