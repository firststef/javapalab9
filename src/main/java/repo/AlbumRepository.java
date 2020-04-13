package repo;

import entity.AlbumsEntity;
import entity.ArtistsEntity;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class AlbumRepository {

    public static void create(AlbumsEntity e){
        EntityManager em = PersistenceUtil.createEntityManagerFactory("MusicAlbumsPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
    }

    public static AlbumsEntity findById (Object e){
        EntityManager em = PersistenceUtil.createEntityManagerFactory("MusicAlbumsPU").createEntityManager();
        em.getTransaction().begin();
        AlbumsEntity al = em.find(AlbumsEntity.class, e);
        em.getTransaction().commit();
        em.close();
        return al;
    }

    public static List<AlbumsEntity> findByName(String query){
        EntityManager em = PersistenceUtil.createEntityManagerFactory("MusicAlbumsPU").createEntityManager();
        em.getTransaction().begin();
        List lst = PersistenceUtil.createEntityManagerFactory("MusicAlbumsPU").createEntityManager()
                .createNamedQuery("AlbumsEntity.findByName").setParameter("name", query).getResultList();
        em.getTransaction().commit();
        em.close();
        return lst;
    }

    public static List<AlbumsEntity> findByArtist(ArtistsEntity e){
        EntityManager em = PersistenceUtil.createEntityManagerFactory("MusicAlbumsPU").createEntityManager();
        em.getTransaction().begin();
        List lst = PersistenceUtil.createEntityManagerFactory("MusicAlbumsPU").createEntityManager()
                .createNamedQuery("AlbumsEntity.findById").setParameter("id", e.getId()).getResultList();
        em.getTransaction().commit();
        em.close();
        return lst;
    }
}
