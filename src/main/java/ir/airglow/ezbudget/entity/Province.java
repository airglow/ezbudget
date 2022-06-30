package ir.airglow.ezbudget.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Province {

    @Id
    @GeneratedValue
    private Long id;

    private String code;

    @NonNull
    private String name;

}
