package lk.ijse.rental.entity;

import lk.ijse.rental.embeded.Name;
import lk.ijse.rental.enums.AvailabilityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Driver {
    @Id
    private String user_Id;

    @Embedded
    private Name name;
    private String contact_No;
    private String address;
    private String email;
    private String nic_No;
    private String license_No;
    private String license_Img;
    @Enumerated(EnumType.STRING)
    private AvailabilityType driverAvailability;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

}
