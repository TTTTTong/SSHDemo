package DaoImpl;

import Dao.userDao;
import Entity.user;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.ArrayList;
import java.util.List;

public class userDaoImpl implements userDao {

    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate){
        this.hibernateTemplate = hibernateTemplate;
    }

    @Override
    public void save(user user){
        hibernateTemplate.save(user);
    }

    @Override
    public user getUser(String user) {
//        String hql = "from user u where u.name = '"+user+"'";
//        user user1 = (user)(this.hibernateTemplate.find(hql));
          user user1 = new user();
          return  user1;
    }

    @Override
    public void delete(int id) {
        //this.hibernateTemplate.delete(findById(id));
//        Session session = this.hibernateTemplate.getSessionFactory().openSession();
//        session.delete(findById(id));
//        session.flush();
//        session.close();
    }

    @Override
    public void update(user user) {
       //this.hibernateTemplate.update(user);
//        Session session = this.hibernateTemplate.getSessionFactory().openSession();
//        session.update(user);
//        session.flush();
//        session.close();
    }

    @Override
    public user findById(int id) {
        user user =(user) hibernateTemplate.get(user.class,id);
//        user user = (user)this.hibernateTemplate.get(user.class,id);
        return user;
    }

    @Override
    public List<user> findAll() {
//        String hql = "from user";
//        List<user> list= (List<user>) this.hibernateTemplate.find(hql);
        List<user> list = new ArrayList<>();
        return list;
    }
}
