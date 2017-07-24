package DaoImpl;

import Dao.userDao;
import Entity.user;
import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;
import java.util.List;

public class userDaoImpl implements userDao {
    private HibernateTemplate hibernateTemplate;
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    public void save(user user){
        this.getHibernateTemplate().save(user);
    }

    @Override
    public user getUser(String user) {
        String hql = "from user u where u.name = '"+user+"'";
        user result = (user)((Query)this.getHibernateTemplate().find(hql)).uniqueResult();
        return  result;
    }

    @Override
    public void delete(int id) {
        this.getHibernateTemplate().delete(findById(id));
    }

    @Override
    public void update(user user) {
        this.getHibernateTemplate().update(user);
    }

    @Override
    public user findById(int id) {
        user user = (user)this.getHibernateTemplate().get(user.class,id);
        return user;
    }

    @Override
    public List<user> findAll() {
        String query = "from user";
        List<user> list = this.getHibernateTemplate().find(query);
        return list;
    }
}
