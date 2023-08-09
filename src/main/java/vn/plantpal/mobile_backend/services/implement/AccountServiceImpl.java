package vn.plantpal.mobile_backend.services.implement;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vn.plantpal.mobile_backend.dtos.AccountDTO;
import vn.plantpal.mobile_backend.entities.Accounts;
import vn.plantpal.mobile_backend.exceptions.DuplicateRecordException;
import vn.plantpal.mobile_backend.exceptions.ResourceNotFoundException;
import vn.plantpal.mobile_backend.repositories.AccountRepository;
import vn.plantpal.mobile_backend.services.AccountService;
import vn.plantpal.mobile_backend.utils.EntityMapper;

import java.util.List;

import static vn.plantpal.mobile_backend.utils.SD.ACCOUNT;


@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<AccountDTO> getAll() {
        return null;
    }

    @Override
    public AccountDTO getOneById(String id) {
        return accountRepository.findById(id).map(account -> EntityMapper.mapToDto(account, AccountDTO.class)).orElseThrow(()-> new ResourceNotFoundException("Account","id",id));
    }

    @Override
    public AccountDTO create(AccountDTO accounts) {
//        List<String> errorList = new ArrayList<>();
        String username = accounts.getUsername();
//        String password = accounts.getPassword();
        String roleId = accounts.getRoleId();
//
//        if(email.isEmpty()){
//            errorList.add("Email is required");
//        }else if(password.isEmpty()){
//            errorList.add("Password is required");
//        }
//        if(!errorList.isEmpty()){
//            throw new AppException(HttpStatus.BAD_REQUEST,errorList.toString());
//        }
        accountRepository.findByUsername(username)
                .ifPresent(account -> {
                    throw new DuplicateRecordException("Account", "username", username);
                });

        Accounts newAccount = Accounts.builder()
                .username(accounts.getUsername())
                .isDeleted(false)
                .password(passwordEncoder.encode(accounts.getPassword()))
                .roleId(roleId)
                .build();
        return EntityMapper.mapToDto(accountRepository.save(newAccount), AccountDTO.class);
    }

    @Override
    public AccountDTO getOneByEmail(String email) {
        return accountRepository
                .findByUsername(email)
                .map(account -> EntityMapper.mapToDto(account,AccountDTO.class))
                .orElseThrow(()->new ResourceNotFoundException("Email not exists"));
    }

    @Override
    public AccountDTO getOneByUsername(String username) {
        return accountRepository
                .findByUsername(username)
                .map(account -> EntityMapper.mapToDto(account,AccountDTO.class))
                .orElseThrow(()->new ResourceNotFoundException("Username not exists"));
    }

    @Override
    @Transactional
    public AccountDTO update(AccountDTO account) {
        String accountId = account.getId();
        Accounts currentAccount = accountRepository.findById(accountId).orElseThrow(() -> new ResourceNotFoundException(ACCOUNT,"id",accountId));
        currentAccount.setUsername(account.getUsername() == null ? currentAccount.getUsername() : account.getUsername());
        currentAccount.setGoogleId(account.getGoogleId() == null ? currentAccount.getGoogleId() : account.getGoogleId());
        currentAccount.setPassword(account.getPassword() == null ? currentAccount.getPassword() : passwordEncoder.encode(account.getPassword()));
        currentAccount.setRoleId(account.getRoleId() == null ? currentAccount.getId() : account.getId());
        return EntityMapper.mapToDto(accountRepository.save(currentAccount), AccountDTO.class);
    }

    @Override
    public void delete(String id) {
        Accounts accounts = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ACCOUNT,"id",id));
        accounts.setIsDeleted(true);
        accountRepository.save(accounts);
    }

    @Override
    public AccountDTO getOneByGoogleId(String googleId) {
        return accountRepository.findByGoogleId(googleId).map(account -> EntityMapper.mapToDto(account, AccountDTO.class) ).orElse(null);
    }
}
