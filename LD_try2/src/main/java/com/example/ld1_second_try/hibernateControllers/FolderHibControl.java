package com.example.ld1_second_try.hibernateControllers;


import com.example.ld1_second_try.ds.Folder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class FolderHibControl {
    private EntityManagerFactory emf = null;

    public FolderHibControl(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void createFolder(Folder folder) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(folder);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }


    public void editFolder(Folder folder) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(folder);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void removeFolder(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            //Papildomai pries trinant reikia visus rysius ir priklausomybes patikrinti
            Folder folder = null;
            try {
                folder = em.getReference(Folder.class, id);
                folder.getId();
            } catch (Exception e) {
                System.out.println("No such user by given Id");
            }
            em.remove(folder);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Folder> getAllFolders() {
        return getAllFolders(false, -1, -1);
    }

    public List<Folder> getAllFolders(boolean all, int resMax, int resFirst) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery query = em.getCriteriaBuilder().createQuery();
            query.select(query.from(Folder.class));
            Query q = em.createQuery(query);

            if (!all) {
                q.setMaxResults(resMax);
                q.setFirstResult(resFirst);
            }

            return q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    public Folder getFolderById(int id) {
        EntityManager em = null;
        Folder folder = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            folder = em.getReference(Folder.class, id);
            folder.getId();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("No such user by given Id");
        }
        /*
        finally {

            if (em != null) {
                em.close();
            }
        }
    */

        return folder;
    }

}
