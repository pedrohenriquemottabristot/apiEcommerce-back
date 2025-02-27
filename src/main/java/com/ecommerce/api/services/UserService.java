package com.ecommerce.api.services;

import com.ecommerce.api.dto.UserDTO;
import com.ecommerce.api.entities.User;
import com.ecommerce.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id));
        return new UserDTO(user.getName(), user.getPassword(), user.getEmail(), user.getPhone(), user.getRoles());
    }

    @Transactional(readOnly = true)
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user : users) {
            userDTOS.add(new UserDTO(user.getName(), user.getPassword(), user.getEmail(), user.getPhone(), user.getRoles()));
        }
        return userDTOS;
    }

    @Transactional
    public UserDTO create(UserDTO dto) {
        User user = new User(dto.getName(), dto.getPassword(), dto.getEmail(), dto.getPhone(), dto.getRoles());
        User savedUser = userRepository.save(user);
        return new UserDTO(savedUser.getName(), savedUser.getPassword(), savedUser.getEmail(), savedUser.getPhone(), savedUser.getRoles());
    }

    @Transactional
    public UserDTO update(Long id, UserDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id));
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setRoles(dto.getRoles());
        // A senha também deve ser atualizada, se necessário
        user.setPassword(dto.getPassword());
        User updatedUser = userRepository.save(user);
        return new UserDTO(updatedUser.getName(), updatedUser.getPassword(), updatedUser.getEmail(), updatedUser.getPhone(), updatedUser.getRoles());
    }

    @Transactional
    public void delete(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado com o id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(UserDTO::new)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id));
    }
}
