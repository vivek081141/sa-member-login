package org.sa.auth.repository;

import org.sa.auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * UserRepository
 * 
 */
@Repository
public class UserRepository {

    @Autowired
    private EntityManager em;


    public List<User> findByUsername(String username) {
        TypedQuery<User> q =
                em.createQuery("SELECT c FROM User c where c.username = :username", User.class);
        q.setParameter("username", username);
        return q.getResultList();
    }
}
