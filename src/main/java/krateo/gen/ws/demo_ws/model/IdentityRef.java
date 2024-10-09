package krateo.gen.ws.demo_ws.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentityRef {
    // Define properties based on the azuredevops.IdentityRef struct
    // For example:
    private String id;
    private String displayName;

    // Getters and setters
} 
