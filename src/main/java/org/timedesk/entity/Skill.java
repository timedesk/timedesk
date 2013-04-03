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
 *  2010 Dec 27 - Imesh - Created
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
@Table(name = "skill")
public class Skill 
{
	@NotNull
	@Column(name = "skill_id")
    private String skillId;
	
	@NotNull
	@Column(name = "description")
    private String description;
	
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getSkillId());
        return sb.toString();
    }
    
    public static Skill findSkill(Long id) 
    {
        if (id == null) return null;
        Skill entity = entityManager().find(Skill.class, id);
        if(entity != null)
        	entity.entityManager().refresh(entity);
        return entity;
    }
}
