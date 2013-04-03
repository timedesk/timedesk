/*
 *  Timedesk
 *  Project Resource Management System
 *  http://code.google.com/p/timedesk
 *   
 *  Masters in Enterprise Applications Development
 *  Sri Lanka Institute of Information Technology, Sri Lanka
 *  Sheffield Hallam University, United Kingdom
 *  
 *  History:
 *  2011 Jan 22 - Imesh - Created
 *
 */

package org.timedesk.entity;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooEntity
@Table(name = "employee_visa")
public class EmployeeVisa 
{
	@NotNull
	@ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
	private Employee employee;
	
	@NotNull
	@Column(name = "visa_id")
    private String visaId;
	
	@NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    @Column(name = "valid_from")
    private Date validFrom;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    @Column(name = "valid_to")
    private Date validTo;

    @NotNull
    @Column(name = "country")
    private String country;
    
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getVisaId());
        return sb.toString();
    }
    
    public static EmployeeVisa findEmployeeVisa(Long id) 
    {
        if (id == null) return null;
        EmployeeVisa entity = entityManager().find(EmployeeVisa.class, id);
        if(entity != null)
        	entityManager().refresh(entity);
        return entity;
    }
}
