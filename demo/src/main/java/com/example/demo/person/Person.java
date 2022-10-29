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
