package ibf2022.ssfAssessment.model;

import java.util.Random;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Select {

    // @NotNull(message = "Name cannot be null")
    private String pizza;

    // @NotNull(message = "Name cannot be null")
    private String size;

    // @NotNull(message = "User's age cannot be null")
    // @Min(value = 1, message = "Must be above 1 pizza")
    // @Max(value = 10, message = "Must be below 10 pizza")
    private Integer quantity;

    public Select() {
    }

    public Select(String pizza, String size, Integer quantity) {
        this.pizza = pizza;
        this.size = size;
        this.quantity = quantity;

    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public JsonObject toJSON() {
        return Json.createObjectBuilder()
                .add("pizza", this.getPizza())
                .add("size", this.getSize())
                .add("quantity", this.getQuantity())
                .build();
    }

}
