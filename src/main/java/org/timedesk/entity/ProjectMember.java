package org.timedesk.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@Table(name = "project_member")
public class ProjectMember 
{
	@NotNull
	@ManyToOne
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	private Project project;
	
    @NotNull
    @Column(name = "member_id")
    private String memberId;
    
    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ProjectMemberRole> roles = new HashSet<ProjectMemberRole>();

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectMember")
    private Set<ProjectMemberFeedback> feedbacks = new HashSet<ProjectMemberFeedback>();
    
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();        
        sb.append(getMemberId());        
        return sb.toString();
    }
    
    public static ProjectMember findProjectMember(Long id) 
    {
        if (id == null) return null;
        ProjectMember entity = entityManager().find(ProjectMember.class, id);
        if(entity != null)
        	entity.entityManager().refresh(entity);
        return entity;
    }
}
