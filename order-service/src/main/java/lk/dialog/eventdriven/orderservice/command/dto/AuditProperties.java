package lk.dialog.eventdriven.orderservice.command.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AuditProperties {

    @JsonProperty("attributeName")
    private String attributeName;

    @JsonProperty("attributeValue")
    private String attributeValue;

}
