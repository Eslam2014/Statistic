package analysis.statistic;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * The class StatisticMeasures contains methods for performing basic Statistical
 * Measures such as mode, arithmetic mean,geometric mean, median , variance ,and
 * stander division functions.
 * 
 * @author Eslam Ali
 *
 */
public class DescriptiveStatistic {

	/**
	 * Calculates the average of the squared differences from the Mean.
	 */
	public static double variance(int... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		double mean = arithmeticMean(numbers);
		return (double) IntStream.of(numbers).map(i -> (int) Math.pow((i - mean), 2)).sum() / numbers.length;
	}

	/**
	 * Work like {@link #variance(int...)}.
	 */
	public static double variance(double... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		double mean = arithmeticMean(numbers);
		return (double) DoubleStream.of(numbers).map(i -> (int) Math.pow((i - mean), 2)).sum() / numbers.length;
	}

	/**
	 * Work like {@link #variance(int...)}.
	 */
	public static double variance(long... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		double mean = arithmeticMean(numbers);
		return (double) LongStream.of(numbers).map(i -> (int) Math.pow((i - mean), 2)).sum() / numbers.length;
	}

	/**
	 * Calculates square root of the Variance of list of numbers.
	 */
	public static double standardDeviation(int... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		return StrictMath.sqrt(variance(numbers));
	}

	/**
	 * Work like {@link #standardDeviation(int...)}.
	 */
	public static double standardDeviation(long... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		return StrictMath.sqrt(variance(numbers));
	}

	/**
	 * Work like {@link #standardDeviation(int...)}.
	 */
	public static double standardDeviation(double... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		return StrictMath.sqrt(variance(numbers));
	}

	/**
	 * Return middle of list of numbers after sort it
	 * 
	 * @return middle of a sorted list of numbers.
	 */
	public static double median(int... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		int length = numbers.length;
		if (length == 0) {
			return Double.NaN;
		}
		Arrays.sort(numbers);

		if (length % 2 == 0) {
			return (double) (numbers[length / 2] + numbers[(length / 2) + 1]) / 2;
		} else {
			return numbers[(length + 1) / 2];
		}

	}

	/**
	 * Work like {@link #median(int...)}
	 */
	public static double median(long... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		int length = numbers.length;
		if (length == 0) {
			return Double.NaN;
		}
		Arrays.sort(numbers);

		if (length % 2 == 0) {
			return (double) (numbers[length / 2] + numbers[(length / 2) + 1]) / 2;
		} else {
			return numbers[(length + 1) / 2];
		}

	}

	/**
	 * Work like {@link #median(int...)}
	 */
	public static double median(double... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		int length = numbers.length;
		if (length == 0) {
			return Double.NaN;
		}
		Arrays.sort(numbers);

		if (length % 2 == 0) {
			return (double) (numbers[length / 2] + numbers[(length / 2) + 1]) / 2;
		} else {
			return numbers[(length + 1) / 2];
		}

	}

	/**
	 * Work like {@link #median(int...)}
	 */
	public static double median(float... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		int length = numbers.length;
		if (length == 0) {
			return Double.NaN;
		}
		Arrays.sort(numbers);

		if (length % 2 == 0) {
			return (double) (numbers[length / 2] + numbers[(length / 2) + 1]) / 2;
		} else {
			return numbers[(length + 1) / 2];
		}

	}

	// after consider feedbacks
	// https://codereview.stackexchange.com/questions/172184/general-java-class-to-find-mode

	/**
	 * Return objects which appears most often.
	 * 
	 * @return Map<object,countAppears> most appears objects.
	 */
	
	@SuppressWarnings("unchecked")
	public static <T> Entry<Set<T>, Integer> mode(T... objects) {
		Objects.requireNonNull(objects, "objects must not be null");
		if (objects.length == 0) {
			return null;
		}
		Mode<T> mode = new Mode<T>();
		for (T t : objects) {
			mode.checkMaxAppears(t);
		}

		return mode.getMode();

	}



	/**
	 * Work like {@link #mode(Object...)}.
	 */
	public static Entry<Set<Integer>, Integer> mode(int... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		if (numbers.length == 0) {
			return null;
		}
		Mode<Integer> mode = new Mode<Integer>();
		for (int t : numbers) {
			mode.checkMaxAppears(t);
		}

		return mode.getMode();
	}

	/**
	 * Work like {@link #mode(Object...)}.
	 */
	public static Entry<Set<Long>, Integer> mode(long... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		if (numbers.length == 0) {
			return null;
		}
		Mode<Long> mode = new Mode<>();
		for (long t : numbers) {
			mode.checkMaxAppears(t);

		}

		return mode.getMode();
	}

	/**
	 * Work like {@link #mode(Object...)}.
	 */
	public static Entry<Set<Double>, Integer> mode(double... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		if (numbers.length == 0) {
			return null;
		}
		Mode<Double> mode = new Mode<Double>();
		for (double t : numbers) {
			mode.checkMaxAppears(t);
		}
		return mode.getMode();
	}

	/**
	 * Work like {@link #mode(Object...)}.
	 */
	public static Entry<Set<Float>, Integer> mode(float... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");

		if (numbers.length == 0) {
           return null;   
		}		
		Mode<Float> mode = new Mode<Float>();
		for (float t : numbers) {
			mode.checkMaxAppears(t);
		}
		return mode.getMode();
	}


