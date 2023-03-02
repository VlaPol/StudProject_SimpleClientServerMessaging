package flightproject.validator;

import flightproject.dto.CreateUserDto;
import flightproject.entity.Gender;
import flightproject.util.LocalDateFormatter;

public class CreateUserValidator implements Validator<CreateUserDto> {

    public static final CreateUserValidator INSTANCE= new CreateUserValidator();

    @Override
    public ValidationResult isValid(CreateUserDto object) {

        var validationResult = new ValidationResult();

        if(!LocalDateFormatter.isValid(object.getBirthday())){
            validationResult.add(Error.of("invalid birthday", "Birthday is invalid"));
        }

        if(Gender.find(object.getGender()).isEmpty()){
            validationResult.add(Error.of("invalid gender", "Gender is invalid"));
        }

        return validationResult;
    }

    public static CreateUserValidator getInstance(){
        return INSTANCE;
    }

}
