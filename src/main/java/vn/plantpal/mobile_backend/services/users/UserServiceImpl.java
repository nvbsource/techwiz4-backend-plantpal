package vn.plantpal.mobile_backend.services.users;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.UserDTO;
import vn.plantpal.mobile_backend.dtos.user.UserUpdateDTO;
import vn.plantpal.mobile_backend.entities.Accounts;
import vn.plantpal.mobile_backend.entities.Users;
import vn.plantpal.mobile_backend.exceptions.AppException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.exceptions.UserNotFoundException;
import vn.plantpal.mobile_backend.repositories.UserRepository;
import vn.plantpal.mobile_backend.services.accounts.AccountService;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.util.List;

import static vn.plantpal.mobile_backend.utils.SD.ACCOUNT;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final AccountService accountService;
    private final UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntityMapper entityMapper;
    @Override
    public List<UserDTO> getAll() {
        return entityMapper.mapList(userRepository.findAll(), UserDTO.class);
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
                .account(accounts)
                .isDeleted(false)
                .build();
        return EntityMapper.mapToDto(userRepository.save(user),UserDTO.class);
    }


    @Override
    public UserDTO getOne(String accountId) {
        Users person = userRepository.find(accountId).orElseThrow(() -> new ResourceNotFoundException(ACCOUNT,"account_id",accountId));
        return EntityMapper.mapToDto(person, UserDTO.class);
    }

    @Override
    public UserDTO update(UserUpdateDTO data, String id) {
        Users userFound = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        modelMapper.map(data, userFound);
        userRepository.save(userFound);
        return modelMapper.map(userFound, UserDTO.class);
    }
}
