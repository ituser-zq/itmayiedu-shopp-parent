package com.itmayiedu.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itmayiedu.entity.UserEntity;

@Mapper
public interface MemberDao {

	@Select("select  id,username,password,phone,email,created,updated ,openid from mb_user where id =#{userId}")
	UserEntity findByID(@Param("userId") Long userId);

	@Insert("INSERT  INTO `mb_user`  (username,password,phone,email,created,updated) VALUES (#{username}, #{password},#{phone},#{email},#{created},#{updated});")
	Integer insertUser(UserEntity userEntity);

	@Select("select  id,username,password,phone,email,created,updated ,openid from mb_user where username=#{username} and password=#{password}")
	UserEntity login(@Param("username") String username, @Param("password") String password);
	@Select("select  id,username,password,phone,email,created,updated ,openid from mb_user where openid =#{openid}")
	UserEntity findByOpenIdUser(@Param("openid") String openid);
	@Update("update mb_user set openid=#{openid} where id=#{userId}")
    Integer updateByOpenIdUser(@Param("openid") String openid,@Param("userId") Integer userId);
}
