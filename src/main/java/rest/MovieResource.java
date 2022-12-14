package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MovieDTO;
import entities.Movie;
import utils.EMF_Creator;
import facades.MovieFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Todo Remove or change relevant parts before ACTUAL use
@Path("movie")
public class MovieResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
       
    private static final MovieFacade FACADE =  MovieFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMovies() {
        return Response.ok().entity(GSON.toJson(FACADE.getAll())).build();
    }

    //get all movies
    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAllMovies() {
        return Response.ok().entity(GSON.toJson(FACADE.getAll())).build();
    }

    //get movie by id
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMovieById(@PathParam("id") long id) {
        return Response.ok().entity(GSON.toJson(FACADE.getById(id))).build();
    }

    // get movie by title
    @GET
    @Path("/title/{title}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getMovieByTitle(@PathParam("title") String title) {
        return Response.ok().entity(GSON.toJson(FACADE.getMovieByName(title))).build();
    }

    //get movie count
    @Path("/count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount() {
        long count = FACADE.getMovieCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }


    //create movie - lav jsonstring parameter og brug fromJson
    /*@POST
    @Path("/add")
    public Response createMovie(@PathParam("year") int year, @PathParam("title") String title){
        //String[] actors = {actor1, actor2, actor3}; // actors can defo be done in a smarter way
        MovieDTO movieDTO = new MovieDTO(new Movie(year, title, actors));
        return Response.ok().entity(GSON.toJson(FACADE.create(movieDTO))).build();
    }*/

}
