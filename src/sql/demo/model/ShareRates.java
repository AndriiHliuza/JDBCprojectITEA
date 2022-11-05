package sql.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ShareRates extends BaseModel {
    private LocalDateTime operDate;
    private Share share;
    private BigDecimal rate;

    public ShareRates() {
    }

    public ShareRates(long id, LocalDateTime operDate, Share share, BigDecimal rate) {
        super(id);
        this.operDate = operDate;
        this.share = share;
        this.rate = rate;
    }

    public LocalDateTime getOperDate() {
        return operDate;
    }

    public void setOperDate(LocalDateTime operDate) {
        this.operDate = operDate;
    }

    public Share getShare() {
        return share;
    }

    public void setShare(Share share) {
        this.share = share;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShareRates that = (ShareRates) o;
        return Objects.equals(operDate, that.operDate) && Objects.equals(share, that.share) && Objects.equals(rate, that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operDate, share, rate);
    }
}
