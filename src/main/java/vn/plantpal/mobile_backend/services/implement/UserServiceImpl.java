package vn.plantpal.mobile_backend.services.implement;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.AccountDTO;
import vn.plantpal.mobile_backend.dtos.UserDTO;
import vn.plantpal.mobile_backend.entities.Accounts;
import vn.plantpal.mobile_backend.entities.Users;
import vn.plantpal.mobile_backend.exceptions.AppException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.exceptions.UserNotFoundException;
import vn.plantpal.mobile_backend.repositories.UserRepository;
import vn.plantpal.mobile_backend.services.AccountService;
import vn.plantpal.mobile_backend.services.UserService;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.util.List;

import static vn.plantpal.mobile_backend.utils.SD.ACCOUNT;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final AccountService accountService;
    private final UserRepository userRepository;
    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(u -> EntityMapper.mapToDto(u, UserDTO.class)).toList();
    }

    @Override
    public UserDTO getOneById(String id) {
        Users users =  userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
        return EntityMapper.mapToDto(users, UserDTO.class);
    }

    @Override
    @Transactional
    public UserDTO create(UserDTO userDTO) {
        String accountId = userDTO.getAccountId();
        if(accountId == null){
            throw new AppException(HttpStatus.BAD_REQUEST,"AccountID is required");
        }
        Accounts accounts = EntityMapper.mapToEntity(accountService.getOneById(accountId), Accounts.class);
        Users user = Users.builder()
                .fullName(userDTO.getFullName())
                .email(userDTO.getEmail())
                .address(userDTO.getAddress())
                .phone(userDTO.getPhone())
                .avatar(userDTO.getAvatar())
                .gender(userDTO.getGender())
                .dob(userDTO.getDob())
                .accountsByAccountId(accounts)
                .isDeleted(false)
                .build();
        return EntityMapper.mapToDto(userRepository.save(user),UserDTO.class);
    }





    @Override
    public UserDTO getOneByAccountId(String accountId) {
        Users person = userRepository.findByAccountId(accountId).orElseThrow(() -> new ResourceNotFoundException(ACCOUNT,"account_id",accountId));
        return EntityMapper.mapToDto(person, UserDTO.class);
    }

    @Override
    @Transactional
    public UserDTO update(UserDTO userDTO) {
        return null;
    }

    @Override
    @Transactional
    public void delete(String id) {

    }


}
