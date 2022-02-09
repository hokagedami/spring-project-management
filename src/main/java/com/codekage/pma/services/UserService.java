package com.codekage.pma.services;


import com.codekage.pma.dao.IUserRepository;
import com.codekage.pma.dto.UserOut;
import com.codekage.pma.entities.UserAccount;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final BCryptPasswordEncoder bCryptPasswordEncoder;
    final IUserRepository userRepository;
    final ModelMapper modelMapper;

    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, IUserRepository userRepository, ModelMapper modelMapper) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserOut RegisterUser(UserAccount userAccount) {
        userAccount.setPassword(bCryptPasswordEncoder.encode(userAccount.getPassword()));
        userRepository.save(userAccount);
        return modelMapper.map(userAccount, UserOut.class);
    }
}
