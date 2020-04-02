/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.soapservice.daos;

import com.mycompany.soapservice.models.Movie;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tomorrow
 */
public class MovieDAO {

    private static final String SELECT_MOVIE_BY_ID = "select id, title, year, category, producer, director,thumbnail, thumbnailfile from netflix2 where id =?";
    private static final String SELECT_ALL_MOVIES = "select * from netflix2";
    private static final String INSERT_MOVIE = "INSERT INTO netflix2" + " (title, year, category, producer, director, thumbnail) VALUES "
            + " (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_MOVIE = "UPDATE netflix2 SET title = ?, year= ?, category =?, producer =?, director =?, thumbnail =? where id = ?";
    private static final String DELETE_MOVIE = "DELETE from netflix2 where id = ?";
    private static final String UPLOAD_MOVIE_FILE = "UPDATE netflix2 SET thumbnailfile = ? where id = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@calvin.humber.ca:1521:grok", "N01308482", "oracle");
        } catch (SQLException ex) {
            printSQLException(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MovieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

    public Movie selectMovie(int id) {
        Movie movie = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MOVIE_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                int year = rs.getInt("year");
                String category = rs.getString("category");
                String producer = rs.getString("producer");
                String director = rs.getString("director");
                String thumbnail = rs.getString("thumbnail");
                byte[] thumbnailFile = rs.getBytes("thumbnailfile");
                movie = new Movie(id, title, year, category, producer, director, thumbnail, thumbnailFile);
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return movie;
    }

    public List< Movie> selectAllMovies() {

        List< Movie> movies = new ArrayList<>();
        try (
                 Connection connection = getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MOVIES);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                int year = rs.getInt("year");
                String category = rs.getString("category");
                String producer = rs.getString("producer");
                String director = rs.getString("director");
                String thumbnail = rs.getString("thumbnail");
                byte[] thumbnailFile = rs.getBytes("thumbnailfile");
                movies.add(new Movie(id, title, year, category, producer, director, thumbnail, thumbnailFile));
            }
        } catch (SQLException ex) {
            printSQLException(ex);
        }
        return movies;
    }

    public void insertMovie(Movie movie) throws SQLException {
        try (
                 Connection connection = getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MOVIE)) {
            preparedStatement.setString(1, movie.getTitle());
            preparedStatement.setInt(2, movie.getYear());
            preparedStatement.setString(3, movie.getCategory());
            preparedStatement.setString(4, movie.getProducer());
            preparedStatement.setString(5, movie.getDirector());
            preparedStatement.setString(6, movie.getThumbnail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            printSQLException(ex);
        }
    }

    public boolean updateMovie(Movie movie) throws SQLException {
        boolean rowUpdated;
        try (
                 Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(UPDATE_MOVIE);) {
            statement.setString(1, movie.getTitle());
            statement.setInt(2, movie.getYear());
            statement.setString(3, movie.getCategory());
            statement.setString(4, movie.getProducer());
            statement.setString(5, movie.getDirector());
            statement.setString(6, movie.getThumbnail());
            statement.setInt(7, movie.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteMovie(int id) throws SQLException {
        boolean rowDeleted;
        try (
                 Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(DELETE_MOVIE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean uploadMovieFile(Movie movie) throws SQLException {
        boolean rowUpdated;
        try (
                 Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(UPLOAD_MOVIE_FILE);) {
            statement.setBytes(1, movie.getThumbnailFile());
            statement.setInt(2, movie.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
