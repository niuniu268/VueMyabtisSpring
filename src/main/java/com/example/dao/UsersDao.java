package com.example.dao;

import com.example.pojo.Users;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsersDao {
    @Select( "select * from users;" )
    public List<Users> selectAll();
}
