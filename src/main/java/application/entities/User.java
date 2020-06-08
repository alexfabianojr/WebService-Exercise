package application.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "table_user")
public class User implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<Order>();

    public User() { }

    public User(Long id, String name, String email, String phone, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public List<Order> getOrders()                  { return orders; }
    public Long getId()                             { return id; }
    public String getName()                         { return name; }
    public String getEmail()                        { return email; }
    public String getPhone()                        { return phone; }
    public String getPassword()                     { return password; }

    public void setOrders(List<Order> orders)       { this.orders = orders; }
    public void setId(Long id)                      { this.id = id; }
    public void setName(String name)                { this.name = name; }
    public void setEmail(String email)              { this.email = email; }
    public void setPhone(String phone)              { this.phone = phone; }
    public void setPassword(String password)        { this.password = password; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() { return Objects.hash(getId()); }
}
