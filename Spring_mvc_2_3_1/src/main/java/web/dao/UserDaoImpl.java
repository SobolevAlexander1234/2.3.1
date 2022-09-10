package web.dao;

import org.springframework.stereotype.Repository;

import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getListUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void updateUserById(int id, User upUser) {
        User anotherUser = findUserById(id);

        anotherUser.setName(upUser.getName());
        anotherUser.setSekondName(upUser.getSekondName());
        anotherUser.setAge(upUser.getAge());
        entityManager.merge(anotherUser);
    }

    @Override
    public void removeUserById(int id) {
        entityManager.remove(findUserById(id));
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class, id);
    }
}
