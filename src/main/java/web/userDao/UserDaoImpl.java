package web.userDao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
@Transactional(readOnly = false)
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void deleteUser(User user) {
        User us = entityManager.find(User.class, user.getId());
        entityManager.persist(us);
        entityManager.remove(us);
        entityManager.flush();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();

    }

    @Override
    public void changeUser(User user) {
        User us = entityManager.find(User.class, user.getId());
        entityManager.persist(us);
        us.setId(user.getId());
        us.setName(user.getName());
        us.setLastName(user.getLastName());
        entityManager.flush();


    }
}
