package vn.plantpal.mobile_backend.services;


import vn.plantpal.mobile_backend.dtos.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getAll();

    RoleDTO getOneByRoleType(String roleType);
    RoleDTO getOneById(String id);
    RoleDTO getOneByAccountId(String accountId);
    RoleDTO create(String roleType);
    void delete(String id);
}
