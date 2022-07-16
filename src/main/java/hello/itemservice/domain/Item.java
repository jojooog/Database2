package hello.itemservice.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class Item {

    //id를 pk로 지정하고 디비에서 자동으로 값을 넣어주는 방식을 선택
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", length = 10)
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
