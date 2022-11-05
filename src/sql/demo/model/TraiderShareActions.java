package sql.demo.model;

import java.util.Objects;

public class TraiderShareActions extends BaseModel {
    private int operations;
    private Traiders traider;
    private ShareRates shareRate;
    private Long amount;

    public TraiderShareActions() {
    }

    public TraiderShareActions(long id, int operations, Traiders traider, ShareRates shareRate, Long amount) {
        super(id);
        this.operations = operations;
        this.traider = traider;
        this.shareRate = shareRate;
        this.amount = amount;
    }

    public int getOperations() {
        return operations;
    }

    public void setOperations(int operations) {
        this.operations = operations;
    }

    public Traiders getTraider() {
        return traider;
    }

    public void setTraider(Traiders traider) {
        this.traider = traider;
    }

    public ShareRates getShareRate() {
        return shareRate;
    }

    public void setShareRate(ShareRates shareRate) {
        this.shareRate = shareRate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TraiderShareActions that = (TraiderShareActions) o;
        return operations == that.operations && Objects.equals(traider, that.traider) && Objects.equals(shareRate, that.shareRate) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operations, traider, shareRate, amount);
    }
}
