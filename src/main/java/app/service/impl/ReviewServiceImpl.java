package app.service.impl;

import java.io.Serializable;


import java.util.List;

import org.apache.log4j.Logger;

import app.model.Review;
import app.service.ReviewService;;

public class ReviewServiceImpl extends BaseServiceImpl implements ReviewService {
	private static final Logger logger = Logger.getLogger(ReviewServiceImpl.class);

	@Override
	public Review saveOrUpdate(Review entity) {
		try {
			return getReviewDAO().saveOrUpdate(entity);
		} catch (Exception e) {
			logger.error(e);
			throw e;
		}
	}


	@Override
	public Review findById(Serializable key) {
		try {
			return getReviewDAO().findById(key);
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public boolean delete(Review entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Review> loadReviews() {
		try {
			return getReviewDAO().loadReviews();
		} catch (Exception e) {
			return null;
		}

	}
}