	private static class Mode<T> {
		
	    private Map<T, Integer> frequencies;
	    private Set<T> modes;
	    private int modeFrequency ;
	    

		public Mode() {
			this.modeFrequency = 0;
			this.modes = new HashSet<>();
			this.frequencies = new HashMap<>();
		}

		void checkMaxAppears(T currentObject) {
			
			     final Integer before = frequencies.getOrDefault(currentObject, 0);
		         final Integer after = before + 1;
		         frequencies.put(currentObject, after);
		         if (after == modeFrequency) {
		            modes.add(currentObject);
		         } else if (after > modeFrequency) {
		            modes.clear();
		            modes.add(currentObject);
		            modeFrequency = after;
		         }
		         
		}


		Entry<Set<T>, Integer> getMode() {
		
			return new SimpleImmutableEntry<Set<T>, Integer>(modes,modeFrequency);
		}
	}

	// after consider feedbacks
	// https://codereview.stackexchange.com/questions/172138/calculate-geometric-and-arithmetic-mean

	/**
	 * Calculates geometric mean of the given numbers .
	 * 
	 * <ul>
	 * <li>(-1)^m * 1/n-rt(product(numbers)) = (-1)^m exp(1/n
	 * sum(ln(numbers[i])))
	 * <li>n : is length of numbers</li>
	 * <li>m : is number of negative values</li>
	 * </ul>
	 * 
	 * @return geometric mean
	 *         <ul>
	 *         <li>NAN : if numbers array is empty</li>
	 *         <li>0 :if numbers array contain 0 value</li>
	 *         <li>negative value : if numbers of negative values is odd
	 *         <li>positive value : if numbers of positive values is even or it
	 *         just positive values
	 *         </ul>
	 * 
	 * @throws IllegalArgumentException
	 *             if numbers array are null
	 */
	public static double geometricMean(int... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");

		if (numbers.length == 0) {
			return Double.NaN;
		}

		Mean mean = new Mean();

		for (int i : numbers) {
			if (i == 0) {
				mean.add(1);
			}
			else{
			mean.add(i);
			}

		}

		return mean.getGeometricMean();

	}

	/**
	 * Works just like {@link Mean#geometricMean(int...)} except the array
	 * contains long numbers.
	 */
	public static double geometricMean(long... numbers) {	
		Objects.requireNonNull(numbers, "numbers must not be null");
		
		if (numbers.length == 0) {
			return Double.NaN;
		}

		Mean mean = new Mean();
		for (long i : numbers) {
			if (i == 0) {
				mean.add(1);
			}
			else{
			mean.add(i);
			}

		}

		return mean.getGeometricMean();

	}

	/**
	 * Works just like {@link Mean#Mean#geometricMean(int...)} except the array
	 * contains double numbers.
	 */
	public static double geometricMean(double... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");

		if (numbers.length == 0) {
			return Double.NaN;
		}

		Mean mean = new Mean();

		for (double i : numbers) {
			if (i == 0) {
				mean.add(1);
			} else if (i == Double.NaN) {
				return Double.NaN;
			}
			else{
			mean.add(i);
			}
		}

		return mean.getGeometricMean();

	}

	/**
	 * Works just like {@link Mean#geometricMean(int...)} except the array
	 * contains float numbers
	 */
	public static double geometricMean(float... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		if (numbers.length == 0) {
			return Double.NaN;
		}
		Mean mean = new Mean();

		for (float i : numbers) {
			if (i == 0) {
				mean.add(1);
			} else if (i == Float.NaN) {
				return Double.NaN;
			}
			else{
			mean.add(i);
			}
		}

		return mean.getGeometricMean();

	}

	private static class Mean {
		private int n;
		private double logsum;
		private double sign = 1.0;

		void add(double num) {
			n++;
			if (num < 0) {
				logsum += Math.log(-num);
				sign = -sign;
			} else {
				logsum += StrictMath.log(num);
			}
		}

		double getGeometricMean() {
			return sign * StrictMath.exp(logsum / n);
		}
	}

	/**
	 * The mean is the average of the numbers.
	 * <ul>
	 * <li>sum(numbers[i])/n</li>
	 * <li>n : length of array numbers.</li> integers
	 * </ul>
	 * 
	 * @return average of the numbers
	 *         <ul>
	 *         <li>NAN : if array numbers is empty
	 *         <li>average : if contains numbers
	 *         </ul>
	 * @throws IllegalArgumentException
	 *             if numbers array is null
	 */
	public static double arithmeticMean(int... numbers) {
		Objects.requireNonNull(numbers, "numbers must not be null");
		long tmp = 0;
		for (int i : numbers) {
			tmp += i;

		}
		return (double) tmp / numbers.length;

	}

	/**
	 * Works just like {@link Mean#arithmeticMean(int...)} except the array
	 * contains double numbers.
	 */
	public static double arithmeticMean(double... numbers) {
		return DoubleStream.of(numbers).sum() / numbers.length;
	}

	/**
	 * Works just like {@link Mean#arithmeticMean(int...)} except the array
	 * contains long numbers .
	 */
	public static double arithmeticMean(long... numbers) {
		return (double) LongStream.of(numbers).sum() / numbers.length;
	}

}
