package bo.edu.ucbcba.videoclub.controller;

import bo.edu.ucbcba.videoclub.dao.VideoClubEntityManager;
import bo.edu.ucbcba.videoclub.exceptions.ValidationException;
import bo.edu.ucbcba.videoclub.model.Movie;

import javax.persistence.EntityManager;

public class MovieController {
    public void create(String title,
                       String description,
                       String releaseYear,
                       int rating,
                       String hoursLength,
                       String minutesLength) {

        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setDescription(description);
        if (releaseYear.matches("[0-9]+"))
            movie.setReleaseYear(Integer.parseInt(releaseYear));
        else
            throw new ValidationException("Release year isn't a number");
        movie.setRating(rating);

        int hours, minutes;

        if (!hoursLength.matches("[0-9]+"))
            throw new ValidationException("Year isn't a number");
        hours = Integer.parseInt(hoursLength);

        if (!minutesLength.matches("[0-9]+"))
            throw new ValidationException("Minutes field isn't a number");
        minutes = Integer.parseInt(minutesLength);

        if (minutes >= 60)
            throw new ValidationException("Minutes can't be greater than 59");
        movie.setLength(hours * 60 + minutes);
        
        EntityManager entityManager = VideoClubEntityManager.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(movie);
        entityManager.getTransaction().commit();
    }
}