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
 *  2010 Dec 27 - Imesh  - Created
 *  2010 Dec 30 - Imesh  - Renamed CompanySite to Site.
 *
 */

package org.timedesk.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EntityManager;
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
@Table(name = "company", uniqueConstraints = @UniqueConstraint(columnNames = "company_id"))
public class Company 
{
	@NotNull
	@Column(name = "company_id")
    private String companyId;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")    
    private Set<CompanySite> companySites = new HashSet<CompanySite>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")    
    private Set<Project> projects = new HashSet<Project>();

    public String toString() 
    {
        StringBuilder sb = new StringBuilder();        
        sb.append(getName());     
        return sb.toString();
    }
    
    public static Company findCompany(Long id) 
    {
        if (id == null) return null;
        Company company = entityManager().find(Company.class, id);
        if(company != null)
        	entityManager().refresh(company);
        return company;
    }
}