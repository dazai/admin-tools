package tn.monjislim.office.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.monjislim.office.exceptions.ResourceNotFoundException;
import tn.monjislim.office.dao.IUserDao;
import tn.monjislim.office.entities.User;
import tn.monjislim.office.models.UserPrincipal;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = iUserDao.findByName(name).orElseThrow(() -> new ResourceNotFoundException("User", "name", name));
        return UserPrincipal.create(user);
    }
}
