package ru.unn.agile.ComplexProcent.Model;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class ComplexDepositTest {
    private static final double DELTA = 0.01;

    @Test
    public void canCreateDeposit() {
        ComplexDeposit deposit = new ComplexDeposit(1000, 4, 1);
        GregorianCalendar startDeposit = new GregorianCalendar(2014, 7, 10);
        GregorianCalendar finalDeposit = new GregorianCalendar(2015, 7, 11);
        deposit.setFinishDate(finalDeposit).setStartDate(startDeposit);
        assertNotNull(deposit);
    }

    @Test
    public void canCalcCapitalizedBaseInOnePeriod() {
        ComplexDeposit deposit = new ComplexDeposit(1000, 4.5, 1);
        GregorianCalendar startDeposit = new GregorianCalendar(2014, 7, 10);
        GregorianCalendar finalDeposit = new GregorianCalendar(2015, 7, 10);
        deposit.setFinishDate(finalDeposit).setStartDate(startDeposit);
        assertEquals(1045, deposit.getCapitalizedBase(), DELTA);

    }

    @Test
    public void canCalcCapitalizedBaseInOnePeriodForFewYears() {
        ComplexDeposit deposit = new ComplexDeposit(1000, 4.5, 1);
        GregorianCalendar startDeposit = new GregorianCalendar(2014, 7, 10);
        GregorianCalendar finalDeposit = new GregorianCalendar(2016, 7, 10);
        deposit.setFinishDate(finalDeposit).setStartDate(startDeposit);
        assertEquals(1092.15, deposit.getCapitalizedBase(), DELTA);
    }

    @Test
    public void canCalcCapitalizedBaseInFewPeriodForYear() {
        ComplexDeposit deposit = new ComplexDeposit(1000, 4.5, 3);
        GregorianCalendar startDeposit = new GregorianCalendar(2014, 7, 10);
        GregorianCalendar finalDeposit = new GregorianCalendar(2015, 7, 10);
        deposit.setFinishDate(finalDeposit).setStartDate(startDeposit);
        assertEquals(1045.93, deposit.getCapitalizedBase(), DELTA);
    }

    @Test
    public void canCalcCapitalizedBaseInFewPeriodForFewYears() {
        ComplexDeposit deposit = new ComplexDeposit(1000, 4.5, 3);
        GregorianCalendar startDeposit = new GregorianCalendar(2014, 7, 10);
        GregorianCalendar finalDeposit = new GregorianCalendar(2018, 7, 10);
        deposit.setFinishDate(finalDeposit).setStartDate(startDeposit);
        assertEquals(1196.95, deposit.getCapitalizedBase(), DELTA);
    }

    @Test
    public void canCalcCapitalizedBaseInLessThenYear() {
        ComplexDeposit deposit = new ComplexDeposit(1000, 4.5, 3);
        GregorianCalendar startDeposit = new GregorianCalendar(2014, 7, 10);
        GregorianCalendar finalDeposit = new GregorianCalendar(2015, 5, 11);
        deposit.setFinishDate(finalDeposit).setStartDate(startDeposit);
        assertEquals(1038.27, deposit.getCapitalizedBase(), DELTA);
    }


    @Test
    public void canChangeBase() {
        ComplexDeposit firstDeposit = new ComplexDeposit(1000, 4.5, 3);
        ComplexDeposit secondDeposit = new ComplexDeposit(2000, 3.5, 3);
        firstDeposit.setBase(2000);
        assertEquals(firstDeposit.getBase(), secondDeposit.getBase(), DELTA);
    }

    @Test
    public void canChangePercent() {
        ComplexDeposit firstDeposit = new ComplexDeposit(1000, 4.5, 3);
        ComplexDeposit secondDeposit = new ComplexDeposit(2000, 3.5, 3);
        firstDeposit.setPercent(3.5);
        assertEquals(firstDeposit.getPercent(), secondDeposit.getPercent(), DELTA);
    }

    @Test
    public void canChangeInterestCount() {
        ComplexDeposit deposit1 = new ComplexDeposit(1000, 4.5, 1);
        ComplexDeposit deposit2 = new ComplexDeposit(2000, 3.5, 3);
        deposit1.setInterestCountInYear(3);
        assertEquals(deposit1.getInterestCountInYear(), deposit2.getInterestCountInYear(), DELTA);
    }

    @Test
    public void hashCodeEqualsCheck() {
        ComplexDeposit firstDeposit = new ComplexDeposit(1000, 4.5, 1);
        ComplexDeposit secondDeposit = new ComplexDeposit(1000, 4.5, 1);
        assertTrue(firstDeposit.hashCode() == secondDeposit.hashCode());
    }

    @Test
    public void hashCodeNotEqualsCheck() {
        ComplexDeposit firstDeposit = new ComplexDeposit(1000, 4.5, 1);
        ComplexDeposit secondDeposit = new ComplexDeposit(2000, 3.5, 3);
        assertFalse(firstDeposit.hashCode() == secondDeposit.hashCode());
    }

    @Test
    public void equalsTrueCheck() {
        ComplexDeposit firstDeposit = new ComplexDeposit(1000, 4.5, 1);
        ComplexDeposit secondDeposit = new ComplexDeposit(1000, 4.5, 1);
        assertTrue(firstDeposit.equals(secondDeposit));
    }

    @Test
    public void equalsFalseCheck() {
        ComplexDeposit firstDeposit = new ComplexDeposit(1000, 4.5, 1);
        ComplexDeposit secondDeposit = new ComplexDeposit(2000, 3.5, 4);
        assertFalse(firstDeposit.equals(secondDeposit));
    }

    @Test
    public void canChangeMultiply() {
        ComplexDeposit firstDeposit = new ComplexDeposit(1000, 4.5, 1);
        ComplexDeposit secondDeposit = new ComplexDeposit(2000, 3.5, 3);
        secondDeposit.setPercent(4.5).setBase(1000).setInterestCountInYear(1);
        assertTrue(firstDeposit.equals(secondDeposit));
    }
}
