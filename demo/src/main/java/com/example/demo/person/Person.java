package com.example.demo.person;

public class Person {

    private Long id;
    private String name;
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
