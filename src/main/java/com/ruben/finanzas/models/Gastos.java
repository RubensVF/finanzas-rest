package com.ruben.finanzas.models;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Gastos {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String concepto;
    private float monto;
    @CreationTimestamp
    private Date fecha;

    public Gastos(){}

    public Gastos(String concepto, float monto) {
        this.concepto = concepto;
        this.monto = monto;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getConcepto() {
        return concepto;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    public float getMonto() {
        return monto;
    }
    public void setMonto(float monto) {
        this.monto = monto;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((concepto == null) ? 0 : concepto.hashCode());
        result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + Float.floatToIntBits(monto);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Gastos other = (Gastos) obj;
        if (concepto == null) {
            if (other.concepto != null)
                return false;
        } else if (!concepto.equals(other.concepto))
            return false;
        if (fecha == null) {
            if (other.fecha != null)
                return false;
        } else if (!fecha.equals(other.fecha))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (Float.floatToIntBits(monto) != Float.floatToIntBits(other.monto))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Gastos [concepto=" + concepto + ", fecha=" + fecha + ", id=" + id + ", monto=" + monto + "]";
    }

}
