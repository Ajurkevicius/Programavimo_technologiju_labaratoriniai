package com.example.ld1_second_try.hibernateControllers;

import com.example.ld1_second_try.ds.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserHibControl {
        private EntityManagerFactory emf = null;

        public UserHibControl(EntityManagerFactory emf) {
            this.emf = emf;
        }

        private EntityManager getEntityManager() {
            return emf.createEntityManager();
        }

        public void createUser(User user) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        public void editUser(User user) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                em.getTransaction().begin();
                em.merge(user);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        public void removeUser(int id) {
            EntityManager em = null;
            try {
                em = getEntityManager();
                em.getTransaction().begin();
                //Papildomai pries trinant reikia visus rysius ir priklausomybes patikrinti
                User user = null;
                try {
                    user = em.getReference(User.class, id);
                    user.getId();
                } catch (Exception e) {
                    System.out.println("No such user by given Id");
                }
                em.remove(user);
                em.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        public List<User> getAllUsers() {
            return getAllUsers(false, -1, -1);
        }

        public List<User> getAllUsers(boolean all, int resMax, int resFirst) {
            EntityManager em = getEntityManager();
            try {
                CriteriaQuery query = em.getCriteriaBuilder().createQuery();
                query.select(query.from(User.class));
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

        public User getUserById(int id) {
            EntityManager em = null;
            User user = null;
            try {
                em = getEntityManager();
                em.getTransaction().begin();
                user = em.getReference(User.class, id);
                user.getId();
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("No such user by given Id");
            }
            return user;
        }



}
