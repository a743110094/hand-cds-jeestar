package hand.cds.oms.domain;

import java.util.Objects;

public class OrderVO {

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String no;

    /**
     *
     */
    private String origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderVO orderVO = (OrderVO) o;
        return Objects.equals(name, orderVO.name) && Objects.equals(no, orderVO.no) && Objects.equals(origin, orderVO.origin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, no, origin);
    }
}
