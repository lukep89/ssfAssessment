package ibf2022.ssfAssessment.model;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Order {

    @NotNull(message = "Name cannot be null")
    @Size(min = 3, message = "Name must be at least 3 characters")
    private String name;

    @NotNull(message = "Name cannot be null")
    private String address;

    @Size(min = 8, message = "Phone number must be 8 digits")
    private String phone;

    @Value("${isRush:false}")
    private Boolean isRush;

    private String comments;

    private String orderId;

    public Order() {
        this.orderId = genrateId(8);
    }

    public Order(String orderId, String name, String address,
            String phone, Boolean isRush) {
        this.orderId = orderId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isRush = isRush;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsRush() {
        return isRush;
    }

    public void setIsRush(Boolean isRush) {
        this.isRush = isRush;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private synchronized String genrateId(int numOfChar) {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder();

        while (sb.length() < numOfChar) {
            sb.append(Integer.toHexString(rnd.nextInt()));

        }
        return sb.toString().substring(0, numOfChar);
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("orderId", this.getOrderId())
                .add("name", this.getName())
                .add("address", this.getAddress())
                .add("phone", this.getPhone())
                .add("rush", this.getIsRush())
                .add("comments", this.getComments())
                .build();
    }
}
