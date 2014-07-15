package test.example.mvc.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class A {

    @Size(min=2, max=5)
    @NotNull
    private String aOne;

    @NotNull
    private String aTwo;

    public String getaOne() {
        return aOne;
    }

    public void setaOne(String aOne) {
        this.aOne = aOne;
    }

    public String getaTwo() {
        return aTwo;
    }

    public void setaTwo(String aTwo) {
        this.aTwo = aTwo;
    }
}
