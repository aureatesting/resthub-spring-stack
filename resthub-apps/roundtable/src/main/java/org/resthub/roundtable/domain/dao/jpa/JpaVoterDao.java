package org.resthub.roundtable.domain.dao.jpa;

import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.resthub.core.domain.dao.jpa.GenericJpaResourceDao;
import org.resthub.roundtable.domain.dao.VoterDao;
import org.resthub.roundtable.domain.model.Poll;
import org.resthub.roundtable.domain.model.Voter;

/**
 * {@inheritDoc}
 */
@Named("voterDao")
public class JpaVoterDao extends GenericJpaResourceDao<Voter> implements VoterDao {

    @Override
    public Voter findByNameAndPoll(String name, Poll poll) {
        final Query query = getEntityManager().createNamedQuery("findVoterByNameAndPoll");
        query.setParameter("name", name);
        query.setParameter("poll", poll);

        try{
            return (Voter) query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }
}