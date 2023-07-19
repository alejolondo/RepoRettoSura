package com.example.backendretosura.models;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Document(value = "signals")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Signal {


    private String id;
    private String title;
    private String description;
    private String url;

    private String urlToImage;

    private String category;

    private String tag;

    private String publishedAt;

    private String createdAt;





}
