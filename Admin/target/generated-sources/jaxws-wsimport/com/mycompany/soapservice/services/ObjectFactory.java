
package com.mycompany.soapservice.services;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mycompany.soapservice.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DeleteMovie_QNAME = new QName("http://services.soapservice.mycompany.com/", "DeleteMovie");
    private final static QName _GetMoviesResponse_QNAME = new QName("http://services.soapservice.mycompany.com/", "GetMoviesResponse");
    private final static QName _Exception_QNAME = new QName("http://services.soapservice.mycompany.com/", "Exception");
    private final static QName _UploadImageResponse_QNAME = new QName("http://services.soapservice.mycompany.com/", "UploadImageResponse");
    private final static QName _GetMovies_QNAME = new QName("http://services.soapservice.mycompany.com/", "GetMovies");
    private final static QName _InsertMovieResponse_QNAME = new QName("http://services.soapservice.mycompany.com/", "InsertMovieResponse");
    private final static QName _DeleteMovieResponse_QNAME = new QName("http://services.soapservice.mycompany.com/", "DeleteMovieResponse");
    private final static QName _UpdateMovie_QNAME = new QName("http://services.soapservice.mycompany.com/", "UpdateMovie");
    private final static QName _UploadImage_QNAME = new QName("http://services.soapservice.mycompany.com/", "UploadImage");
    private final static QName _InsertMovie_QNAME = new QName("http://services.soapservice.mycompany.com/", "InsertMovie");
    private final static QName _UpdateMovieResponse_QNAME = new QName("http://services.soapservice.mycompany.com/", "UpdateMovieResponse");
    private final static QName _GetMovieById_QNAME = new QName("http://services.soapservice.mycompany.com/", "GetMovieById");
    private final static QName _GetMovieByIdResponse_QNAME = new QName("http://services.soapservice.mycompany.com/", "GetMovieByIdResponse");
    private final static QName _UploadImageArg1_QNAME = new QName("", "arg1");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mycompany.soapservice.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UploadImageResponse }
     * 
     */
    public UploadImageResponse createUploadImageResponse() {
        return new UploadImageResponse();
    }

    /**
     * Create an instance of {@link GetMovies }
     * 
     */
    public GetMovies createGetMovies() {
        return new GetMovies();
    }

    /**
     * Create an instance of {@link InsertMovieResponse }
     * 
     */
    public InsertMovieResponse createInsertMovieResponse() {
        return new InsertMovieResponse();
    }

    /**
     * Create an instance of {@link DeleteMovie }
     * 
     */
    public DeleteMovie createDeleteMovie() {
        return new DeleteMovie();
    }

    /**
     * Create an instance of {@link GetMoviesResponse }
     * 
     */
    public GetMoviesResponse createGetMoviesResponse() {
        return new GetMoviesResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link UploadImage }
     * 
     */
    public UploadImage createUploadImage() {
        return new UploadImage();
    }

    /**
     * Create an instance of {@link InsertMovie }
     * 
     */
    public InsertMovie createInsertMovie() {
        return new InsertMovie();
    }

    /**
     * Create an instance of {@link UpdateMovieResponse }
     * 
     */
    public UpdateMovieResponse createUpdateMovieResponse() {
        return new UpdateMovieResponse();
    }

    /**
     * Create an instance of {@link GetMovieById }
     * 
     */
    public GetMovieById createGetMovieById() {
        return new GetMovieById();
    }

    /**
     * Create an instance of {@link GetMovieByIdResponse }
     * 
     */
    public GetMovieByIdResponse createGetMovieByIdResponse() {
        return new GetMovieByIdResponse();
    }

    /**
     * Create an instance of {@link DeleteMovieResponse }
     * 
     */
    public DeleteMovieResponse createDeleteMovieResponse() {
        return new DeleteMovieResponse();
    }

    /**
     * Create an instance of {@link UpdateMovie }
     * 
     */
    public UpdateMovie createUpdateMovie() {
        return new UpdateMovie();
    }

    /**
     * Create an instance of {@link Movie }
     * 
     */
    public Movie createMovie() {
        return new Movie();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "DeleteMovie")
    public JAXBElement<DeleteMovie> createDeleteMovie(DeleteMovie value) {
        return new JAXBElement<DeleteMovie>(_DeleteMovie_QNAME, DeleteMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMoviesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "GetMoviesResponse")
    public JAXBElement<GetMoviesResponse> createGetMoviesResponse(GetMoviesResponse value) {
        return new JAXBElement<GetMoviesResponse>(_GetMoviesResponse_QNAME, GetMoviesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadImageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "UploadImageResponse")
    public JAXBElement<UploadImageResponse> createUploadImageResponse(UploadImageResponse value) {
        return new JAXBElement<UploadImageResponse>(_UploadImageResponse_QNAME, UploadImageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovies }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "GetMovies")
    public JAXBElement<GetMovies> createGetMovies(GetMovies value) {
        return new JAXBElement<GetMovies>(_GetMovies_QNAME, GetMovies.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "InsertMovieResponse")
    public JAXBElement<InsertMovieResponse> createInsertMovieResponse(InsertMovieResponse value) {
        return new JAXBElement<InsertMovieResponse>(_InsertMovieResponse_QNAME, InsertMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "DeleteMovieResponse")
    public JAXBElement<DeleteMovieResponse> createDeleteMovieResponse(DeleteMovieResponse value) {
        return new JAXBElement<DeleteMovieResponse>(_DeleteMovieResponse_QNAME, DeleteMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "UpdateMovie")
    public JAXBElement<UpdateMovie> createUpdateMovie(UpdateMovie value) {
        return new JAXBElement<UpdateMovie>(_UpdateMovie_QNAME, UpdateMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UploadImage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "UploadImage")
    public JAXBElement<UploadImage> createUploadImage(UploadImage value) {
        return new JAXBElement<UploadImage>(_UploadImage_QNAME, UploadImage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertMovie }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "InsertMovie")
    public JAXBElement<InsertMovie> createInsertMovie(InsertMovie value) {
        return new JAXBElement<InsertMovie>(_InsertMovie_QNAME, InsertMovie.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateMovieResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "UpdateMovieResponse")
    public JAXBElement<UpdateMovieResponse> createUpdateMovieResponse(UpdateMovieResponse value) {
        return new JAXBElement<UpdateMovieResponse>(_UpdateMovieResponse_QNAME, UpdateMovieResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "GetMovieById")
    public JAXBElement<GetMovieById> createGetMovieById(GetMovieById value) {
        return new JAXBElement<GetMovieById>(_GetMovieById_QNAME, GetMovieById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMovieByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soapservice.mycompany.com/", name = "GetMovieByIdResponse")
    public JAXBElement<GetMovieByIdResponse> createGetMovieByIdResponse(GetMovieByIdResponse value) {
        return new JAXBElement<GetMovieByIdResponse>(_GetMovieByIdResponse_QNAME, GetMovieByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "arg1", scope = UploadImage.class)
    public JAXBElement<byte[]> createUploadImageArg1(byte[] value) {
        return new JAXBElement<byte[]>(_UploadImageArg1_QNAME, byte[].class, UploadImage.class, ((byte[]) value));
    }

}
