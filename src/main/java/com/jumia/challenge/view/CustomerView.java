package com.jumia.challenge.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;
import org.springframework.beans.factory.annotation.Autowired;

import com.jumia.challenge.api.domain.model.Customer;
import com.jumia.challenge.api.domain.vo.CustomerVo;
import com.jumia.challenge.api.service.CustomerService;
import com.jumia.challenge.api.service.PhoneValidatorService;
import com.jumia.challenge.datamodel.CustomerDataModel;

@Named("customerView")
@ViewScoped
public class CustomerView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private CustomerService customerService;
	@Autowired
	private PhoneValidatorService phoneValidatorService;

	private LazyDataModel<CustomerVo> customerDataModel;

	@PostConstruct
	public void init() {
		inicializaDataModel();
	}

	private void inicializaDataModel() {
		List<Customer> customers = customerService.findAll();
		List<CustomerVo> customersVo = new ArrayList<>();

		customers.forEach(c -> customersVo.add(new CustomerVo(c)));

		customersVo.forEach(phoneValidatorService::validatePhoneInformations);
		customerDataModel = new CustomerDataModel(customersVo);

	}

	public LazyDataModel<CustomerVo> getCustomerDataModel() {
		return customerDataModel;
	}

}
