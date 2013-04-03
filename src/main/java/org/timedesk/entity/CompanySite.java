/*
 *  Time Desk
 *  Project Resource Management System
 *  http://code.google.com/p/timedesk
 *   
 *  Masters in Enterprise Applications Development
 *  Sri Lanka Institute of Information Technology, Sri Lanka
 *  Sheffield Hallam University, United Kingdom
 *  
 *  History:
 *  2010 Dec 30 - Imesh - Created
 *
 */

package org.timedesk.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@Table(name="company_site", uniqueConstraints = @UniqueConstraint(columnNames = "company_id,site_id"))
public class CompanySite 
{
	@NotNull
	@ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    private Company company;
	
	@NotNull
	@Column(name = "site_id")
	private String siteId;

	@Column(name = "location")
    private String location;

	@Column(name = "city")
    private String city;

	@Column(name = "country")
    private String country;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="companySite")
    private Set<Employee> employees = new HashSet<Employee>();
    
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();        
        sb.append(getSiteId());        
        return sb.toString();
    }
    
    public static CompanySite findCompanySite(Long id) 
    {
        if (id == null) return null;
        CompanySite entity = entityManager().find(CompanySite.class, id);
        if(entity != null)
        	entityManager().refresh(entity);
        return entity;
    }
}
