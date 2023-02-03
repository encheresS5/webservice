package com.example.gestionEncheres.service;

import com.example.gestionEncheres.models.Photo;
import com.example.gestionEncheres.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {
    @Autowired(required=true)
    PhotoRepository photoRepository;

    public List<Photo> findAll(){
        return photoRepository.findAll();
    }

    public void save(Photo photo){
        photoRepository.save(photo);
    }

    public Photo getPhotoByIdEnchere(Integer idEnchere){
        return photoRepository.findPhotoByIdEnchere(idEnchere);
    }
}
