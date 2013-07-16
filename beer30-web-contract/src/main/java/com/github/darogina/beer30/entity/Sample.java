package com.github.darogina.beer30.entity;

import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sample extends BaseEntity {

    private Long id;
    private String name;

    private DateTime testDateTime;

    public Sample() {
        super();
    }

    public Sample(String name, DateTime dateTime) {
        super();
        this.name = name;
        this.testDateTime = dateTime;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateTime getTestDateTime() {
        return testDateTime;
    }

    public void setTestDateTime(DateTime testDateTime) {
        this.testDateTime = testDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sample)) return false;

        Sample sample = (Sample) o;

        if (id != null ? !id.equals(sample.id) : sample.id != null) return false;
        if (name != null ? !name.equals(sample.name) : sample.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
