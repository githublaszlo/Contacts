package com.example.demo.contact_information;

import com.example.demo.address.Address;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity (name = "Contact_info")
@Table (name = "contact_info")
public class ContactInfo {

    @Id
    @SequenceGenerator(
            name = "contact_info_sequence",
            sequenceName = "contact_info_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "contact_info_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "type",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String type; // pl.: telefon, email

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description; // típus leírása

    @ManyToOne
    @JoinColumn(
            name = "address_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey( name = "address_fk")
    )
    private Address address;

    //a fordítási hiba elkerülése miatt a Long addressId elé is betettem a @Column annotációt
    @Column(
            name = "address_id2"
    )
    private Long addressId;

    public ContactInfo() {
    }

    public ContactInfo(Long id, Long addressId, String type, String description) {
        this.id = id;
        this.addressId = addressId;
        this.type = type;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ContactInfo{");
        sb.append("id=").append(id);
        sb.append(", addressId=").append(addressId);
        sb.append(", type='").append(type).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
