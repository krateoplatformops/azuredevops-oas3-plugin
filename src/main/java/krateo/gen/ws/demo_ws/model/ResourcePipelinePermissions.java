package krateo.gen.ws.demo_ws.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResourcePipelinePermissions {
    @JsonProperty("allPipelines")
    private Permission allPipelines;

    @JsonProperty("pipelines")
    private List<PipelinePermission> pipelines;

    @JsonProperty("resource")
    private Resource resource;

    // Getters and setters
    public Permission getAllPipelines() {
        return allPipelines;
    }

    public void setAllPipelines(Permission allPipelines) {
        this.allPipelines = allPipelines;
    }

    public List<PipelinePermission> getPipelines() {
        return pipelines;
    }

    public void setPipelines(List<PipelinePermission> pipelines) {
        this.pipelines = pipelines;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
