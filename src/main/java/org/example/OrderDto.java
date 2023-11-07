package org.example;

public class OrderDto {
    private String  status;
    private int id;

    private int courierId;
    private String customerName;
    private String customerPhone;
    private String comment;

    public OrderDto(String status, int courierId, String customerName, String customerPhone, String comment) {
        this.status = status;
        this.courierId = courierId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.comment = comment;
    }

    public OrderDto() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
