package Entities.DAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public abstract class DAOBase {
    private EntityManager em;

    protected EntityManager manager(){
        if(em==null){
            em = Persistence.createEntityManagerFactory("belastingtrade").createEntityManager();
        }
        return em;
    }
}
