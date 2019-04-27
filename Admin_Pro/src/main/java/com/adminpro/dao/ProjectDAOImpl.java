package com.adminpro.dao;
 
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.adminpro.model.Project;
 
@Repository
public class ProjectDAOImpl implements ProjectDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addProject(Project project) {
        sessionFactory.getCurrentSession().saveOrUpdate(project);
 
    }
 
    @SuppressWarnings("unchecked")
    public List<Project> getAllProjects() {
 
        return sessionFactory.getCurrentSession().createQuery("from Project")
                .list();
    }
 
    @Override
    public void deleteProject(int projectId) {
        Project project = (Project) sessionFactory.getCurrentSession().load(
                Project.class, projectId);
        if (null != project) {
            this.sessionFactory.getCurrentSession().delete(project);
        }
 
    }
 
    public Project getProject(int empid) {
        return (Project) sessionFactory.getCurrentSession().get(
                Project.class, empid);
    }
 
    @Override
    public Project updateProject(Project project) {
        sessionFactory.getCurrentSession().update(project);
        return project;
    }
 
}