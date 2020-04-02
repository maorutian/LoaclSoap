/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restservice.services;

import com.google.gson.Gson;
import com.mycompany.restservice.client.Movie;
import com.mycompany.restservice.client.CRUDWebService;
import com.mycompany.restservice.client.CRUDWebService_Service;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author tomorrow
 */
@Path("restapi")
@Produces("text/json")
public class RestWebService implements MessageBodyWriter {
   
   @Path("movies")
   @GET
   public List<Movie> getAllMovies() {
    CRUDWebService_Service service = new CRUDWebService_Service();
        CRUDWebService port = service.getCRUDWebServicePort();
        List<Movie> movies = port.getMovies();
        //Gson gson = new Gson();
         //String jsonMovies = gson.toJson(movies);
         return movies;
        
        //return this.GetComments().stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public boolean isWriteable(Class type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        if (type.getClass().equals(Response.class)) {
            return true;
        }
        return false;
    }

    @Override
    public void writeTo(Object t, Class type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Response.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal((Response) t, entityStream);

        } catch (JAXBException ex) {
            Logger.getLogger(RestWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This is a sample web service operation
     */
}
