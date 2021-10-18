package com.hepsiburada.api.sources;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class Common {
    private String baseUrl;
    Logger logger = Logger.getLogger("MyLog");


    public Common(String url) {
        this.baseUrl = url;
    }

    public Response getResponse(String url) {

        Response response = given()
                .get(baseUrl + url);
        return response;

    }

    public void writeLog(String message) throws SecurityException, IOException {

        try {
            FileHandler fh = new FileHandler(new File("log.txt").getAbsolutePath());
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.info(message);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
