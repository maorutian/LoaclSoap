package com.mycompany.admin.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.soapservice.services.Movie;
import com.mycompany.soapservice.services.CRUDWebService;
import com.mycompany.soapservice.services.CRUDWebService_Service;
import com.mycompany.soapservice.services.Exception_Exception;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.soap.SOAPFaultException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author tomorrow
 */
@MultipartConfig
@WebServlet(name = "AdminServlet", urlPatterns = {"/"})
public class AdminServlet extends HttpServlet {

    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    private CRUDWebService port = new CRUDWebService_Service().getCRUDWebServicePort();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                addForm(request, response);
                break;
            case "/edit":
                updateForm(request, response);
                break;
            case "/insert":
                insert(request, response);
                break;
            case "/delete":
                delete(request, response);
                break;
            case "/update":
                update(request, response);
                break;
            case "/upload":
                upload(request, response);
                break;
            default:
                listAll(request, response);
                break;
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Movie> movies = port.getMovies();
        request.setAttribute("movies", movies);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void addForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        dispatcher.forward(request, response);
    }

    private void updateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Movie movie = port.getMovieById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
        request.setAttribute("movie", movie);
        dispatcher.forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String title = request.getParameter("title");
        String Stringyear = request.getParameter("year");
        String category = request.getParameter("category");
        String producer = request.getParameter("producer");
        String director = request.getParameter("director");
        String thumbnail = request.getParameter("thumbnail");
        if (title.isEmpty() || Stringyear.isEmpty() || category.isEmpty() || producer.isEmpty() || director.isEmpty()) {
            String msg = "Title/Year/Category/Production Company Cannot be Emty!";
            RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
            request.setAttribute("msg", msg);
            dispatcher.forward(request, response);
            return;
        } else if (!isNumeric(Stringyear)) {
            String msg = "Year is not numeric!";
            RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
            request.setAttribute("msg", msg);
            dispatcher.forward(request, response);
            return;
        }
        int year = Integer.parseInt(Stringyear);

        try {
            port.insertMovie(title, year, category, producer, director, thumbnail);
        } catch (SOAPFaultException ex) {
            String msg = "Cannot use 'Disney' in any field!";
            RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
            request.setAttribute("msg", msg);
            dispatcher.forward(request, response);

        }
        response.sendRedirect("/Admin");
    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String Stringyear = request.getParameter("year");
        String category = request.getParameter("category");
        String producer = request.getParameter("producer");
        String director = request.getParameter("director");
        String thumbnail = request.getParameter("thumbnail");
        if (title.isEmpty() || Stringyear.isEmpty() || category.isEmpty() || producer.isEmpty() || director.isEmpty()) {
            String msg = "Title/Year/Category/production Company Cannot be Emty!";
            Movie movie = port.getMovieById(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
            request.setAttribute("msg", msg);
            request.setAttribute("movie", movie);
            dispatcher.forward(request, response);
            return;
        } else if (!isNumeric(Stringyear)) {
            String msg = "Year is not numeric!";
            Movie movie = port.getMovieById(id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
            request.setAttribute("msg", msg);
            request.setAttribute("movie", movie);
            dispatcher.forward(request, response);
            return;
        }
        int year = Integer.parseInt(Stringyear);

        try {
            port.updateMovie(id, title, year, category, producer, director, thumbnail);
            response.sendRedirect("/Admin");
        } catch (SOAPFaultException ex) {
            Movie movie = port.getMovieById(id);
            String msg = "Cannot use 'Disney' in any field!";
            RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
            request.setAttribute("msg", msg);
            request.setAttribute("movie", movie);
            dispatcher.forward(request, response);
        }
    }

    private void upload(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException, ServletException {
        try {
            response.setContentType("text/html");
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = null;
            items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            String StringId = null;
            int id = -1;
            System.out.println("_______I am____id____" + id);
            byte[] buffer = null;
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                //if item is FormField, item is not a file
                if (item.isFormField()) {
                    String value = item.getString("UTF-8");
                    //get id from form
                    if (item.getFieldName().equals("id")) {
                        StringId = value;
                        id = Integer.parseInt(StringId);
                    }
                } else {
                    //item is a file, get image from form
                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    buffer = new byte[(int) item.getSize()];
                    bytes.write(buffer);

                }
            }
            port.uploadImage(id, buffer);
            response.sendRedirect("/Admin");
        } catch (FileUploadException ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);

        } catch (Exception_Exception ex) {
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        port.deleteMovie(id);
        response.sendRedirect("/Admin");

    }

    private boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

}
