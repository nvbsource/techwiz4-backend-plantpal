package vn.plantpal.mobile_backend.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class EntityMapper {
    private static final ModelMapper modelMapper = new ModelMapper();
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }
    public static <S,D> D mapToDto(S source, Class<D> destinationClass){
        return modelMapper.map(source,destinationClass);
    }

    public static <S,D> D mapToEntity(S source, Class<D> destinationClass){
        return modelMapper.map(source,destinationClass);
    }
}
