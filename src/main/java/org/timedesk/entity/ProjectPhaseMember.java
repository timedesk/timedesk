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

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.roo.addon.entity.RooEntity;

@RooJavaBean
@RooToString
@RooEntity
@Table(name = "project_phase_member")
public class ProjectPhaseMember 
{
	@NotNull
	@ManyToOne
	@JoinColumn(name = "phase_id", referencedColumnName = "phase_id")
	private ProjectPhase projectPhase;
	
	@NotNull
	@Column(name = "phase_member_id")
	private String phaseMemberId;
	
	@OneToOne
	@JoinColumn(name = "member_id", referencedColumnName = "member_id")
	private ProjectMember projectMember;
	
	@NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    @Column(name = "start_date")
    private Date startDate;

	@NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    @Column(name = "end_date")
    private Date endDate;
	
	@NotNull
	@Column(name = "allocation")
    private Integer allocation;
	
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();        
        sb.append(getPhaseMemberId());
        return sb.toString();
    }
    
    public static ProjectPhaseMember findProjectPhaseMember(Long id) 
    {
        if (id == null) return null;
        ProjectPhaseMember entity = entityManager().find(ProjectPhaseMember.class, id);
        if(entity != null)
        	entity.entityManager().refresh(entity);
        return entity;
    }
}
