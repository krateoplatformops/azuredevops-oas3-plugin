package krateo.gen.ws.demo_ws.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PipelinePermission extends Permission {
    @JsonProperty("id")
    private Object id;

    public String getId() {
        return String.valueOf(id);
    }
}
