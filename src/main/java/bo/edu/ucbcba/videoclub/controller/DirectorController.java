package bo.edu.ucbcba.videoclub.controller;

import bo.edu.ucbcba.videoclub.dao.VideoClubEntityManager;
import bo.edu.ucbcba.videoclub.model.Director;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class DirectorController {
    public void saveDirector(String fName, String lName, String osc) {
        EntityManager em = VideoClubEntityManager.createEntityManager();
        em.getTransaction().begin();
        Director director = new Director();

        director.setFirstName(fName);
        director.setLastName(lName);
        director.setOscars(Integer.parseInt(osc));

        em.persist(director);
        em.getTransaction().commit();
        em.close();
    }

    public List<Director> getAllDirectors() {
        EntityManager em = VideoClubEntityManager.createEntityManager();
        TypedQuery<Director> query = em.createQuery("select d from Director d order by d.firstName", Director.class);
        List<Director> list = query.getResultList();
        em.close();
        return list;
    }
}
