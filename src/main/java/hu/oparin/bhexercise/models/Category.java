package hu.oparin.bhexercise.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fare_id")
    private Fare fare;

    @Size(min = 1, max = 33)
    private int categoryNumber;
    private LocalDate validFrom;
    private LocalDate validTo;

    public Category() {
        this.categoryNumber = 3;
    }

    public Category(Fare fare, @Size(min = 1, max = 33) int categoryNumber, LocalDate validFrom,
                    LocalDate validTo) {
        this.fare = fare;
        this.categoryNumber = categoryNumber;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Fare getFare() {
        return fare;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public int getCategoryNumber() {
        return categoryNumber;
    }

    public void setCategoryNumber(int categoryNumber) {
        this.categoryNumber = categoryNumber;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }
}
