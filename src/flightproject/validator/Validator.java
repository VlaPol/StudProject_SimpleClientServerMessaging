package flightproject.validator;

public interface Validator<T> {

    ValidationResult isValid(T object);
}
