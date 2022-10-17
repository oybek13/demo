package uz.davr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EndBeginDate {
    @JsonProperty("DATE_BEG")
    private String dateBeg;
    @JsonProperty("DATE_END")
    private String dateEnd;
}
