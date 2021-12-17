package com.jumia.challenge.api.service;

import java.io.Serializable;

import com.jumia.challenge.api.domain.vo.CustomerVo;

public interface PhoneValidatorService extends Serializable {

	void validatePhoneInformations(CustomerVo customer);
}
