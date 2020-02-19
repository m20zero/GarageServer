package com.spring.rest.spring_rest;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class JobCardService {
	
	@PersistenceContext
	EntityManager em;
	
	public List<JobCard> getallJobCards() {
		TypedQuery<JobCard> query = em.createNamedQuery(JobCard.FIND_ALL_JOBCARDS, JobCard.class);
		List<JobCard> results = query.getResultList();
		return results;
	}
	
	public List<JobCard> getallCompletedPendingJobCardss(String status) {
		if(status == "Completed"){
			TypedQuery<JobCard> query = em.createNamedQuery(JobCard.FIND_ALL_COMPLETED_JOBCARDS, JobCard.class);
			List<JobCard> results = query.getResultList();
			return results;
		}else if (status == "Pending") {
			TypedQuery<JobCard> query = em.createNamedQuery(JobCard.FIND_ALL_PENDING_JOBCARDS, JobCard.class);
			List<JobCard> results = query.getResultList();
			return results;
		}else{
			return null;
		}
	}
	
	public int getCompletedPendingCount(String status) {
		return ((Number) em.createQuery("SELECT COUNT(jc) FROM JobCard jc WHERE jc.status = '" + status + "'")
				.getSingleResult()).intValue();
	}
	
	public ArrayList<StatReport> getCompletedPendingCount() {
		ArrayList<StatReport> l = new ArrayList<StatReport>();
		String status = "Completed";
		int n1 = ((Number)em.createQuery("SELECT COUNT(jc) FROM JobCard jc WHERE jc.status = '" + status + "'").getSingleResult()).intValue();
		StatReport r1 = new StatReport("Completed", n1);
		status = "Pending";
		int n2 = ((Number)em.createQuery("SELECT COUNT(jc) FROM JobCard jc WHERE jc.status = '" + status + "'").getSingleResult()).intValue();
		StatReport r2 = new StatReport("Pending", n2);
		l.add(r1);l.add(r2);
		return l;
	}
	

	public JobCard getJobCard(long id) {
		return em.find(JobCard.class, id);
	}

	@Transactional
	public void deleteJobCard(long id) {
		em.remove(em.find(JobCard.class, id));
	}

	@Transactional
	public void addJobCard(JobCard jc) {
		em.persist(jc);
	}

	@Transactional
	public void updateJobCard(JobCard jc) {
		em.merge(jc);
	}
}
