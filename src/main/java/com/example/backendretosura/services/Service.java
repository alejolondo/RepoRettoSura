package com.example.backendretosura.services;

import com.example.backendretosura.models.Category;
import com.example.backendretosura.repositories.CategoryRepository;
import com.example.backendretosura.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return  categoryRepository.findAll();
    }


}
