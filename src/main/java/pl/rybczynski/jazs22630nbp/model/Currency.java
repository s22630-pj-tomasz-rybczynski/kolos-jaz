package pl.rybczynski.jazs22630nbp.model;

public class Currency {
    private String code;
    private Double mid;

    public Currency() {}

    public Currency(String code, Double mid) {
        this.code = code;
        this.mid = mid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }
}
