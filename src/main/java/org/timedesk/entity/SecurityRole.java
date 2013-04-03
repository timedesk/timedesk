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
 *  2011 Jan 29 - Imesh - Created
 *
 */

package org.timedesk.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;

@RooJavaBean
@RooToString
@RooEntity
@Table(name = "security_role")
public class SecurityRole 
{
	@NotNull
	@Column(name = "security_role_id")
	private String securityRoleId;
	
	@NotNull
	@Column(name = "name")
    private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
    private Set<ApplicationFeature> applicationFeatures = new HashSet<ApplicationFeature>();
	
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());        
        return sb.toString();
    }
    
    public static SecurityRole findSecurityRole(Long id) 
    {
        if (id == null) return null;
        SecurityRole entity = entityManager().find(SecurityRole.class, id);
        if(entity != null)
        	entity.entityManager().refresh(entity);
        return entity;
    }
}
