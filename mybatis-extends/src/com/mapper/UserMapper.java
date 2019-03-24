package com.mapper;

import com.domain.User;

import java.util.List;

public interface UserMapper {

    public void save(User u);
    public void update(User u);
    public void delete(Long id);
    public User get(Long id);
    public List<User> listAll();
}
