package com.forneus.unit01.iloveyouboss;

import java.util.ArrayList;
import java.util.Collection;

public class ScoreCollection {
	Collection<Scoreable> scores = new ArrayList<Scoreable>();

	public ScoreCollection add(Scoreable scoreable) {
		scores.add(scoreable);
		return this;
	}

	public int arithmeticMean() {
		int total = scores.stream().mapToInt(Scoreable::getScore).sum();
		return total / scores.size();
	}
}
