package com.example.demo.contact_information;

public class ContactInfo {

    private Long id;
    private Long addressId;
    private String type;
    private String description;

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
