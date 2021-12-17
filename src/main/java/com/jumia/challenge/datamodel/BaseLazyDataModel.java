package com.jumia.challenge.datamodel;

import java.beans.IntrospectionException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.faces.context.FacesContext;

import org.apache.commons.collections4.ComparatorUtils;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.filter.FilterConstraint;
import org.primefaces.util.LocaleUtils;

import com.jumia.challenge.api.domain.model.BaseModel;
import com.jumia.challenge.utils.LazySorter;
import com.jumia.challenge.utils.ShowCaseUtil;

public class BaseLazyDataModel<T extends BaseModel> extends LazyDataModel<T> {

	private static final long serialVersionUID = 1L;

	private List<T> datasource;

	public BaseLazyDataModel(List<T> datasource) {
		super();
		this.datasource = datasource;
	}

	@Override
	public T getRowData(String rowKey) {
		for (T data : datasource) {
			if (data.getId() == Integer.parseInt(rowKey)) {
				return data;
			}
		}

		return null;
	}

	@Override
	public String getRowKey(T t) {
		return String.valueOf(t.getId());
	}

	@Override
	public int count(Map<String, FilterMeta> filterBy) {
		return (int) datasource.stream().filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o))
				.count();
	}

	@Override
	public List<T> load(int first, int pageSize, Map<String, SortMeta> sortBy, Map<String, FilterMeta> filterBy) {

		List<T> customers = datasource.stream()
				.skip(first)
				.filter(o -> filter(FacesContext.getCurrentInstance(), filterBy.values(), o)).limit(pageSize)
				.collect(Collectors.toList());

		if (!sortBy.isEmpty()) {
			List<Comparator<T>> comparators = sortBy.values().stream()
					.map(o -> new LazySorter<T>(o.getField(), o.getOrder())).collect(Collectors.toList());
			Comparator<T> cp = ComparatorUtils.chainedComparator(comparators);

			customers.sort(cp);
		}

		return customers;
	}

	private boolean filter(FacesContext context, Collection<FilterMeta> filterBy, Object o) {
		var matching = true;

		for (FilterMeta filter : filterBy) {
			FilterConstraint constraint = filter.getConstraint();
			Object filterValue = filter.getFilterValue();

			try {
				Object columnValue = String.valueOf(ShowCaseUtil.getPropertyValueViaReflection(o, filter.getField()));
				matching = constraint.isMatching(context, columnValue, filterValue, LocaleUtils.getCurrentLocale());
			} catch (ReflectiveOperationException | IntrospectionException e) {
				matching = false;
			}

			if (!matching) {
				break;
			}
		}

		return matching;
	}

}
