package flightproject.dao;

import flightproject.entity.User;
import flightproject.util.ConnectionManager;
import lombok.SneakyThrows;


import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class UserDao implements Dao<Integer, User> {

    public static final UserDao INSTANCE = new UserDao();

    public static final String SAVE_SQL = "INSERT INTO users (name, birthday, email, password, role, gender)" +
                                          " VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    @SneakyThrows
    public User save(User entity) {

        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SAVE_SQL, RETURN_GENERATED_KEYS)) {

            preparedStatement.setObject(1, entity.getName());
            preparedStatement.setObject(2, entity.getBirthday());
            preparedStatement.setObject(3, entity.getEmail());
            preparedStatement.setObject(4, entity.getPassword());
            preparedStatement.setObject(5, entity.getRole().name());
            preparedStatement.setObject(6, entity.getGender().name());

            preparedStatement.executeUpdate();

            // create and generated new id for new entity


            List<String> resultSetsId = new ArrayList<>();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                resultSetsId.add(rs.getString(1));
            }
            entity.setId(Integer.parseInt(resultSetsId.get(resultSetsId.size()-1)));

            return entity;
        }

    }

    public static UserDao getInstance() {
        return INSTANCE;
    }

}
