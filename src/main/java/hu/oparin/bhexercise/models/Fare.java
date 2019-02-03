package hu.oparin.bhexercise.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "FARE")
public class Fare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 2)
    private String carrier;
    @Size(max = 3)
    private String origin;
    @Size(max = 3)
    private String destination;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate validTo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate validFrom;
    @Size(max = 8)
    private String fareClassCode;
    @Range(min = 1, max = 5)
    private Integer bookingClass;

    public Fare() {
    }

    public Fare(@Size(max = 2) String carrier, @Size(max = 3) String origin, @Size(max = 3) String destination,
                LocalDate validTo, LocalDate validFrom, @Size(max = 8) String fareClassCode, @Size(max = 5) Integer bookingClass) {
        this.carrier = carrier;
        this.origin = origin;
        this.destination = destination;
        this.validTo = validTo;
        this.validFrom = validFrom;
        this.fareClassCode = fareClassCode;
        this.bookingClass = bookingClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public String getFareClassCode() {
        return fareClassCode;
    }

    public void setFareClassCode(String fareClassCode) {
        this.fareClassCode = fareClassCode;
    }

    public Integer getBookingClass() {
        return bookingClass;
    }

    public void setBookingClass(Integer bookingClass) {
        this.bookingClass = bookingClass;
    }
}
