package com.forneus.unit2.iloveyouboss;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsEmptyIterable.emptyIterable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProfileTest {

	private Profile profile = new Profile("Bull Hockey, Inc.");
	private Question question = new BooleanQuestion(1, "Got bonuses?");
	private Criteria criteria = new Criteria();

	/*
	 * kill gets set to true because match is false and criterion.getWeight() equals
	 * Weight.MustMatch (line 34)
	 */
	@Test
	public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

		boolean itMatches = profile.matches(criteria);
		assertFalse(itMatches);

	}

	/*
	 *  match resolves to true because criterion.getWeight() returns Weight.DontCare 
	 *  (line 30).
	 */
	@Test
	public void matchAnswersTrueForAnyDontCareCriteria() {
		profile.add(new Answer(question, Bool.TRUE));
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

		boolean itMatches = profile.matches(criteria);
		assertTrue(itMatches);
		assertEquals(profile.score(), 0);
	}

	/* The Criteria instance holds no Criterion objects (line 27). */
	@Test
	public void criteriaEmpty() {
		profile.add(new Answer(question, Bool.TRUE));

		boolean itMatches = profile.matches(criteria);
		assertFalse(itMatches);
		assertThat(criteria, emptyIterable());

	}
	
	/* The Criteria instance holds many Criterion objects (line 27). */
	@Test
	public void criteriaNotEmpty() {
		profile.add(new Answer(question, Bool.TRUE));
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.Important))
				.add(new Criterion(new Answer(question, Bool.FALSE), Weight.DontCare));

		boolean itMatches = profile.matches(criteria);
		assertTrue(itMatches);
		assertThat(criteria, not(emptyIterable()));

	}

	/* The Answer returned from answers.get() is null (line 29). */
	//@Test
	/* Either of criterion.getAnswer() or criterion.getAnswer().getQuestionText() returns null (line 29). */
	//@Test
	/* match resolves to true because value matches criterion.getValue() (line 30). */
	//@Test
	/* match resolves to false because both conditions return false (line 30). */
	//@Test
	/* kill does not get changed because match is true (line 34). */
	//@Test
	/* kill does not get changed because criterion.getWeight() is something other than Weight.MustMatch (line 34). */
	//@Test
	/* score gets updated because match is true (line 37). */
	//@Test
	/* score does not get updated because match is false (line 37). */
	//@Test
	/* The matches method returns false because kill is true (line 42). */
	//@Test
	/* The matches method returns true because kill is false and anyMatches is true (lines 42 and 44). */
	//@Test
	/* The matches method returns false because kill is false and anyMatches is false (lines 42 and 44). */
	//@Test
}
