package apps.cashier.cashierapps.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_tr_cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Integer id;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "note", columnDefinition = "text")
    private String note;
    @Column(name = "subtotal")
    private Integer subtotal;

    // Relationship Product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

     // Relationship Order
    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<Order> orders;
}
