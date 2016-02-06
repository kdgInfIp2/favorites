package be.kdg.prog4.tddOld;

public interface UserDao {
    public void create(User user);

    public User getUser(String username);
}
