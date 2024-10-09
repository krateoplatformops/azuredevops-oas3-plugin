package krateo.gen.ws.demo_ws.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Permission {
    @JsonProperty("authorized")
    private Boolean authorized;

    @JsonProperty("authorizedBy")
    private IdentityRef authorizedBy;

    @JsonProperty("authorizedOn")
    private OffsetDateTime authorizedOn;

    // Getters and setters
    public Boolean getAuthorized() {
        return authorized;
    }

    public void setAuthorized(Boolean authorized) {
        this.authorized = authorized;
    }

    public IdentityRef getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(IdentityRef authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    public OffsetDateTime getAuthorizedOn() {
        return authorizedOn;
    }

    public void setAuthorizedOn(OffsetDateTime authorizedOn) {
        this.authorizedOn = authorizedOn;
    }
}