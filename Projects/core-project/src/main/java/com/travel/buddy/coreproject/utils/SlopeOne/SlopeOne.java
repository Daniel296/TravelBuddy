package com.travel.buddy.coreproject.utils.SlopeOne;

import com.travel.buddy.coreproject.model.UserProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SlopeOne {
    private static Map<String, Map<String, Double>> diff = new HashMap<>();
    private static Map<String, Map<String, Integer>> freq = new HashMap<>();
    private static Map<UserProfile, HashMap<String, Double>> inputData;
    public static Map<UserProfile, HashMap<String, Double>> outputData = new HashMap<>();

    public static void prepareUpdate() {
        inputData = InputData.initializeData();
        buildDifferencesMatrix(inputData);
        predict(inputData);
    }

    private static void buildDifferencesMatrix(Map<UserProfile, HashMap<String, Double>> data) {
        for (HashMap<String, Double> user : data.values()) {
            for (Entry<String, Double> e : user.entrySet()) {
                if (!diff.containsKey(e.getKey())) {
                    diff.put(e.getKey(), new HashMap<String, Double>());
                    freq.put(e.getKey(), new HashMap<String, Integer>());
                }
                for (Entry<String, Double> e2 : user.entrySet()) {
                    int oldCount = 0;
                    if (freq.get(e.getKey()).containsKey(e2.getKey())) {
                        oldCount = freq.get(e.getKey()).get(e2.getKey()).intValue();
                    }
                    double oldDiff = 0.0;
                    if (diff.get(e.getKey()).containsKey(e2.getKey())) {
                        oldDiff = diff.get(e.getKey()).get(e2.getKey()).doubleValue();
                    }
                    double observedDiff = e.getValue() - e2.getValue();
                    freq.get(e.getKey()).put(e2.getKey(), oldCount + 1);
                    diff.get(e.getKey()).put(e2.getKey(), oldDiff + observedDiff);
                }
            }
        }
        for (String j : diff.keySet()) {
            for (String i : diff.get(j).keySet()) {
                double oldValue = diff.get(j).get(i).doubleValue();
                int count = freq.get(j).get(i).intValue();
                diff.get(j).put(i, oldValue / count);
            }
        }
        // printData(data);
    }

    private static void predict(Map<UserProfile, HashMap<String, Double>> data) {
        HashMap<String, Double> uPred = new HashMap<String, Double>();
        HashMap<String, Integer> uFreq = new HashMap<String, Integer>();
        for (String j : diff.keySet()) {
            uFreq.put(j, 0);
            uPred.put(j, 0.0);
        }
        for (Entry<UserProfile, HashMap<String, Double>> e : data.entrySet()) {
            for (String j : e.getValue().keySet()) {
                for (String k : diff.keySet()) {
                    try {
                        double predictedValue = diff.get(k).get(j).doubleValue() + e.getValue().get(j).doubleValue();
                        double finalValue = predictedValue * freq.get(k).get(j).intValue();
                        uPred.put(k, uPred.get(k) + finalValue);
                        uFreq.put(k, uFreq.get(k) + freq.get(k).get(j).intValue());
                    } catch (NullPointerException e1) {
                    }
                }
            }
            HashMap<String, Double> clean = new HashMap<String, Double>();
            for (String j : uPred.keySet()) {
                if (uFreq.get(j) > 0) {
                    clean.put(j, uPred.get(j).doubleValue() / uFreq.get(j).intValue());
                }
            }
            for (String j : InputData.items) {
                if (e.getValue().containsKey(j)) {
                    clean.put(j, e.getValue().get(j));
                } else {
                    clean.put(j, -1.0);
                }
            }
            outputData.put(e.getKey(), clean);
        }
        // printData(outputData);
    }
}