package facades;

import dtos.MovieDTO;
import org.junit.jupiter.api.*;
import utils.EMF_Creator;
import entities.Movie;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class MovieFacadeTest {

    private static EntityManagerFactory emf;
    private static MovieFacade facade;

    public MovieFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = MovieFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Movie.deleteAllRows").executeUpdate();
            em.persist(new Movie(2014, "Interstellar", Arrays.stream(new String[]{"Matthew McConaughey","Anne Hathaway"}).collect(Collectors.toList())));
            em.persist(new Movie(2008, "The Dark Knight", Arrays.stream(new String[]{"Christian Bale","Heath Ledger"}).collect(Collectors.toList())));
            em.persist(new Movie(2007, "No Country for Old Men", Arrays.stream(new String[]{"Javier Bardem","Tommy Lee Jones"}).collect(Collectors.toList())));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
//    @Test
//    public void testAFacadeMethod() throws Exception {
//        assertEquals(2, facade.getMovieCount(), "Expects two rows in the database");
//    }
    

}
