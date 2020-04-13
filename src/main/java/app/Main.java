package app;

import entity.AlbumsEntity;
import entity.ArtistsEntity;
import repo.AlbumRepository;
import repo.ArtistRepository;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main (String[] args){
        ArtistsEntity e = new ArtistsEntity();
        e.setId(1);
        e.setCountry("USA");
        e.setName("Red");
        ArtistRepository.create(e);
        ArtistsEntity e2 = new ArtistsEntity();
        e2.setId(2);
        e2.setCountry("USA");
        e2.setName("Skillet");
        ArtistRepository.create(e2);

        AlbumsEntity a = new AlbumsEntity();
        a.setArtistId(1);
        a.setId(1);
        a.setName("Legendary");
        a.setReleaseYear(2010);
        AlbumRepository.create(a);
        AlbumsEntity a2 = new AlbumsEntity();
        a2.setArtistId(1);
        a2.setId(2);
        a2.setName("Victorious");
        a2.setReleaseYear(2019);
        AlbumRepository.create(a2);

        System.out.println(ArtistRepository.findById(1).getName());
        for (AlbumsEntity ae : AlbumRepository.findByArtist(e)){
            System.out.println(e.getName() + ":" + ae.getName());
        }
    }
}
