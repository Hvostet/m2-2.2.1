package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarDaoImpl implements CarDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserByCar(String zaprosModel, int zaprosSeries) {
        User user = (User) sessionFactory
                .getCurrentSession()
                .createQuery("from User where car.model=:zaprosModel and car.series=:zaprosSeries")
                .setParameter("zaprosModel", zaprosModel)
                .setParameter("zaprosSeries", zaprosSeries)
                .getSingleResult();
        return user;
    }
}
