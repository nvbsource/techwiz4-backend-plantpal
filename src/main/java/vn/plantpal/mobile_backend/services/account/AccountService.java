package vn.plantpal.mobile_backend.services.account;



import vn.plantpal.mobile_backend.dtos.AccountDTO;

import java.util.List;

public interface AccountService {
    List<AccountDTO> getAll();
    AccountDTO getOneById(String id);
    AccountDTO create(AccountDTO accountDTO);
    AccountDTO getOneByEmail(String email);
    AccountDTO getOneByUsername(String username);
    AccountDTO update(AccountDTO accountDTO);
    void delete(String id);

    AccountDTO getOneByGoogleId(String googleId);
}
