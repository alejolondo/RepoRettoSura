package com.example.backendretosura.controlllers;

import com.example.backendretosura.models.Category;
import com.example.backendretosura.models.Signal;
import com.example.backendretosura.services.Service;
import com.example.backendretosura.services.SignalService;
import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.SourcesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.response.SourcesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class SignalController {

@Autowired
private SignalService serviceSignal;

@Autowired
private Service service;


@GetMapping("/signals")
public ResponseEntity<List<Signal>> getSignals(){

    List<Signal> signals = serviceSignal.allSignals();
    return new ResponseEntity<>(signals, HttpStatus.OK);
}


@GetMapping("/signals/{id}")
public ResponseEntity<Signal> findSignalById(@PathVariable("id") String id){
    Signal signal = serviceSignal.findSignal(id);
    return new ResponseEntity<>(signal, HttpStatus.OK);
}


@PostMapping("/signals/{query}")
public ResponseEntity<Void> saveSignal(@PathVariable("query") String query){



    NewsApiClient newsApiClient = new NewsApiClient("6b0d3571b57441efa7d17c55ba788c5f");

    //Implementación país
    newsApiClient.getSources(
            new SourcesRequest.Builder()
                    .language("es")
                    .country("co")
                    .build(),
            new NewsApiClient.SourcesCallback() {
                @Override
                public void onSuccess(SourcesResponse response) {
                    newsApiClient.getEverything(
                            new EverythingRequest.Builder()
                                    .q(query)
                                    .language("es")
                                    .build(),
                            new NewsApiClient.ArticlesResponseCallback() {
                                @Override
                                public void onSuccess(ArticleResponse response) {

                                    int index = 0;


                                    while (index < response.getArticles().size()) {
                                        String title = response.getArticles().get(index).getTitle();


                                        List<Signal> isTitle = serviceSignal.findByTitle(title);
                                        if (isTitle.isEmpty()) {

                                            Signal signal = new Signal();
                                            signal.setTitle(title);
                                            signal.setDescription(response.getArticles().get(index).getDescription());
                                            signal.setUrl(response.getArticles().get(index).getUrl());
                                            signal.setUrlToImage(response.getArticles().get(index).getUrlToImage());
                                            signal.setPublishedAt(response.getArticles().get(index).getPublishedAt());

                                            Date fechaActual = new Date();
                                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                                            String fechaString = formato.format(fechaActual);
                                            signal.setCreatedAt(fechaString);

                                            serviceSignal.saveSignal(signal);
                                            break;
                                        }


                                        index++;
                                    }



//                    Signal signal = new Signal();
//                    signal.setTitle(response.getArticles().get(0).getTitle());
//                    signal.setDescription(response.getArticles().get(0).getDescription());
//                    signal.setUrl(response.getArticles().get(0).getUrl());
//                    signal.setUrlToImage(response.getArticles().get(0).getUrlToImage());
//                    signal.setPublishedAt(response.getArticles().get(0).getPublishedAt());
//                    Date fechaActual = new Date();
//                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//                    String fechaString = formato.format(fechaActual);
//                    signal.setCreatedAt(fechaString);
//                    serviceSignal.saveSignal(signal);

                                    System.out.println(response.getArticles().get(0).getTitle() + response.getArticles().get(0).getDescription() );
                                }


                                @Override
                                public void onFailure(Throwable throwable) {
                                    System.out.println(throwable.getMessage());
                                }
                            }
                    );;
                }

                @Override
                public void onFailure(Throwable throwable) {
                    System.out.println(throwable.getMessage());
                }
            }
    );

    //IMPLEMENTACION SIN PAIS
//    newsApiClient.getEverything(
//            new EverythingRequest.Builder()
//                    .q(query)
//                    .language("es")
//                    .build(),
//            new NewsApiClient.ArticlesResponseCallback() {
//                @Override
//                public void onSuccess(ArticleResponse response) {
//
//                    int index = 0;
//
//
//                    while (index < response.getArticles().size()) {
//                        String title = response.getArticles().get(index).getTitle();
//
//
//                        List<Signal> isTitle = serviceSignal.findByTitle(title);
//                        if (isTitle.isEmpty()) {
//
//                            Signal signal = new Signal();
//                            signal.setTitle(title);
//                            signal.setDescription(response.getArticles().get(index).getDescription());
//                            signal.setUrl(response.getArticles().get(index).getUrl());
//                            signal.setUrlToImage(response.getArticles().get(index).getUrlToImage());
//                            signal.setPublishedAt(response.getArticles().get(index).getPublishedAt());
//
//                            Date fechaActual = new Date();
//                            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//                            String fechaString = formato.format(fechaActual);
//                            signal.setCreatedAt(fechaString);
//
//                            serviceSignal.saveSignal(signal);
//                            break;
//                        }
//
//
//                        index++;
//                    }
//
//
//
////                    Signal signal = new Signal();
////                    signal.setTitle(response.getArticles().get(0).getTitle());
////                    signal.setDescription(response.getArticles().get(0).getDescription());
////                    signal.setUrl(response.getArticles().get(0).getUrl());
////                    signal.setUrlToImage(response.getArticles().get(0).getUrlToImage());
////                    signal.setPublishedAt(response.getArticles().get(0).getPublishedAt());
////                    Date fechaActual = new Date();
////                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
////                    String fechaString = formato.format(fechaActual);
////                    signal.setCreatedAt(fechaString);
////                    serviceSignal.saveSignal(signal);
//
//                    System.out.println(response.getArticles().get(0).getTitle() + response.getArticles().get(0).getDescription() );
//                }
//
//
//                @Override
//                public void onFailure(Throwable throwable) {
//                    System.out.println(throwable.getMessage());
//                }
//            }
//    );


    return new ResponseEntity<>( HttpStatus.CREATED);
}

@DeleteMapping("/signals/{id}")
public ResponseEntity<String> deleteSignal(@PathVariable("id")String id){
    serviceSignal.deleteSignal(id);
    return  new ResponseEntity<>("El registro fue borrado exitosamente", HttpStatus.OK);
}

@GetMapping("/categories")
    public List<Category> findAll(){
    return service.findAll();
}





}
