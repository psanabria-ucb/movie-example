package bo.edu.ucbcba.videoclub.model;

import bo.edu.ucbcba.videoclub.exceptions.ValidationException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie movie;
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        movie = new Movie();
    }

    @Test
    public void testSetTitle() {
        movie.setTitle("Good Title");
        assertEquals("Good Title", movie.getTitle());
    }

    @Test
    public void testSetNoTitle() {
        exception.expect(ValidationException.class);
        exception.expectMessage("Title can't be empty");
        movie.setTitle("");
    }

    @Test
    public void testSetNullTitle() {
        exception.expect(ValidationException.class);
        exception.expectMessage("Null title");
        movie.setTitle(null);
    }

    @Test
    public void testSetLongTitle() {
        exception.expect(ValidationException.class);
        exception.expectMessage("Title is too long");
        movie.setTitle(new String(new char[256]).replace('\0', 'a'));
    }
}