package converter.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Distance {
    private String unit;
    private Double value;
}
