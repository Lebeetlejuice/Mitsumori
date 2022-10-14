package com.example.Mistumori.dao;

import com.example.Mistumori.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class UserDataAccessService implements UserDAO{
    private final JdbcTemplate jdbcTemplate;

    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertUser(Integer id, User user) {
        return 0;
    }

    @Override
    public List<User> selectAllPeople() {
        final String SQL = "SELECT * FROM person";
        List<User> people = jdbcTemplate.query(SQL, (resulSet, i) -> {
                    Integer id = Integer.valueOf(resulSet.getString("id"));
                    String name = resulSet.getString("name");
                    String surname = resulSet.getString("surname");
                    return new User(id,name,surname);
        });
        return people;
       //return List.of(new User(UUID.randomUUID(), "FROM POSTGRES DB"));
    }

    @Override
    public Optional<User> selectPersonById(Integer id) {
        final String sql = "SELECT * From person WHERE id = ?";

        User user = jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                (resultSet, i) -> {
                    Integer id1 = Integer.valueOf(resultSet.getString("id"));
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");
                    return new User(id1,name,surname);
                });
        return Optional.ofNullable(user);
    }

    @Override
    public int deletePersonById(Integer id) {
        return 0;
    }

    @Override
    public int updatePersonById(Integer id, User newUser) {
        return 0;
    }
}
