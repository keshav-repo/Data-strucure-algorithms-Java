package com.learning.random;

import java.util.Map;
import java.util.HashMap;

class FrequencyTracker {
    private Map<Integer, Integer> frequency;
    private Map<Integer, Integer> tracker;
    public FrequencyTracker() {
        frequency = new HashMap<>();
        tracker = new HashMap<>();
    }
    public void add(int number) {
        int prevFreq;
        if (tracker.containsKey(number)) {
            prevFreq = tracker.get(number);
            tracker.put(number, prevFreq+1);
        } else {
            tracker.put(number, 1);
            prevFreq = 0;
        }

        // there will be corresponding freq
        if (frequency.containsKey(prevFreq)) {
            int count = frequency.get(prevFreq);
            if(count == 1){
                frequency.remove(prevFreq);
            }else{
                frequency.put(prevFreq, count - 1);
            }
        }else{
            frequency.remove(prevFreq);
        }

        // check if there is a prev freq for new frequency
        if (frequency.containsKey(prevFreq + 1)) {
            int newFreqCount = frequency.get(prevFreq + 1);
            frequency.put(prevFreq + 1, newFreqCount + 1);
        } else {
            frequency.put(prevFreq + 1, 1);
        }
    }

    public void deleteOne(int number) {
        int freq = 0;
        if (tracker.containsKey(number)) {
            freq = tracker.get(number);
            if (freq == 1) {
                tracker.remove(number);
            } else {
                tracker.put(number, freq - 1);
            }
        }

        if (frequency.containsKey(freq)) {
            int count = frequency.get(freq);
            if (count <= 1) {
                frequency.remove(freq);
            } else {
                frequency.put(freq, count - 1);
            }
        }

        if(freq!=1 ){
            if (frequency.containsKey(freq-1)) {
                int oneLessFreqCount = frequency.get(freq-1);
                frequency.put(freq-1, oneLessFreqCount+1);
            }else{
                frequency.put(freq-1, 1);
            }
        }

    }

}

