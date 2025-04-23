package com.example.infrastructure.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
} 