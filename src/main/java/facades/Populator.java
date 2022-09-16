/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.MovieDTO;
import entities.Movie;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        MovieFacade mf = MovieFacade.getFacadeExample(emf);

        mf.create(new MovieDTO(new Movie(2008, "The Dark Knight", Arrays.stream(new String[]{"Christian Bale","Heath Ledger"}).collect(Collectors.toList()))));
        mf.create(new MovieDTO(new Movie(2007, "No Country for Old Men", Arrays.stream(new String[]{"Javier Bardem","Tommy Lee Jones"}).collect(Collectors.toList()))));
    }
    
    public static void main(String[] args) {
        populate();
    }
}
