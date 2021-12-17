package com.jumia.challenge.api.utils;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

public class LazySorter<T> implements Comparator<T> {

	private String sortField;
	private SortOrder sortOrder;

	public LazySorter(String sortField, SortOrder sortOrder) {
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int compare(T o1, T o2) {
		try {
			Object value1 = ShowCaseUtil.getPropertyValueViaReflection(o1, sortField);
			Object value2 = ShowCaseUtil.getPropertyValueViaReflection(o2, sortField);

			int value = ((Comparable<Object>) value1).compareTo(value2);

			return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
