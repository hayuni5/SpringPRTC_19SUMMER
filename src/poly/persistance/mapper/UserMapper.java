package poly.persistance.mapper;

import config.Mapper;
import poly.dto.UserDTO;

@Mapper("UserMapper") //Service의 어노테이션Resource명 중 일치하는 이름을 찾기 위함
public interface UserMapper {

	int userRegProc(UserDTO uDTO) throws Exception;

	UserDTO getLogin(UserDTO uDTO) throws Exception;

	
}
