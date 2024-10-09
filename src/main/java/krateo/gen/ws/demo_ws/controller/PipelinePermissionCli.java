package krateo.gen.ws.demo_ws.controller;

import krateo.gen.ws.demo_ws.model.ResourcePipelinePermissions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/ws")
public class PipelinePermissionCli {

    @Autowired
    private RestTemplate restTemplate;

    // GET https://dev.azure.com/{organization}/{project}/_apis/pipelines/pipelinepermissions/{resourceType}/{resourceId}?api-version=7.0-preview.1
    @PostMapping("/{organization}/{project}/_apis/pipelines/pipelinepermissions/{resourceType}/{resourceId}")
    public ResponseEntity<?> getPipelinePermissions(
            @PathVariable String organization,
            @PathVariable String project,
            @PathVariable String resourceType,
            @PathVariable String resourceId,
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody ResourcePipelinePermissions permissionRequest) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        String url = String.format("https://dev.azure.com/%s/%s/_apis/pipelines/pipelinepermissions/%s/%s?api-version=7.0-preview.1", organization, project, resourceType, resourceId);

        ResponseEntity<ResourcePipelinePermissions> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                ResourcePipelinePermissions.class
        );

        ResourcePipelinePermissions respBody = response.getBody();
        if (respBody == null) {
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }

        // In the pipelinePermission resource, when authorized is set to false, none is returned from the API, 
        // resulting in continuous reconciliation due to the difference between the local and remote resources.
        // To avoid this we return the response body completed with the request if the authorized field is false. (or as in the code we simply return the request body)

        respBody.setPipelines(permissionRequest.getPipelines());

        return ResponseEntity.status(response.getStatusCode()).body(respBody);
        // return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    // Authorizes/Unauthorizes a list of definitions for a given resource.
    // PATCH https://dev.azure.com/{organization}/{project}/_apis/pipelines/pipelinepermissions/{resourceType}/{resourceId}?api-version=7.0-preview.1
    @PatchMapping("/{organization}/{project}/_apis/pipelines/pipelinepermissions/{resourceType}/{resourceId}")
    public ResponseEntity<?> updatePipelinePermissions(
            @PathVariable String organization,
            @PathVariable String project,
            @PathVariable String resourceType,
            @PathVariable String resourceId,
            @RequestHeader("Authorization") String authorizationHeader,
            @RequestBody ResourcePipelinePermissions permissionResponse) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authorizationHeader);
        HttpEntity<ResourcePipelinePermissions> entity = new HttpEntity<>(permissionResponse, headers);

        String url = String.format("https://dev.azure.com/%s/%s/_apis/pipelines/pipelinepermissions/%s/%s?api-version=7.0-preview.1", organization, project, resourceType, resourceId);

        ResponseEntity<ResourcePipelinePermissions> response = restTemplate.exchange(
                url,
                HttpMethod.PATCH,
                entity,
                ResourcePipelinePermissions.class
        );

        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }
}