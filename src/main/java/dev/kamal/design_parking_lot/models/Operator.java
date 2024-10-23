package dev.kamal.design_parking_lot.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class Operator extends BaseModel{
    private String name;
    private int employeeId;

    public String toString() {
        return name;
    }

}
