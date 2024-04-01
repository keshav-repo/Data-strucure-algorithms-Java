package com.learning.random;


import java.util.Comparator;
        import java.util.PriorityQueue;

class Process implements Comparable<Process>{
    private int priority;
    private int freq;

    public Process(int priority, int freq) {
        this.priority = priority;
        this.freq = freq;
    }

    public int getPriority() {
        return priority;
    }

    public int getFreq() {
        return freq;
    }

    @Override
    public String toString() {
        return "Process [priority=" + priority + ", freq=" + freq + "]";
    }

    @Override
    public int compareTo(Process other) {
        // Compare based on priority (higher priority first)
        int priorityComparison = Integer.compare(other.priority, this.priority);
        if (priorityComparison != 0) {
            return priorityComparison;
        }

        // If priorities are equal, compare based on frequency (higher frequency first)
        return Integer.compare(other.freq, this.freq);
    }

    public static void main(String[] args) {

//        PriorityQueue<Process> priorityQueue = new PriorityQueue<>(Comparator
//                .<Process>comparingInt(p -> p.getFreq() >= 2 ? -1 : 0)
//                .thenComparing( Process::getPriority ));
//
//        // Adding processes to the priority queue
//        priorityQueue.offer(new Process(3, 2));
//        priorityQueue.offer(new Process(2, 1));
//        priorityQueue.offer(new Process(5, 3));
//        priorityQueue.offer(new Process(4, 2));
//        priorityQueue.offer(new Process(1, 4));
//
//        // Polling and printing processes from the priority queue
//        while (!priorityQueue.isEmpty()) {
//            Process process = priorityQueue.poll();
//            System.out.println(process);
//        }

//        PriorityQueue<Process> priorityQueue = new PriorityQueue<>(
//                Comparator
//                .<Process>comparingInt(p -> p.getFreq() >= 2 ? -1 : 0)
//                .thenComparing( Process::getPriority )
//        );


        PriorityQueue<Process> priorityQueue = new PriorityQueue<>(new ProcessComparator());

        // Add processes
        priorityQueue.add(new Process(6, 2));
        priorityQueue.add(new Process(2, 2));
        priorityQueue.add(new Process(1, 1));
        priorityQueue.add(new Process(3, 1));

        // Process the queue
        while (!priorityQueue.isEmpty()) {
            Process process = priorityQueue.poll();
            System.out.println("Process with priority " + process.getPriority() +
                    " and frequency " + process.getFreq());
        }


    }

}

class ProcessComparator implements Comparator<Process> {
    @Override
    public int compare(Process p1, Process p2) {

        if(p1.getFreq()>=2 && p2.getFreq()>=2)
          return Integer.compare(p2.getPriority(), p1.getPriority());
        else
            return -1;

        // If priorities are equal, compare based on frequency (lower frequency first)
       // return Integer.compare(p1.getFreq(), p2.getFreq())*-1;
    }
}

