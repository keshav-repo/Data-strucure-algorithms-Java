package com.learning.random;

import java.util.Map;
import java.util.HashMap;

public class FrequencyTracker2 {
    Map<Integer, Integer> tracker;
    Map<Integer, Integer> freqMapper;

    public FrequencyTracker2() {
        tracker = new HashMap<>();
        freqMapper = new HashMap<>();
    }

    private void addOneToFreq(int freq) {
        if (freqMapper.containsKey(freq)) {
            int count = freqMapper.get(freq);
            freqMapper.put(freq, count + 1);
        } else {
            freqMapper.put(freq, 1);
        }
    }

    private void subsOneToFreq(int freq) {
        if (freqMapper.containsKey(freq)) {
            int count = freqMapper.get(freq);
            if(count==1){
                freqMapper.remove(freq);
            }else {
                freqMapper.put(freq, count - 1);
            }
        }
    }

    public void add(int number) {
        if (tracker.containsKey(number)) {
            int existingFreq = tracker.get(number);
            tracker.put(number, existingFreq+1);
            addOneToFreq(existingFreq+1);
            subsOneToFreq(existingFreq);
        } else {
            tracker.put(number, 1);
            addOneToFreq(1);
        }
    }

    public void deleteOne(int number) {
        if (tracker.containsKey(number)) {
            int count = tracker.get(number);
            if (count == 1) {
                tracker.remove(number);
                subsOneToFreq(1);
            } else {
                tracker.put(number, count - 1);
                addOneToFreq(count-1);
                subsOneToFreq(count);
            }
        }
    }

    public boolean hasFrequency(int frequency) {
         return freqMapper.containsKey(frequency);
    }

    public static void main(String[] args) {

    }
}
