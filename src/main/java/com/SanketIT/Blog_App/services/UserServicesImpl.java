package com.SanketIT.Blog_App.services;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SanketIT.Blog_App.excepation.ResourcesNotFoundExcepation;
import com.SanketIT.Blog_App.model.Users;
import com.SanketIT.Blog_App.payloads.UsersDto;
import com.SanketIT.Blog_App.repositories.UserRepository;

@Service
public class UserServicesImpl implements UserServicesI {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public UsersDto createUser(UsersDto usersDto) {

		Users users = this.userDtoToUser(usersDto);
		Users saveUser = this.userRepository.save(users);

		UsersDto usersDto2 = this.usersTousersDto(saveUser);
		return usersDto2;
	}

	@Override
	public UsersDto updateUser(UsersDto usersDto, Integer id) {
		// Users users = this.userDtoToUser(usersDto);
		Optional<Users> users = this.userRepository.findById(id);
		// find the all date present in that Id
		Users users2 = users.get();
		if (users.isPresent()) {
			users2.setName(usersDto.getName());
			users2.setEmail(usersDto.getEmail());
			users2.setPassword(usersDto.getPassword());
			users2.setAbout(usersDto.getAbout());

			// save this update data in data base
			Users updateData = this.userRepository.save(users2);
			UsersDto updateDataDto = this.usersTousersDto(updateData);
			return updateDataDto;
		} else {
			throw new ResourcesNotFoundExcepation("Data not found");
		}
	}

	@Override
	public UsersDto getUserById(Integer id) {
		Optional<Users> findById = this.userRepository.findById(id);
		Users users = findById.get();
		UsersDto users2 = this.usersTousersDto(users);
		return users2;
	}

	@Override
	public List<UsersDto> getAllUser() {
		List<Users> AllUsers = this.userRepository.findAll();
		// use java 8
		List<UsersDto> DtoUsers = AllUsers.stream().map(user -> this.usersTousersDto(user))
				.collect(Collectors.toList());
		return DtoUsers;

		// we can use for each loop also
	}

	@Override
	public void deleteUserById(Integer id) {
		// first find Id using findByid method
		Users finduser = this.userRepository.findById(id)
				.orElseThrow(() -> new ResourcesNotFoundExcepation("Given id not found"));

		this.userRepository.delete(finduser);

	}

	// convert usersDto data into users
	public Users userDtoToUser(UsersDto usersDto) {
		Users users = modelMapper.map(usersDto,Users.class);
		
//		u.setId(usersDto.getId());
//		u.setName(usersDto.getName());
//		u.setEmail(usersDto.getEmail());
//		u.setPassword(usersDto.getPassword());
//		u.setAbout(usersDto.getAbout());
		return users;

	}

	public UsersDto usersTousersDto(Users users) {
		UsersDto usersDto = this.modelMapper.map(users, UsersDto.class);
		
//		  usersDto.setId(users.getId()); usersDto.setName(users.getName());
//		  usersDto.setEmail(users.getEmail());
//		  usersDto.setPassword(users.getPassword());
//		  usersDto.setAbout(users.getAbout());
		 
		return usersDto;

	}

}
