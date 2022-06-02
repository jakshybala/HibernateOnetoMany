package grey.hibernate.model;

import jakarta.persistence.*;

/*
grey.hibernate.model
Tarih: 31.05.2022, Saat: 21:57, Author: Grey 
*/
@Entity
@Table(name = "Item")
public class Item {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Item_name")
    private String itemName;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person itemOwener;


    public Item() {
    }

    public Item(String itemName) { //, Person newOwener
        this.itemName = itemName;
//        this.itemOwener  = newOwener;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Person getItemOwener() {
        return itemOwener;
    }

    public void setItemOwener(Person itemOwener) {
        this.itemOwener = itemOwener;
    }
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                '}';
    }

}
