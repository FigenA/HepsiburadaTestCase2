package com.hepsiburada.api.test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


import com.hepsiburada.api.sources.Common;

import io.restassured.response.Response;


public class RestTest {
    String baseUrl;
    Common cmm;
    Response response;

    @Before
    public void init() {
        baseUrl = "http://generator.swagger.io/api/swagger.json";
        cmm = new Common(baseUrl);
    }

    @Test
    public void getResponse() throws SecurityException, IOException {
        try {
            Response response = cmm.getResponse("");
            assertEquals(200, response.getStatusCode());
            cmm.writeLog("Başarılı response");

        } catch (AssertionError as) {
            cmm.writeLog("Hatalı response");
        }


    }
}
