package dao.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import dto.CartList;

@Repository
public interface CartMapper {
	
	@Select("select c.id, c.itemCode, c.email, c.quantity,"
			+ "i.item, i.price, i.file_name from Cart c "
			+ "inner join Item i on c.itemCode = i.itemCode where c.email=#{email}")
	List<CartList> selectCart(String email);
	
	@Delete("delete from Cart where id = #{id} and email=#{email}")
	void deleteCart(Map<String, Object> param);

}
