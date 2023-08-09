package vn.plantpal.mobile_backend.services;


import vn.plantpal.mobile_backend.dtos.UserDTO;
import vn.plantpal.mobile_backend.entities.Users;

import java.util.List;

public interface UserService {
    List<Users> getAll();
    UserDTO getOneById(String id);
    UserDTO create(UserDTO userDTO);
    UserDTO getOneByAccountId(String accountId);
    UserDTO update(UserDTO userDTO);
    void delete(String id);


}
