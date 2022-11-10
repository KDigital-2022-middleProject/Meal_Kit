package dao.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import dto.User;

@Repository
public interface UserMapper {

	@Insert("insert into User "
     + " (email, password,name,tel,address,authority)"
+ " values(#{email}, #{password},#{name},#{tel},#{address},#{authority})")
	void insert(User user);
 
	@Select("select * from User where email=#{email}")
	User selectOne(Map<String, Object> param);

}
