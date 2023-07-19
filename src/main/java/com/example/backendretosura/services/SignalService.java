package com.example.backendretosura.services;

import com.example.backendretosura.models.Signal;
import com.example.backendretosura.repositories.SignalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalService {


    @Autowired
    private SignalRepository repoSignal;

    public List<Signal> allSignals(){
        return  repoSignal.findAll();
    }

    public Signal findSignal(String id){
        return repoSignal.findById(id).orElse(null);
    }

    public Signal saveSignal(Signal signal){
        return repoSignal.save(signal);
    }

    public void deleteSignal(String id){
        repoSignal.deleteById(id);
    }

    public List<Signal> findByTitle(String title){
        return repoSignal.findByTitleContains(title);
    }




}
