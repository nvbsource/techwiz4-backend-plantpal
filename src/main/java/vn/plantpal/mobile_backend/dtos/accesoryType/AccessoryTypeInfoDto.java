package vn.plantpal.mobile_backend.dtos.accesoryType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import vn.plantpal.mobile_backend.entities.AccessoriesTypes;

import java.util.List;

@Data
//Make ignore null or empty fields when return json
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessoryTypeInfoDto {
    private String id;
    private String name;
    private String description;
    private String fatherTypeId;
    @JsonBackReference
    private List<AccessoryTypeInfoDto> childTypes;

    public static AccessoryTypeInfoDto fromAccessoriesTypes(AccessoriesTypes accessoriesTypes) {
        AccessoryTypeInfoDto accessoryTypeInfoDto = new AccessoryTypeInfoDto();
        accessoryTypeInfoDto.id = accessoriesTypes.getId();
        accessoryTypeInfoDto.name = accessoriesTypes.getName();
        accessoryTypeInfoDto.description = accessoriesTypes.getDescription();
        accessoryTypeInfoDto.fatherTypeId = accessoriesTypes.getFatherAccessoriesTypes() != null ? accessoriesTypes.getFatherAccessoriesTypes().getId() : null;
        if (accessoriesTypes.getAccessoriesTypesChild() != null && !accessoriesTypes.getAccessoriesTypesChild().isEmpty()) {
            accessoryTypeInfoDto.childTypes = accessoriesTypes.getAccessoriesTypesChild().stream()
                    .map(AccessoryTypeInfoDto::fromAccessoriesTypes)
                    .toList();
        }

        return accessoryTypeInfoDto;
    }
}
