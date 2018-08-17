package org.lunatech.assessment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

/**
 * Created by m.fazel on 8/11/2018.
 */
@Entity
@Table(name = "tbl_runway")
public class Runway {

    @Id
    private String id;
    @ManyToOne
    @JoinColumn(name = "airport_id")
    @JsonBackReference
    private Airport airport;
    private String airport_ident;
    private String length_ft;
    private String width_ft;
    private String surface;
    private String lighted;
    private String closed;
    private String le_ident;
    private String le_latitude_deg;
    private String le_longitude_deg;
    private String le_elevation_ft;
    private String le_heading_degT;
    private String le_displaced_threshold_ft;
    private String he_ident;
    private String he_latitude_deg;
    private String he_longitude_deg;
    private String he_elevation_ft;
    private String he_heading_degT;
    private String he_displaced_threshold_ft;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public String getAirport_ident() {
        return airport_ident;
    }

    public void setAirport_ident(String airport_ident) {
        this.airport_ident = airport_ident;
    }

    public String getLength_ft() {
        return length_ft;
    }

    public void setLength_ft(String length_ft) {
        this.length_ft = length_ft;
    }

    public String getWidth_ft() {
        return width_ft;
    }

    public void setWidth_ft(String width_ft) {
        this.width_ft = width_ft;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public String getLighted() {
        return lighted;
    }

    public void setLighted(String lighted) {
        this.lighted = lighted;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getLe_ident() {
        return le_ident;
    }

    public void setLe_ident(String le_ident) {
        this.le_ident = le_ident;
    }

    public String getLe_latitude_deg() {
        return le_latitude_deg;
    }

    public void setLe_latitude_deg(String le_latitude_deg) {
        this.le_latitude_deg = le_latitude_deg;
    }

    public String getLe_longitude_deg() {
        return le_longitude_deg;
    }

    public void setLe_longitude_deg(String le_longitude_deg) {
        this.le_longitude_deg = le_longitude_deg;
    }

    public String getLe_elevation_ft() {
        return le_elevation_ft;
    }

    public void setLe_elevation_ft(String le_elevation_ft) {
        this.le_elevation_ft = le_elevation_ft;
    }

    public String getLe_heading_degT() {
        return le_heading_degT;
    }

    public void setLe_heading_degT(String le_heading_degT) {
        this.le_heading_degT = le_heading_degT;
    }

    public String getLe_displaced_threshold_ft() {
        return le_displaced_threshold_ft;
    }

    public void setLe_displaced_threshold_ft(String le_displaced_threshold_ft) {
        this.le_displaced_threshold_ft = le_displaced_threshold_ft;
    }

    public String getHe_ident() {
        return he_ident;
    }

    public void setHe_ident(String he_ident) {
        this.he_ident = he_ident;
    }

    public String getHe_latitude_deg() {
        return he_latitude_deg;
    }

    public void setHe_latitude_deg(String he_latitude_deg) {
        this.he_latitude_deg = he_latitude_deg;
    }

    public String getHe_longitude_deg() {
        return he_longitude_deg;
    }

    public void setHe_longitude_deg(String he_longitude_deg) {
        this.he_longitude_deg = he_longitude_deg;
    }

    public String getHe_elevation_ft() {
        return he_elevation_ft;
    }

    public void setHe_elevation_ft(String he_elevation_ft) {
        this.he_elevation_ft = he_elevation_ft;
    }

    public String getHe_heading_degT() {
        return he_heading_degT;
    }

    public void setHe_heading_degT(String he_heading_degT) {
        this.he_heading_degT = he_heading_degT;
    }

    public String getHe_displaced_threshold_ft() {
        return he_displaced_threshold_ft;
    }

    public void setHe_displaced_threshold_ft(String he_displaced_threshold_ft) {
        this.he_displaced_threshold_ft = he_displaced_threshold_ft;
    }

    @Override
    public String toString() {
        return "Runway{" +
                "id='" + id + '\'' +
                ", airport_ref='" + airport.getId() + '\'' +
                ", surface='" + surface + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Runway runway = (Runway) o;

        if (id != null ? !id.equals(runway.id) : runway.id != null) return false;
        if (airport != null ? !airport.equals(runway.airport) : runway.airport != null) return false;
        if (airport_ident != null ? !airport_ident.equals(runway.airport_ident) : runway.airport_ident != null)
            return false;
        if (length_ft != null ? !length_ft.equals(runway.length_ft) : runway.length_ft != null) return false;
        if (width_ft != null ? !width_ft.equals(runway.width_ft) : runway.width_ft != null) return false;
        if (surface != null ? !surface.equals(runway.surface) : runway.surface != null) return false;
        if (lighted != null ? !lighted.equals(runway.lighted) : runway.lighted != null) return false;
        if (closed != null ? !closed.equals(runway.closed) : runway.closed != null) return false;
        if (le_ident != null ? !le_ident.equals(runway.le_ident) : runway.le_ident != null) return false;
        if (le_latitude_deg != null ? !le_latitude_deg.equals(runway.le_latitude_deg) : runway.le_latitude_deg != null)
            return false;
        if (le_longitude_deg != null ? !le_longitude_deg.equals(runway.le_longitude_deg) : runway.le_longitude_deg != null)
            return false;
        if (le_elevation_ft != null ? !le_elevation_ft.equals(runway.le_elevation_ft) : runway.le_elevation_ft != null)
            return false;
        if (le_heading_degT != null ? !le_heading_degT.equals(runway.le_heading_degT) : runway.le_heading_degT != null)
            return false;
        if (le_displaced_threshold_ft != null ? !le_displaced_threshold_ft.equals(runway.le_displaced_threshold_ft) : runway.le_displaced_threshold_ft != null)
            return false;
        if (he_ident != null ? !he_ident.equals(runway.he_ident) : runway.he_ident != null) return false;
        if (he_latitude_deg != null ? !he_latitude_deg.equals(runway.he_latitude_deg) : runway.he_latitude_deg != null)
            return false;
        if (he_longitude_deg != null ? !he_longitude_deg.equals(runway.he_longitude_deg) : runway.he_longitude_deg != null)
            return false;
        if (he_elevation_ft != null ? !he_elevation_ft.equals(runway.he_elevation_ft) : runway.he_elevation_ft != null)
            return false;
        if (he_heading_degT != null ? !he_heading_degT.equals(runway.he_heading_degT) : runway.he_heading_degT != null)
            return false;
        return he_displaced_threshold_ft != null ? he_displaced_threshold_ft.equals(runway.he_displaced_threshold_ft) : runway.he_displaced_threshold_ft == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (airport != null ? airport.hashCode() : 0);
        result = 31 * result + (airport_ident != null ? airport_ident.hashCode() : 0);
        result = 31 * result + (length_ft != null ? length_ft.hashCode() : 0);
        result = 31 * result + (width_ft != null ? width_ft.hashCode() : 0);
        result = 31 * result + (surface != null ? surface.hashCode() : 0);
        result = 31 * result + (lighted != null ? lighted.hashCode() : 0);
        result = 31 * result + (closed != null ? closed.hashCode() : 0);
        result = 31 * result + (le_ident != null ? le_ident.hashCode() : 0);
        result = 31 * result + (le_latitude_deg != null ? le_latitude_deg.hashCode() : 0);
        result = 31 * result + (le_longitude_deg != null ? le_longitude_deg.hashCode() : 0);
        result = 31 * result + (le_elevation_ft != null ? le_elevation_ft.hashCode() : 0);
        result = 31 * result + (le_heading_degT != null ? le_heading_degT.hashCode() : 0);
        result = 31 * result + (le_displaced_threshold_ft != null ? le_displaced_threshold_ft.hashCode() : 0);
        result = 31 * result + (he_ident != null ? he_ident.hashCode() : 0);
        result = 31 * result + (he_latitude_deg != null ? he_latitude_deg.hashCode() : 0);
        result = 31 * result + (he_longitude_deg != null ? he_longitude_deg.hashCode() : 0);
        result = 31 * result + (he_elevation_ft != null ? he_elevation_ft.hashCode() : 0);
        result = 31 * result + (he_heading_degT != null ? he_heading_degT.hashCode() : 0);
        result = 31 * result + (he_displaced_threshold_ft != null ? he_displaced_threshold_ft.hashCode() : 0);
        return result;
    }
}
