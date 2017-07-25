package DaoImpl;

import Dao.userDao;
import Entity.user;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

public class userDaoImpl implements userDao {

    private HibernateTemplate hibernateTemplate;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }

    public void save(user user){
        this.hibernateTemplate.save(user);
    }

    @Override
    public user getUser(String user) {
        String hql = "from user u where u.name = '"+user+"'";
        user result = (user)((Query)this.hibernateTemplate.find(hql)).uniqueResult();
        return  result;
    }

    @Override
    public void delete(int id) {
        this.hibernateTemplate.delete(findById(id));
    }

    @Override
    public void update(user user) {
        this.hibernateTemplate.update(user);
    }

    @Override
    public user findById(int id) {
        user user = (user)this.hibernateTemplate.get(user.class,id);
        return user;
    }

    @Override
    public List<user> findAll() {
        String query = "from user";
        List<user> list = new ArrayList<>();
        //List<user> list = this.hibernateTemplate.find(query);
        return list;
    }
}
