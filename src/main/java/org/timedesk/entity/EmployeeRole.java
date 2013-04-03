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

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@Table(name = "em_role")
public class EmployeeRole 
{	
	@NotNull
	@Column(name = "role_id")
    private String roleId;

	@NotNull
	@Column(name = "name")
    private String name;
	
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        return sb.toString();
    }
    
    public static EmployeeRole findEmployeeRole(Long id) 
    {
        if (id == null) return null;
        EmployeeRole entity = entityManager().find(EmployeeRole.class, id);
        if(entity != null)
        	entityManager().refresh(entity);
        return entity;
    }
}
