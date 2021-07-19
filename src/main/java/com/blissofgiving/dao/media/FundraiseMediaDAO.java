package com.blissofgiving.dao.media;

import java.sql.SQLException;
import java.util.List;

import com.blissofgiving.dynamodbmodel.FundraiseMedia;

public interface FundraiseMediaDAO {

	void createFundraiseMedia(FundraiseMedia fundraiseMedia) throws SQLException;

	List<FundraiseMedia> getFundraiseMediaById(String fundraiseId);

	void deleteFundraiseMediaById(String fundraiseID);

	void updateFundraise(FundraiseMedia fundraise);
}
