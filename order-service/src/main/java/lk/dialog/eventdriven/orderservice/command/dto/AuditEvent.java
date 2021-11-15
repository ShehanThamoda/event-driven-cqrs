package lk.dialog.eventdriven.orderservice.command.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class AuditEvent {

    @JsonProperty("source")
    private String source;

    @JsonProperty("eventType")
    private String eventType;

    @JsonProperty("action")
    private String action;

    @JsonProperty("user")
    private String user;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("auditProperties")
    private List<AuditProperties> auditProperties;

}
