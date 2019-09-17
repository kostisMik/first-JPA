/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kostis.Mikroulis
 */
@Entity
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByAtaf", query = "SELECT s FROM Student s WHERE s.ataf = :ataf")
    , @NamedQuery(name = "Student.findByName", query = "SELECT s FROM Student s WHERE s.name = :name")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ataf")
    private String ataf;
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "stdPerCourse", referencedColumnName = "id")
    @ManyToOne
    private Course stdPerCourse;

    public Student() {
    }

    public Student(String ataf) {
        this.ataf = ataf;
    }

    public String getAtaf() {
        return ataf;
    }

    public void setAtaf(String ataf) {
        this.ataf = ataf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getStdPerCourse() {
        return stdPerCourse;
    }

    public void setStdPerCourse(Course stdPerCourse) {
        this.stdPerCourse = stdPerCourse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ataf != null ? ataf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.ataf == null && other.ataf != null) || (this.ataf != null && !this.ataf.equals(other.ataf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Student[ ataf=" + ataf + " ]";
    }
    
}
