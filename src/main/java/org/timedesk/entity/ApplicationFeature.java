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
 *  2011 Jan 27 - Imesh - Created
 *
 */

package org.timedesk.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;

@RooJavaBean
@RooToString
@RooEntity
@Table(name = "application_feature", uniqueConstraints = @UniqueConstraint(columnNames = "feature_id"))
public class ApplicationFeature 
{
	@NotNull
	@Column(name = "feature_id")
    private String featureId;

	@NotNull
	@Column(name = "name")
    private String name;

	@Column(name = "description")
    private String description;
	
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        return sb.toString();
    }
    
    public static ApplicationFeature findApplicationFeature(Long id) 
    {
        if (id == null) return null;
        ApplicationFeature entity = entityManager().find(ApplicationFeature.class, id);
        if(entity != null)
        	entityManager().refresh(entity);
        return entity;
    }
}
