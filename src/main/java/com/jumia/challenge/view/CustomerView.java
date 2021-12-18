package com.jumia.challenge.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;

import com.jumia.challenge.api.domain.model.Customer;
import com.jumia.challenge.api.domain.vo.CustomerVo;
import com.jumia.challenge.api.service.CustomerService;
import com.jumia.challenge.api.service.mapper.CustomerVoMapper;
import com.jumia.challenge.datamodel.CustomerDataModel;

@Named("customerView")
@ViewScoped
public class CustomerView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CustomerService customerService;

	@Autowired
	CustomerVoMapper mapper;

	private LazyDataModel<CustomerVo> customerDataModel;

	@PostConstruct
	public void init() {
		initializeDataModel();
	}

	private void initializeDataModel() {
		List<Customer> customers = customerService.findAll();
		customerDataModel = new CustomerDataModel(mapper.sourceToDestination(customers));
	}

	public LazyDataModel<CustomerVo> getCustomerDataModel() {
		return customerDataModel;
	}

}
