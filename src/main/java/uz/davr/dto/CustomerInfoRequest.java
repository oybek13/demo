package uz.davr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInfoRequest {
    private String  BRANCH;
    private String DATE_BEG;
    private String DATE_END;
}
