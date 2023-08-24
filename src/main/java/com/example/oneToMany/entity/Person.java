package com.example.oneToMany.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@DynamicUpdate
public class Person {

    @Id
    @GeneratedValue
    private Long pid;
    private String name;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Mobile> mobiles;

    public void addProduct(Mobile... mobile) {  //logic to add foreign key
           if(mobile!=null) {
               if(mobiles==null){
                   mobiles = new ArrayList<Mobile>(mobile.length);
               }
               for (Mobile mob : mobile){
                   mob.setPerson(this);
                   mobiles.add(mob);
               }
           }

    }


}
