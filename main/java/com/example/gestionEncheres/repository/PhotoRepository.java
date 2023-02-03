package com.example.gestionEncheres.repository;

import com.example.gestionEncheres.models.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends MongoRepository<Photo,String> {
    Photo findPhotoByIdEnchere(Integer idEnchere);
}
