package flightproject.service;

import flightproject.dao.UserDao;
import flightproject.dto.CreateUserDto;
import flightproject.exception.ValidationException;
import flightproject.mapper.CreateUserMapper;
import flightproject.validator.CreateUserValidator;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class UserService {

    public static final UserService INSTANCE = new UserService();

    private final CreateUserValidator createUserValidator = CreateUserValidator.getInstance();
    private final UserDao userDao = UserDao.getInstance();
    private final CreateUserMapper createUserMapper = CreateUserMapper.getInstance();


    public Integer create(CreateUserDto userDto) {

        var validationResult = createUserValidator.isValid(userDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }

        var userEntity = createUserMapper.mapFrom(userDto);
        userDao.save(userEntity);

        return userEntity.getId();

    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
