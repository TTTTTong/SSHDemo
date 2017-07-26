package DaoImpl;

import Dao.userDao;
import Entity.user;
import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

public class userDaoImpl implements userDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate = hibernateTemplate;
    }

    public void save(user user){
        this.hibernateTemplate.save(user);
    }

    @Override
    public user getUser(String user) {
        String hql = "from user u where u.name = '"+user+"'";
        user user1 = (user)(this.hibernateTemplate.find(hql));
        return  user1;
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
    public List<?> findAll(String username) {
//        String quert = "from uesr";
//        Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
//        List<user> list = session.
        String hql = "from user u where u.name = '"+username+"'";
//        List<user> list = (user)(this.hibernateTemplate.find(hql));
        List<?> list= this.hibernateTemplate.find(hql);
        return list;
    }
}
