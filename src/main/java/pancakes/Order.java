package pancakes;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table( name="Pancake_Order" )
public class Order {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    private String name;

    private String address;

    private String ccCVV;

    @ManyToMany( targetEntity = Pancake.class )
    private List<Pancake> pancakes;

    @ManyToMany( targetEntity = Sauce.class )
    private List<Sauce> sauces;
}
