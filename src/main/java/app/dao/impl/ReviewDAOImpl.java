package app.dao.impl;

import java.io.Serializable;
import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;

import app.dao.ReviewDAO;
import app.dao.GenericDAO;
import app.model.Review;

public class ReviewDAOImpl extends GenericDAO<Integer, Review> implements ReviewDAO {
	private static final Logger logger = Logger.getLogger(ReviewDAOImpl.class);

	public ReviewDAOImpl() {
		super(Review.class);
	}

	@Override
	public List<Review> loadReviews() {
		return getSession().createQuery("from Review").getResultList();
	}

}