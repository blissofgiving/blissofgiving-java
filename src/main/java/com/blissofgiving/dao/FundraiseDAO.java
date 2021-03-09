package com.blissofgiving.dao;

import java.sql.SQLException;
import java.util.List;

import com.blissofgiving.dynamodbmodel.Fundraise;

public interface FundraiseDAO {
	void createFundraise(Fundraise fundraise) throws SQLException;

	Fundraise getFundraiseById(String fundraiseId, String userId);

	void deleteById(String fundraiseID);

	void updateFundraise(Fundraise fundraise);

	List<Fundraise> findActiveFundraiseByUserId(String fundraiseUserId);

	List<Fundraise> getAllFundraiseByUserId(String fundraiseUserId);
}
