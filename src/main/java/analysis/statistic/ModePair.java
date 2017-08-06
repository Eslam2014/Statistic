package analysis.statistic;

import java.util.Collections;
import java.util.Set;

public class ModePair<T> {
	private Set<T> values;
	private int nFrequence;
	public ModePair(Set<T> values,int nFrequence) {
		this.values = Collections.unmodifiableSet(values);
		this.nFrequence = nFrequence;
	}
	public int getnFrequence() {
		return nFrequence;
	}
	
	public Set<T> getValues() {
		return values;
	}

}
