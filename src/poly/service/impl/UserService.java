package poly.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import poly.dto.UserDTO;
import poly.persistance.mapper.UserMapper;
import poly.service.IUserService;

@Service("UserService") //Controller의 Resource명 중 일치하는 이름을 찾기 위함
public class UserService implements IUserService {
	
	@Resource(name="UserMapper")
	private UserMapper userMapper;

	@Override
	public int userRegProc(UserDTO uDTO) throws Exception {
		return userMapper.userRegProc(uDTO);
	}

	@Override
	public UserDTO getLogin(UserDTO uDTO) throws Exception {
		return userMapper.getLogin(uDTO);
	}

}
