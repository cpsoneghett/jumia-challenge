package com.jumia.challenge.api.datamodel;

import java.util.List;

import com.jumia.challenge.api.domain.vo.CustomerVo;

public class CustomerDataModel extends BaseLazyDataModel<CustomerVo> {

	private static final long serialVersionUID = 1L;

	public CustomerDataModel(List<CustomerVo> datasource) {
		super(datasource);
	}

}
