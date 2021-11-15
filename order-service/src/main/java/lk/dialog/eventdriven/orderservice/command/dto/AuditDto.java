package lk.dialog.eventdriven.orderservice.command.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AuditDto {

    @JsonProperty("auditEvent")
    private AuditEvent auditEvent;
}
