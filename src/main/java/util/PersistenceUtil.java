package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static EntityManagerFactory factory;

    public static EntityManagerFactory createEntityManagerFactory(String str){
        if (PersistenceUtil.factory == null){
            factory = Persistence.createEntityManagerFactory(str);
        }
        return factory;
    }
}
