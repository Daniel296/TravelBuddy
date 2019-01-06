package com.travel.buddy.coreproject;

import com.travel.buddy.coreproject.model.Interest;
import com.travel.buddy.coreproject.utils.score.ScoreComputerByUserInterestsImpl;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("Duplicates")
public class ScoreComputerByUserInterestsImplTest {

    @Test
    public void GetScoreTest1() {

        Interest interest1 = new Interest();
        interest1.setArt_gallery(true);
        interest1.setAmusement_park(true);
        interest1.setAquarium(true);
        interest1.setBridge(true);
        interest1.setEmbassy(true);
        interest1.setBowling_alley(true);
        interest1.setBeach(true);

        Interest interest2 = new Interest();
        interest2.setArt_gallery(true);
        interest2.setAmusement_park(true);
        interest2.setAquarium(true);
        interest2.setBridge(true);
        interest2.setMosque(true);
        interest2.setNight_club(true);
        interest2.setBar(true);
        interest2.setCafe(true);
        interest2.setCasino(true);

        ScoreComputerByUserInterestsImpl computer = new ScoreComputerByUserInterestsImpl();
        double score = computer.getScore(interest1, interest2);

        Assert.assertEquals(0.4199, score, 0.01);
    }

    @Test
    public void GetScoreTest1Reverse() {

        Interest interest1 = new Interest();
        interest1.setArt_gallery(true);
        interest1.setAmusement_park(true);
        interest1.setAquarium(true);
        interest1.setBridge(true);
        interest1.setEmbassy(true);
        interest1.setBowling_alley(true);
        interest1.setBeach(true);

        Interest interest2 = new Interest();
        interest2.setArt_gallery(true);
        interest2.setAmusement_park(true);
        interest2.setAquarium(true);
        interest2.setBridge(true);
        interest2.setMosque(true);
        interest2.setNight_club(true);
        interest2.setBar(true);
        interest2.setCafe(true);
        interest2.setCasino(true);

        ScoreComputerByUserInterestsImpl computer = new ScoreComputerByUserInterestsImpl();
        double score = computer.getScore(interest2, interest1);

        Assert.assertEquals(0.35353, score, 0.01);
    }

    @Test
    public void GetScoreTest2() {

        Interest interest1 = new Interest();
        interest1.setArt_gallery(true);
        interest1.setAmusement_park(true);
        interest1.setAquarium(true);
        interest1.setBridge(true);
        interest1.setEmbassy(true);
        interest1.setBowling_alley(true);
        interest1.setBeach(true);

        Interest interest3 = new Interest();
        interest3.setArt_gallery(true);
        interest3.setAmusement_park(true);
        interest3.setAquarium(true);
        interest3.setBridge(true);
        interest3.setMosque(true);

        ScoreComputerByUserInterestsImpl computer = new ScoreComputerByUserInterestsImpl();
        double score = computer.getScore(interest1, interest3);

        Assert.assertEquals(0.5411, score, 0.01);
    }

    @Test
    public void GetScoreTest2Reverse() {

        Interest interest1 = new Interest();
        interest1.setArt_gallery(true);
        interest1.setAmusement_park(true);
        interest1.setAquarium(true);
        interest1.setBridge(true);
        interest1.setEmbassy(true);
        interest1.setBowling_alley(true);
        interest1.setBeach(true);

        Interest interest3 = new Interest();
        interest3.setArt_gallery(true);
        interest3.setAmusement_park(true);
        interest3.setAquarium(true);
        interest3.setBridge(true);
        interest3.setMosque(true);

        ScoreComputerByUserInterestsImpl computer = new ScoreComputerByUserInterestsImpl();
        double score = computer.getScore(interest3, interest1);

        Assert.assertEquals(0.70909, score, 0.01);
    }

    @Test
    public void GetScoreTest3() {

        Interest interest2 = new Interest();
        interest2.setArt_gallery(true);
        interest2.setAmusement_park(true);
        interest2.setAquarium(true);
        interest2.setBridge(true);
        interest2.setMosque(true);
        interest2.setNight_club(true);
        interest2.setBar(true);
        interest2.setCafe(true);
        interest2.setCasino(true);

        Interest interest3 = new Interest();
        interest3.setArt_gallery(true);
        interest3.setAmusement_park(true);
        interest3.setAquarium(true);
        interest3.setBridge(true);
        interest3.setMosque(true);

        ScoreComputerByUserInterestsImpl computer = new ScoreComputerByUserInterestsImpl();
        double score = computer.getScore(interest2, interest3);

        Assert.assertEquals(0.5555, score, 0.01);
    }

    @Test
    public void GetScoreTest3Reverse() {

        Interest interest2 = new Interest();
        interest2.setArt_gallery(true);
        interest2.setAmusement_park(true);
        interest2.setAquarium(true);
        interest2.setBridge(true);
        interest2.setMosque(true);
        interest2.setNight_club(true);
        interest2.setBar(true);
        interest2.setCafe(true);
        interest2.setCasino(true);

        Interest interest3 = new Interest();
        interest3.setArt_gallery(true);
        interest3.setAmusement_park(true);
        interest3.setAquarium(true);
        interest3.setBridge(true);
        interest3.setMosque(true);

        ScoreComputerByUserInterestsImpl computer = new ScoreComputerByUserInterestsImpl();
        double score = computer.getScore(interest3, interest2);

        Assert.assertEquals(0.8787, score, 0.01);
    }
}
