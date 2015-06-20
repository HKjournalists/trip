package com.otrip.dao.trip;

import java.util.List;

import com.otrip.domain.system.OtImage;
import com.otrip.domain.trip.OtActiDestination;

public interface ImageDao {

	
	
	public List<OtImage> queryOtActiDestinations(final OtImage otImage)throws Exception;
}
