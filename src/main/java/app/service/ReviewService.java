package app.service;

import java.util.List;

import app.model.Review;

public interface ReviewService extends BaseService<Integer, Review> {

	List<Review> loadReviews();
}