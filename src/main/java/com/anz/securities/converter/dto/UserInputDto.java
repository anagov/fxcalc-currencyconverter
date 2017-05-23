package com.anz.securities.converter.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents user inputs. Includes a list of Traversal paths
 * 
 * @author Anand Katti
 *
 */
public class UserInputDto {
	private String sourceCurrency;
	private String destinationCurrency;
	private String conversionAmount;
	private double convertedAmount;
	private int expectedDecimal;
	private List<TraversalPath> traversal = new ArrayList<>();
	private List<String> traversedPath = new ArrayList<>();

	public List<String> getTraversedPath() {
		return traversedPath;
	}

	public void setTraversedPath(List<String> traversedPath) {
		this.traversedPath = traversedPath;
	}

	public void addTraversedPath(final String traversedPath) {
		this.traversedPath.add(traversedPath);
	}

	public int getExpectedDecimal() {
		return expectedDecimal;
	}

	public void setExpectedDecimal(int expectedDecimal) {
		this.expectedDecimal = expectedDecimal;
	}

	public List<TraversalPath> getTraversal() {
		return traversal;
	}

	public void setTraversal(final List<TraversalPath> traversal) {
		this.traversal = traversal;
	}

	public void addTraversal(final TraversalPath path) {
		traversal.add(path);
	}

	public String getSourceCurrency() {
		return sourceCurrency;
	}

	public void setSourceCurrency(final String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}

	public String getDestinationCurrency() {
		return destinationCurrency;
	}

	public void setDestinationCurrency(final String destinationCurrency) {
		this.destinationCurrency = destinationCurrency;
	}

	public String getConversionAmount() {
		return conversionAmount;
	}

	public void setConversionAmount(final String conversionAmount) {
		this.conversionAmount = conversionAmount;
	}

	public double getConvertedAmount() {
		return convertedAmount;
	}

	public void setConvertedAmount(final double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
}
