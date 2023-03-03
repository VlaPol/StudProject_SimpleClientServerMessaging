package flightproject.mapper;

import flightproject.dto.CreateUserDto;
import flightproject.entity.Gender;
import flightproject.entity.Role;
import flightproject.entity.User;
import flightproject.util.LocalDateFormatter;

public class CreateUserMapper implements Mapper<CreateUserDto, User> {

    private static final CreateUserMapper INSTANCE = new CreateUserMapper();
    private static final String IMAGE_FOLDER = "users/";

    @Override
    public User mapFrom(CreateUserDto object) {
        return User.builder()
                .name(object.getName())
                .image(IMAGE_FOLDER + object.getImage().getSubmittedFileName())
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
