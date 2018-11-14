/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpdescartes;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author beckerm
 */
@Entity
@Table(name = "descartes_de_tallado", catalog = "descartes", schema = "")
@NamedQueries({
    @NamedQuery(name = "DescartesDeTallado.findAll", query = "SELECT d FROM DescartesDeTallado d")
    , @NamedQuery(name = "DescartesDeTallado.findByDtaid", query = "SELECT d FROM DescartesDeTallado d WHERE d.dtaid = :dtaid")
    , @NamedQuery(name = "DescartesDeTallado.findByDtanumtrab", query = "SELECT d FROM DescartesDeTallado d WHERE d.dtanumtrab = :dtanumtrab")
    , @NamedQuery(name = "DescartesDeTallado.findByDtamaterial", query = "SELECT d FROM DescartesDeTallado d WHERE d.dtamaterial = :dtamaterial")
    , @NamedQuery(name = "DescartesDeTallado.findByDtatratamiento", query = "SELECT d FROM DescartesDeTallado d WHERE d.dtatratamiento = :dtatratamiento")
    , @NamedQuery(name = "DescartesDeTallado.findByDtacolor", query = "SELECT d FROM DescartesDeTallado d WHERE d.dtacolor = :dtacolor")
    , @NamedQuery(name = "DescartesDeTallado.findByDtabase", query = "SELECT d FROM DescartesDeTallado d WHERE d.dtabase = :dtabase")
    , @NamedQuery(name = "DescartesDeTallado.findByDtafecha", query = "SELECT d FROM DescartesDeTallado d WHERE d.dtafecha = :dtafecha")
    , @NamedQuery(name = "DescartesDeTallado.findByDtamotivo", query = "SELECT d FROM DescartesDeTallado d WHERE d.dtamotivo = :dtamotivo")
    , @NamedQuery(name = "DescartesDeTallado.findByDtaojo", query = "SELECT d FROM DescartesDeTallado d WHERE d.dtaojo = :dtaojo")
    , @NamedQuery(name = "DescartesDeTallado.findByDtacant", query = "SELECT d FROM DescartesDeTallado d WHERE d.dtacant = :dtacant")})
public class DescartesDeTallado implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Dta_id")
    private Integer dtaid;
    @Basic(optional = false)
    @Column(name = "Dta_numtrab")
    private String dtanumtrab;
    @Basic(optional = false)
    @Column(name = "Dta_material")
    private String dtamaterial;
    @Basic(optional = false)
    @Column(name = "Dta_tratamiento")
    private String dtatratamiento;
    @Basic(optional = false)
    @Column(name = "Dta_color")
    private String dtacolor;
    @Basic(optional = false)
    @Column(name = "Dta_base")
    private String dtabase;
    @Basic(optional = false)
    @Column(name = "Dta_fecha")
    private String dtafecha;
    @Basic(optional = false)
    @Column(name = "Dta_motivo")
    private String dtamotivo;
    @Basic(optional = false)
    @Column(name = "Dta_ojo")
    private String dtaojo;
    @Basic(optional = false)
    @Column(name = "Dta_cant")
    private int dtacant;

    public DescartesDeTallado() {
    }

    public DescartesDeTallado(Integer dtaid) {
        this.dtaid = dtaid;
    }

    public DescartesDeTallado(Integer dtaid, String dtanumtrab, String dtamaterial, String dtatratamiento, String dtacolor, String dtabase, String dtafecha, String dtamotivo, String dtaojo, int dtacant) {
        this.dtaid = dtaid;
        this.dtanumtrab = dtanumtrab;
        this.dtamaterial = dtamaterial;
        this.dtatratamiento = dtatratamiento;
        this.dtacolor = dtacolor;
        this.dtabase = dtabase;
        this.dtafecha = dtafecha;
        this.dtamotivo = dtamotivo;
        this.dtaojo = dtaojo;
        this.dtacant = dtacant;
    }

    public Integer getDtaid() {
        return dtaid;
    }

    public void setDtaid(Integer dtaid) {
        Integer oldDtaid = this.dtaid;
        this.dtaid = dtaid;
        changeSupport.firePropertyChange("dtaid", oldDtaid, dtaid);
    }

    public String getDtanumtrab() {
        return dtanumtrab;
    }

    public void setDtanumtrab(String dtanumtrab) {
        String oldDtanumtrab = this.dtanumtrab;
        this.dtanumtrab = dtanumtrab;
        changeSupport.firePropertyChange("dtanumtrab", oldDtanumtrab, dtanumtrab);
    }

    public String getDtamaterial() {
        return dtamaterial;
    }

    public void setDtamaterial(String dtamaterial) {
        String oldDtamaterial = this.dtamaterial;
        this.dtamaterial = dtamaterial;
        changeSupport.firePropertyChange("dtamaterial", oldDtamaterial, dtamaterial);
    }

    public String getDtatratamiento() {
        return dtatratamiento;
    }

    public void setDtatratamiento(String dtatratamiento) {
        String oldDtatratamiento = this.dtatratamiento;
        this.dtatratamiento = dtatratamiento;
        changeSupport.firePropertyChange("dtatratamiento", oldDtatratamiento, dtatratamiento);
    }

    public String getDtacolor() {
        return dtacolor;
    }

    public void setDtacolor(String dtacolor) {
        String oldDtacolor = this.dtacolor;
        this.dtacolor = dtacolor;
        changeSupport.firePropertyChange("dtacolor", oldDtacolor, dtacolor);
    }

    public String getDtabase() {
        return dtabase;
    }

    public void setDtabase(String dtabase) {
        String oldDtabase = this.dtabase;
        this.dtabase = dtabase;
        changeSupport.firePropertyChange("dtabase", oldDtabase, dtabase);
    }

    public String getDtafecha() {
        return dtafecha;
    }

    public void setDtafecha(String dtafecha) {
        String oldDtafecha = this.dtafecha;
        this.dtafecha = dtafecha;
        changeSupport.firePropertyChange("dtafecha", oldDtafecha, dtafecha);
    }

    public String getDtamotivo() {
        return dtamotivo;
    }

    public void setDtamotivo(String dtamotivo) {
        String oldDtamotivo = this.dtamotivo;
        this.dtamotivo = dtamotivo;
        changeSupport.firePropertyChange("dtamotivo", oldDtamotivo, dtamotivo);
    }

    public String getDtaojo() {
        return dtaojo;
    }

    public void setDtaojo(String dtaojo) {
        String oldDtaojo = this.dtaojo;
        this.dtaojo = dtaojo;
        changeSupport.firePropertyChange("dtaojo", oldDtaojo, dtaojo);
    }

    public Integer getDtacant() {
        return dtacant;
    }

    public void setDtacant(int dtacant) {
        int oldDtacant = this.dtacant;
        this.dtacant = dtacant;
        changeSupport.firePropertyChange("dtacant", oldDtacant, dtacant);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtaid != null ? dtaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescartesDeTallado)) {
            return false;
        }
        DescartesDeTallado other = (DescartesDeTallado) object;
        if ((this.dtaid == null && other.dtaid != null) || (this.dtaid != null && !this.dtaid.equals(other.dtaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tpdescartes.DescartesDeTallado[ dtaid=" + dtaid + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
