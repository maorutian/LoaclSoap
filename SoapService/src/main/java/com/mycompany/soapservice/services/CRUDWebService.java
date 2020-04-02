/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservice.services;

import com.mycompany.soapservice.daos.MovieDAO;
import com.mycompany.soapservice.models.Movie;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.xml.ws.soap.MTOM;

/**
 *
 * @author tomorrow
 */
@WebService(serviceName = "CRUDWebService")
@MTOM(enabled = true, threshold = 100000)
@HandlerChain(file = "CRUDWebService_handler.xml")
public class CRUDWebService {

    private MovieDAO movieDAO = new MovieDAO();

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "GetMovieById")
    @WebResult(name = "GetMovieById")
    public Movie GetMovieById(@WebParam(name = "id") int id) {
        Movie movie = movieDAO.selectMovie(id);
        return movie;
    }

    @WebMethod(operationName = "GetMovies")
    @WebResult(name = "GetMovies")
    public List<Movie> GetMovies() {
        List<Movie> movies = movieDAO.selectAllMovies();
        return movies;
    }

    @WebMethod(operationName = "InsertMovie")
    @WebResult(name = "InsertMovie")
    public void InsertMovie(String title, int year, String category, String producer, String director, String thumbnail) {
        try {
            System.out.print("__________insert__________");
            Movie movie = new Movie(title, year, category, producer, director, thumbnail);
            movieDAO.insertMovie(movie);
        } catch (SQLException ex) {
            Logger.getLogger(CRUDWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "UpdateMovie")
    @WebResult(name = "UpdateMovie")
    public void UpdateMovie(int id, String title, int year, String category, String producer, String director, String thumbnail) {
        try {
            Movie movie = new Movie(id, title, year, category, producer, director, thumbnail);
            movieDAO.updateMovie(movie);
        } catch (SQLException ex) {
            Logger.getLogger(CRUDWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @WebMethod(operationName = "DeleteMovie")
    @WebResult(name = "DeleteMovie")
    public void DeleteMovie(int id) {
        try {
            movieDAO.deleteMovie(id);
        } catch (SQLException ex) {
            Logger.getLogger(CRUDWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
@WebMethod(operationName = "UploadImage")
    @WebResult(name = "UploadImage")
    public int UploadImageoad(int id, byte[] data) throws Exception
    {
        Movie movie = movieDAO.selectMovie(id);
        movie.setThumbnailFile(data);
        movieDAO.uploadMovieFile(movie);
        return data.length;
    }

}
