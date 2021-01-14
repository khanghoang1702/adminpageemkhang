/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminpage.DAO;

import Entity.Items;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author pc
 */
public class adminpageDAO {
     public static List<Items> getAllItems() throws Exception {
        EntityManagerFactory factory=Persistence.createEntityManagerFactory("item");
        EntityManager entityManager = factory.createEntityManager();
        String sql = "SELECT item  FROM Items item";
        Query query = entityManager.createQuery(sql);
        List<Items> listItems = (List<Items>) query.getResultList();
        entityManager.close();
        return listItems;

    }

    public static void addItem(Items item) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("item");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction eTrans = entityManager.getTransaction();
        eTrans.begin();
        entityManager.persist(item);
        eTrans.commit();
        entityManager.close();
    }
    public static void deleteItem(String code) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("item");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction eTrans = entityManager.getTransaction();
        eTrans.begin();
        Items item=entityManager.find(Items.class, code);
        entityManager.remove(item);
        eTrans.commit();
        entityManager.close();
    }

    public static void updateItem(Items item) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("item");
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction eTrans = entityManager.getTransaction();
        eTrans.begin();
        entityManager.merge(item);
        eTrans.commit();
        entityManager.close();
    }
}
