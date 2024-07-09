1. How can we efficiently determine the top five maximum values from a continuously incoming stream of data. Order of top 5 element can be anything
```
t1:  40
t2: 60,
t3: 100
t4: 99
t5: 5000 => res: [40, 60, 100,99, 5000] 
t6: 6000 => res: [60, 100,99, 5000, 6000] 
t7: 400  => res: [100,99, 5000, 6000, 400] 
```
- SolutionRef:  [Max5InputStream](https://github.com/keshav-repo/Data-strucure-algorithms-Java/blob/master/src/main/java/com/learning/random/Max5InputStream.java)
2. I have 5 virtual machine and a load balancer. Load balancer distrubute request randomely and also ensures that all the host get 
equal number of request. 
```
req 1=> host 2
re2 2 => host 4
req 3 => host 3,
req 4 => host 1
req 5 => host 5
req 6 => host 1 
```

