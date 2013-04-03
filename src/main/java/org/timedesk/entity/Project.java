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
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Set;
import org.timedesk.entity.ProjectMember;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.validation.constraints.NotNull;
import org.timedesk.entity.ProjectPhase;

@RooJavaBean
@RooToString
@RooEntity
@Table(name = "project")
public class Project 
{
	@NotNull
	@ManyToOne
	@JoinColumn(name = "company_id", referencedColumnName = "company_id")
	private Company company;
	
    @NotNull
    @Column(name = "project_id")
    private String projectId;

    @Column(name = "name")
    private String name;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<ProjectMember> projectMembers = new HashSet<ProjectMember>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<ProjectPhase> projectPhases = new HashSet<ProjectPhase>();
    
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();        
        sb.append(getName());        
        return sb.toString();
    }
    
    public static Project findProject(Long id) 
    {
        if (id == null) return null;
        Project entity = entityManager().find(Project.class, id);
        if(entity != null)
        	entityManager().refresh(entity);
        return entity;
    }
}
