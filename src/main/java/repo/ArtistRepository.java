package repo;

import entity.ArtistsEntity;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class ArtistRepository {
    public static void create(ArtistsEntity e){
        EntityManager em = PersistenceUtil.createEntityManagerFactory("MusicAlbumsPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    public static ArtistsEntity findById (Object e){
        EntityManager em = PersistenceUtil.createEntityManagerFactory("MusicAlbumsPU").createEntityManager();
        em.getTransaction().begin();
        ArtistsEntity al = em.find(ArtistsEntity.class, e);
        em.getTransaction().commit();
        em.close();
        return al;
    }

    public static List<ArtistsEntity> findByName(String query){
        EntityManager em = PersistenceUtil.createEntityManagerFactory("MusicAlbumsPU").createEntityManager();
        em.getTransaction().begin();
        List lst = PersistenceUtil.createEntityManagerFactory("MusicAlbumsPU").createEntityManager()
                .createNamedQuery("ArtistsEntity.findByName").setParameter("name", query).getResultList();
        em.getTransaction().commit();
        em.close();
        return lst;
    }
}
