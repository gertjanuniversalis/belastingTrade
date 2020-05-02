package Entities.DAO;

import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.logging.Logger;

public abstract class DAOBase {
//    private Logger logger = (Logger) LoggerFactory.getLogger(DAOBase.class);
    private EntityManager em;

    protected EntityManager manager(){
        if(em==null){
            em = Persistence.createEntityManagerFactory("belastingtrade").createEntityManager();
        }
        return em;
    }
}
