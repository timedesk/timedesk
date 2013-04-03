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
 *  2011 Feb 04 - Imesh - Added method findUser(String username).
 *
 */

package org.timedesk.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@Table(name = "user")
public class User 
{
    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<SecurityRole> securityRoles = new HashSet<SecurityRole>();
    
    @OneToMany(mappedBy = "user")
    private Set<Employee> employees = new HashSet<Employee>();
    
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        sb.append(getUsername());
        return sb.toString();
    }
    
    public static User findUser(Long id) 
    {
        if (id == null) return null;
        User entity = entityManager().find(User.class, id);
        if(entity != null)
        	entity.entityManager().refresh(entity);
        return entity;
    }
    
    public static User findUser(String username) 
    {
        if (username != null) 
        {
        	Query query = entityManager().createQuery("SELECT u FROM User u WHERE u.username = ?1");
        	query.setParameter(1, username);
        	List result = query.getResultList();
        	if((result != null) && (result.size() > 0))
        	{
        		return (User)result.get(0);
        	}
        }
        return null;
    }
}
