package test.example.mvc.model;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class B {

    @NotNull
    private String bOne;

    @NotNull
    @NotEmpty
    private String bTwo;


    public String getbTwo() {
        return bTwo;
    }

    public void setbTwo(String bTwo) {
        this.bTwo = bTwo;
    }

    public String getbOne() {
        return bOne;
    }

    public void setbOne(String bOne) {
        this.bOne = bOne;
    }

}
