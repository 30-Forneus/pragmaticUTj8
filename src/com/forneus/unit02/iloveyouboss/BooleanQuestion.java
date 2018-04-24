package com.forneus.unit02.iloveyouboss;


public class BooleanQuestion extends Question {
   public BooleanQuestion(int id, String text) {
      super(id, text, new String[] { "No", "Yes" });
   }

   @Override
   public boolean match(int expected, int actual) {
      return expected == actual;
   }
}
