package vn.plantpal.mobile_backend.services.user;


import vn.plantpal.mobile_backend.dtos.UserDTO;
import vn.plantpal.mobile_backend.dtos.user.UserUpdateDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAll();
    UserDTO getOneById(String id);
    UserDTO create(UserDTO userDTO);
    UserDTO getOne(String accountId);
    UserDTO update(UserUpdateDTO data, String id);
}
