package vn.plantpal.mobile_backend.services.implement;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.RoleDTO;
import vn.plantpal.mobile_backend.entities.Roles;
import vn.plantpal.mobile_backend.exceptions.AppException;
import vn.plantpal.mobile_backend.exceptions.DuplicateRecordException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.RoleRepository;
import vn.plantpal.mobile_backend.services.RoleService;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.util.List;
import java.util.Optional;

import static vn.plantpal.mobile_backend.utils.SD.ROLE;


@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public List<RoleDTO> getAll(){
        List<RoleDTO> rolesList = roleRepository.findAll().stream().map(r->EntityMapper.mapToDto(r,RoleDTO.class)).toList();
        if(rolesList.isEmpty()){
            throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR,"Role Data is empty");
        }
        return rolesList;
    }

    @Override
    public RoleDTO getOneByRoleType(String roleName) {
        return roleRepository.findByRoleType(roleName).map(r->EntityMapper.mapToDto(r,RoleDTO.class)).orElseThrow(()->new ResourceNotFoundException(ROLE,"role_name",roleName));
    }

    @Override
    public RoleDTO getOneById(String id) {
        return roleRepository.findById(id).map(r->EntityMapper.mapToDto(r,RoleDTO.class)).orElseThrow(() -> new ResourceNotFoundException(ROLE,"id",id));
    }

    @Override
    public RoleDTO getOne(String accountId) {
        return roleRepository.find(accountId).map(r->EntityMapper.mapToDto(r,RoleDTO.class)).orElseThrow(() -> new AppException(HttpStatus.BAD_REQUEST,"User Not Have Any Role"));
    }

    @Override
    public RoleDTO create(String roleType) {
        Optional<Roles> roleCheck = roleRepository.findByRoleType(roleType);
        roleCheck.ifPresent(r -> {
            throw new DuplicateRecordException("Role with name " + roleType + " already exists.");
        });
        Roles role = new Roles();
        role.setRoleType(roleType);
        return EntityMapper.mapToDto(roleRepository.save(role), RoleDTO.class);
    }



    @Override
    public void delete(String id) {
        Roles role = roleRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ROLE,"id",id));
        roleRepository.delete(role);
    }


}
