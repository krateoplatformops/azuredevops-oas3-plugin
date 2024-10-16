package krateo.gen.ws.demo_ws.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Resource {
    // Id of the resource.
    @JsonProperty("id")
    private Object id;

    // Name of the resource.
    @JsonProperty("name")
    private String name;

    // Type of the resource.
    @JsonProperty("type")
    private String type;

    // Getters and setters
    public Object getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // You might want to add a constructor, toString, equals, and hashCode methods
}
