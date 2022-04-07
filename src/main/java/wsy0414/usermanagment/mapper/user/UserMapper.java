package wsy0414.usermanagment.mapper.user;

import org.apache.ibatis.annotations.Mapper;

import wsy0414.usermanagment.entity.UserInfo;

@Mapper
public interface UserMapper {
    public UserInfo getUserByName(UserInfo userInfo);

    public UserInfo getUserById(int userId);

    public void insert(UserInfo userInfo);
}
