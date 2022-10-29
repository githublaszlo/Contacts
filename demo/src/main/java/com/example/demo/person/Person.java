package com.example.demo.person;

import com.example.demo.address.Address;

import javax.persistence.*;

@Entity(name = "Person")
@Table(name = "person")
public class Person {

    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "permanent_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey( name = "perm_address_fk")
    )
    private Address permanentAddress;

    @ManyToOne
    @JoinColumn(
            name = "temporary_id",
            nullable = true,
            referencedColumnName = "id",
            foreignKey = @ForeignKey( name = "temp_address_fk")
    )
    private Address temporaryAddress;
    private Long permanentAddressId;
    private Long temporaryAddressId;

    public Person() {
    }

    public Person(Long id, String name, Long permanentAddressId, Long temporaryAddressId) {
        this.id = id;
        this.name = name;
        this.permanentAddressId = permanentAddressId;
        this.temporaryAddressId = temporaryAddressId;
    }

    public Person(String name, Long permanentAddressId, Long temporaryAddressId) {
        this.name = name;
        this.permanentAddressId = permanentAddressId;
        this.temporaryAddressId = temporaryAddressId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPermanentAddressId() {
        return permanentAddressId;
    }

    public void setPermanentAddressId(Long permanentAddressId) {
        this.permanentAddressId = permanentAddressId;
    }

    public Long getTemporaryAddressId() {
        return temporaryAddressId;
    }

    public void setTemporaryAddressId(Long temporaryAddressId) {
        this.temporaryAddressId = temporaryAddressId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", permanentAddressId=").append(permanentAddressId);
        sb.append(", temporaryAddressId=").append(temporaryAddressId);
        sb.append('}');
        return sb.toString();
    }
}
