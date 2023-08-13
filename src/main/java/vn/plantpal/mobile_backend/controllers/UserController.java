package vn.plantpal.mobile_backend.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import vn.plantpal.mobile_backend.dtos.AuthUserDTO;
import vn.plantpal.mobile_backend.dtos.UserDTO;
import vn.plantpal.mobile_backend.dtos.user.UserUpdateDTO;
import vn.plantpal.mobile_backend.securities.CustomUserDetails.CustomUserDetails;
import vn.plantpal.mobile_backend.services.users.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/getUserInfo")
    public ResponseEntity<UserDTO> getUserInfo(Authentication authentication){
        AuthUserDTO user = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
        return ResponseEntity.ok(userService.getOneById(user.getUserID()));
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> update(@Valid @RequestBody UserUpdateDTO data, Authentication authentication){
        AuthUserDTO user = ((CustomUserDetails) authentication.getPrincipal()).getAuthUser();
        return ResponseEntity.ok(userService.update(data, user.getUserID()));
    }
    @GetMapping ("/getAllUsers")
    ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping("/getUserInfo/{userId}")
    public ResponseEntity<UserDTO> getUserDetail(@RequestParam("userId") String userId){
        return ResponseEntity.ok(userService.getOneById(userId));
    }
}
