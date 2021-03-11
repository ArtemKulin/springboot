package ru.kulinartem.springboot.service;

import org.springframework.stereotype.Service;
import ru.kulinartem.springboot.entity.User;

import java.util.List;

@Service
public interface UserService {

    public User getItemById(long id) throws Exception;

    public List<User> getAllItems();

    public void saveItem(User item);

    public void deleteItem(User item);

    public void updateItem(User item, long id) throws UserException;

    public User getItemByEmail(String email);
}
