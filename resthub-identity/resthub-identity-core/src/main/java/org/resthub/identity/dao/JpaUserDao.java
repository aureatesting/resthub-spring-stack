package org.resthub.identity.dao;

import java.util.List;
import javax.inject.Named;
import javax.persistence.Query;

import org.resthub.core.dao.GenericJpaResourceDao;
import org.resthub.identity.model.User;
import org.resthub.identity.model.Group;

/**
 * The JpaUserDao class is based on both {@link GenericJpaResourceDao} and
 * {@link UserDao}<br/>
 * 
 * It is a bean whose name is userDao
 * */
@Named("userDao")
public class JpaUserDao extends GenericJpaResourceDao<User> implements UserDao {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getUsersFromGroup(String groupName) {
        String queryString = "select u from " + this.getDomainClass().getName() + " u JOIN "
                + Group.class.getName() + " g where g.name=:groupName";
        Query q = this.getEntityManager().createQuery(queryString);
        q.setParameter("groupName", groupName);
        return q.getResultList();
    }
}
