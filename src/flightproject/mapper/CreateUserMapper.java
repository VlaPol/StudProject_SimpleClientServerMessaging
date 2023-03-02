package flightproject.mapper;

import flightproject.dto.CreateUserDto;
import flightproject.entity.Gender;
import flightproject.entity.Role;
import flightproject.entity.User;
import flightproject.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .birthday(LocalDateFormatter.format(object.getBirthday()))
                .email(object.getEmail())
                .password(object.getPassword())
                .role(Role.valueOf(object.getRole()))
                .gender(Gender.valueOf(object.getGender()))
                .build();

    }

    public static CreateUserMapper getInstance(){
        return INSTANCE;
    }
}
