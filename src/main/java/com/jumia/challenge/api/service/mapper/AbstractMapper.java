package com.jumia.challenge.api.service.mapper;

public interface AbstractMapper<T, U> {

	public U sourceToDestination(T source);

	public T destinationToSource(U destination);
}
