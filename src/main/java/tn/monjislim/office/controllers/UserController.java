package tn.monjislim.office.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.monjislim.office.configuration.CurrentUser;
import tn.monjislim.office.dao.IUserDao;
import tn.monjislim.office.entities.User;
import tn.monjislim.office.exceptions.ResourceNotFoundException;
import tn.monjislim.office.models.UserPrincipal;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserDao iUserDao;

    @GetMapping("/me")
    public ResponseEntity<?> getProfile(@CurrentUser UserPrincipal userPrincipal){
        User user = iUserDao.findById(userPrincipal.getId()).orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
        return ResponseEntity.status(200).body(user);
    }

}
