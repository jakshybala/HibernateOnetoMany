package grey.hibernate.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/*
grey.hibernate.model
Tarih: 31.05.2022, Saat: 3:39, Author: Grey 
*/
@Entity
@Table(name = "Person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "itemOwener", cascade = CascadeType.PERSIST)
    private List<Item> itemList;

    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    public void addItem(Item item) {
        if (this.itemList == null) {
            this.itemList = new ArrayList<>();

        }
        this.itemList.add(item);
        item.setItemOwener(this);
    }

    @Override
    public String toString() {
        return "id: " + getId() + " name: " + getName() + " age: " + getAge();
    }
}



