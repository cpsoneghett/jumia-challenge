package com.jumia.challenge.api.service.mapper;

import java.io.Serializable;

public interface AbstractMapper<T, U> extends Serializable {

	public U sourceToDestination(T source);

	public T destinationToSource(U destination);
}
