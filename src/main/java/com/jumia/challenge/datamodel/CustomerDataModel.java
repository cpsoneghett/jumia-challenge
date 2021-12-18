package com.jumia.challenge.datamodel;

import java.util.List;

import com.jumia.challenge.api.domain.vo.CustomerVo;

public class CustomerDataModel extends AbstractLazyDataModel<CustomerVo> {

	private static final long serialVersionUID = 1L;

	public CustomerDataModel(List<CustomerVo> datasource) {
		super(datasource);
	}

	@Override
	public CustomerVo getRowData(String rowKey) {
		for (CustomerVo data : super.getDatasource()) {
			if (data.getId() == Integer.parseInt(rowKey)) {
				return data;
			}
		}

		return null;
	}

	@Override
	public String getRowKey(CustomerVo customer) {
		return String.valueOf(customer.getId());
	}
}
