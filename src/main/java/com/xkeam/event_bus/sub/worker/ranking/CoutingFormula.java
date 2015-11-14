package com.xkeam.event_bus.sub.worker.ranking;

public class CoutingFormula {
	
	public static double top() {
		double result = 0;
		return result;
	}
	
	public static double hot() {
		double result = 0;
		return result;
	}
	
	public static double trend() {
		double result = 0;
		return result;
	}
	
	/**
	 * Score(time) = Sum[previous][Score(previous) * decay(time, previous)] + Update(time)
	 * @return
	 */
	public static double scoreFormula(long time, DecayFactor decay, ScoreData scoreAPI) {
		double result = 0;
		
		result += scoreAPI.getUpdate(time);
		
		long limit = decay.limit();
		for(long i = 1 ; i <= limit ; i ++) {
			result += scoreAPI.getScore(time - i) * decay.compute(time, time - i);
		}
		
		scoreAPI.setScore(time, result);
		
		return result;
	}
	
	public static class ResultPair {
		public double result = 0.0;
		public long limit = 0;
	}
	
	public static abstract class ScoreData {
		public abstract double getUpdate(long time);
		public abstract double getScore(long time);
		public abstract void setScore(long time, double score);
	}
	
	public static abstract class DecayFactor {
		public abstract long limit();
		public abstract double compute(long time, long previous);
	}
	
	
	
	public static class TopDecay extends DecayFactor {
		/**
		 * Compute top-score by day-period
		 */
		
		long limit = 10;
		double base_factor = 0.7;

		@Override
		public long limit() {
			return limit;
		}

		@Override
		public double compute(long time, long previous) {
			long distance = time - previous;
			return Math.pow(base_factor, distance);
		}
		
	}
	
	public static class HotDecay extends DecayFactor {
		/**
		 * Compute hot-score by day-period
		 */
		
		long limit = 3;
		double base_factor = 0.5;

		@Override
		public long limit() {
			return limit;
		}

		@Override
		public double compute(long time, long previous) {
			long distance = time - previous;
			return Math.pow(base_factor, distance);
		}
		
	}
	
	
	public static class TrendDecay extends DecayFactor {
		/**
		 * Compute trend-score by hour in day
		 * Simple total interaction : score(time) = score(time-1) + update(time)
		 */
		
		long limit = 1;

		@Override
		public long limit() {
			return limit;
		}

		@Override
		public double compute(long time, long previous) {
			if(previous < 0)
				return 0;
			else 
				return 1;
		}
		
	}
	
	
	

}
