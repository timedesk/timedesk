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

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@Table(name = "project_phase")
public class ProjectPhase 
{
	@NotNull
	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private Project project;
	
	@NotNull
	@Column(name = "phase_id")
    private String phaseId;

	@Column(name = "description")
    private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "S-")
	@Column(name = "start_date")
    private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "S-")
	@Column(name = "end_date")
    private Date endDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectPhase")
    private Set<ProjectPhaseMember> projectPhaseMembers = new HashSet<ProjectPhaseMember>();
    
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();        
        sb.append(getDescription());
        return sb.toString();
    }
    
    public static ProjectPhase findProjectPhase(Long id) 
    {
        if (id == null) return null;
        ProjectPhase entity = entityManager().find(ProjectPhase.class, id);
        if(entity != null)
        	entity.entityManager().refresh(entity);
        return entity;
    }
}
