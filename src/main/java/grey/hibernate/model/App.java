package grey.hibernate.model;

import jakarta.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        EntityManagerFactory entityManagerFactory = sessionFactory.unwrap(EntityManagerFactory.class);
        Session currentSession = sessionFactory.openSession();

        try {
            final EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Person person = new Person("Altysh", 12);
//            List<Person> list = entityManager.createQuery("select p from Person p", Person.class).getResultList();
//            System.out.println(list);
//            List<Person> listp = entityManager.createQuery("select p from Person p WHERE p.name like 'K%'", Person.class).getResultList();
//            System.out.println(listp);
//            Person person2 = entityManager.find(Person.class, 1);
//            List<Item> itemList = person2.getItemList();
//            System.out.println("item list: " + itemList);
//            Item item = entityManager.find(Item.class, 3);
//            System.out.println("owener" + item.getItemOwener());
//
//            Person personBolot = entityManager.find(Person.class, 3);
//            Item newItemForBolot = new Item("New Iphone 14", personBolot);
//            entityManager.persist(newItemForBolot);

//            Person personKayrat = entityManager.find(Person.class, 3);
//            List<Item> itemList = personKayrat.getItemList();
//            System.out.println(personKayrat.getName() + ": " + itemList);
//            Person personTurat = new Person("Turat", 222);
//            Item itemForTurat = new Item("MacBook Pro", personTurat);
//            personTurat.setItemList(new ArrayList<>(Collections.singletonList(itemForTurat)));
//            entityManager.persist(personTurat);
//            entityManager.persist(itemForTurat);
//            List<Item> itemTurat = personTurat.getItemList();
//            System.out.println(itemTurat);

//            Person person1 = entityManager.find(Person.class, 4);
//            List<Item> itemList = person1.getItemList();
//            System.out.println(person1.getName() + ". item : " + itemList);

//            Person person1 = entityManager.find(Person.class, 4);
//            List<Item> itemList = person1.getItemList();
//            itemList.stream().forEach(item -> entityManager.remove(item));

//            Person person1 = entityManager.find(Person.class, 2);
//            entityManager.remove(person1);
//            person1.getItemList().forEach(item -> item.setItemOwener(null));

//            Person person1 = entityManager.find(Person.class, 3);
//            Item item = entityManager.find(Item.class, 3);
//            item.getItemOwener().getItemList().remove(item);
//
//            item.setItemOwener(person1);
//            person1.getItemList().add(item);
            //save itemlist in daughter class cascade = CascadeType.Persist


            List<Person> from_person_1 = entityManager.createQuery("FROM Person ").getResultList();
            System.out.println("all people:" + from_person_1);
            //Create people and item
//            Person newPerson = new Person("Kana" ,23);
//            Item newItem = new Item("iWatch", newPerson);
//            newPerson.setItemList(new ArrayList<>(Collections.singletonList(newItem)));
//            entityManager.persist(newPerson);
            //add item method in Person

            Person personByMethod = new Person("Jakyp", 23);
            personByMethod.addItem(new Item("Item 1"));
            personByMethod.addItem(new Item("Item 2"));
            personByMethod.addItem(new Item("Item 3"));

            entityManager.persist(personByMethod);




            entityManager.getTransaction().commit();

        } finally {

            entityManagerFactory.close();
            sessionFactory.close();

        }


    }
}

