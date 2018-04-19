package com.kgfsl.newdoll;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

class Duplicate {
        public static void main(String[] args) throws IOException {
                // String flightNameTxt = "src/main/resources/trade2.csv";
                // List<String> allFlights = new ArrayList<>();
                // //reading text file into stream
                // Stream<String> filedata = Files.lines(Paths.get(flightNameTxt));
                // allFlights = filedata.collect(Collectors.toList());
                // // filedata.forEach(System.out::println);
                //  //filedata.close();
                //  System.out.println("------------------");
                //  allFlights.stream().distinct().forEach(System.out::println);
                String fileName = "src/main/resources/flight.csv";
                Path myPath = Paths.get(fileName);

                try (BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8)) {

                        HeaderColumnNameMappingStrategy<Flight> strategy = new HeaderColumnNameMappingStrategy<>();
                        strategy.setType(Flight.class);

                        CsvToBean csvToBean = new CsvToBeanBuilder(br).withType(Flight.class)
                                        .withMappingStrategy(strategy).withIgnoreLeadingWhiteSpace(true).build();

                        List<Flight> emp = csvToBean.parse();
                        /*
                        
                        System.out.println("//////////Grouping//////////");
                        Map<String, Long> departureCounting = emp.stream()
                        .collect(Collectors.groupingBy(Flight::getDeparture, Collectors.counting()));
                        System.out.println(departureCounting);
                        System.out.println("///////id//////////");
                        
                        Predicate<Flight> depatrurePredicate = x -> "Coimbatore".equals(x.getDeparture());
                        Predicate<Flight> arrivalPredicate = x -> "London".equals(x.getArrival());
                        System.out.println(emp.stream().filter(depatrurePredicate.and(arrivalPredicate)).map(x -> x.getId())
                            .collect(Collectors.toList()));
                            
                            Map<String, Set<String>> result = emp.stream()
                            .collect(Collectors.groupingBy(Flight::getName, Collectors.mapping(Flight::getId, Collectors.toSet())));
                        
                        System.out.println(result);
                        System.out.println("///////////group////////////////");
                        Map<String, List<Flight>> group = emp.stream().collect(Collectors.groupingBy(Flight::getName));
                        
                        System.out.println(group);
                        
                        System.out.println("/////////tostring group////////////");
                        Map<String, Set<String>> result1 = emp.stream()
                        .collect(Collectors.groupingBy(Flight::getName, Collectors.mapping(Flight::toString, Collectors.toSet())));
                        System.out.println(result1);
                        
                        System.out.println("++++++++++++++");
                                                
                        	Predicate<Flight> rountripPredicate = x -> (x.getDeparture().equals("Heathrow")
                        			&& (x.getArrival().equals("London"))
                        			|| (x.getDeparture().equals("London")) && (x.getArrival().equals("Heathrow")));
                        
                        	System.out.println(emp.stream().filter(rountripPredicate)
                        			.collect(Collectors.groupingBy(Flight::getId, Collectors.toList())));
                        
                        
                                // Minimum fare RoundTrip flights
                        	System.out.println("?????????????");
                        	System.out.println(
                        			emp.stream().filter(rountripPredicate).min(Comparator.comparing(Flight::getFare)).get());
                        
                        	Map<String, Optional<Flight>> personByMaxAge = emp.stream().filter(rountripPredicate)
                        			.collect(Collectors.groupingBy(Flight::getId, Collectors.minBy(Comparator.comparing(Flight::getFare))));
                        
                                    System.out.println("personByMaxAge ...>" + personByMaxAge.toString());
                             */

                        //         // .filter(t -> t.getGV_STS().trim().equals("P"))
                        // emp.stream()
                        // .collect(Collectors.groupingBy(Flight::getId,
                        // Collectors.groupingBy(Flight::getName, Collectors.minBy(new Comparator<Flight>() {
                        // public int compare(Flight s1, Flight s2) {
                        //  return (s1.getFare()).compareTo((s2.getFare()));
                        //                                                 }
                        //           }))))
                        //  .entrySet().stream().forEach((k) -> {
                        //  k.getValue().entrySet().stream().forEach((k1) -> {
                        //  k1.getValue().ifPresent((row) -> {
                        //                    emp.remove(row);
                        //                    System.out.println( emp.remove(row));
                        //                                         });
                        //                                 });
                        //                         });
                        //  emp.stream().forEach(System.out::println);

                        System.out.println("++++++++++++++");

                        // emp.forEach(i  ->
                        // {
                        //         Predicate<Flight> rountripPredicate= x -> (x.getDeparture().equals(i.getDeparture())
                        // 		&& (x.getArrival().equals(i.getArrival()))
                        // 		|| (x.getDeparture().equals(i.getArrival())) && (x.getArrival().equals(i.getDeparture())));

                        // System.out.println(emp.stream().filter(rountripPredicate).distinct()
                        // 		.collect(Collectors.groupingBy(Flight::getId, Collectors.toList())));
                        // });

                        // Map<String, List<Flight>> result= emp.stream().filter(x-> x.getDeparture).collect(Collectors.toList());

                        //         List<String> rs=emp.stream().filter(x->x.getDeparture().equals(()))).map(Flight::getId).collect(Collectors.toList());
                        // System.out.println("rs"+rs);

                        Map<String, Optional<Flight>> aa = emp.stream()
                        			.collect(Collectors.groupingBy(Flight::getId, Collectors.maxBy(new Comparator<Flight>() {
                        				public int compare(Flight s1, Flight s2) {
                                                                
                        					System.out.println("s1="+s1.getId() + " s2=" +s2.getId());

                                                                int x= s1.getDeparture().compareTo(s2.getArrival());
                                                                int y= s1.getArrival().compareTo(s2.getDeparture()) ;
                                                                if(x==0&&y==0)
                                                                {
                                                                        s1.setFlag("R");
                        					        s2.setFlag("R");
                                                                        return 0;
                                                                }                                               
                                                       return -1;
                                                        }
                        			})));
                             
                                              

                             System.out.println("%%%%%%%%%%"+  emp.stream().filter(x->x.getFlag().equals("R")).collect(Collectors.toList()));
                      
                             Comparator <Flight> comparator = (p1, p2) -> Integer.compare(p1.getFare(), p2.getFare());
 
                             // Find youngest
                             System.out.println();
                             
                             System.out.println();
                             
                             System.out.println();
                             
                             System.out.println("Maximum Fare");
                              System.out.println(emp.stream().max(comparator).get());
                           
                      //System.out.println("max"+ Arrays.stream(emp).max(x->x.getFare).collect(Collectors.toList()));


                        
//                         System.out.println("___________________________________");
// List<Flight> round=new ArrayList<Flight>();

                        // for(Flight f:emp){
                        //        String a=f.getArrival();
                        //        String d=f.getDeparture();
                        //         for(Flight g:emp){
                        //             if((a.equals(g.getDeparture())) && (d.equals(g.getArrival())&&!(f.getDeparture().equals(f.getArrival())))&&(f.getId()==g.getId())){
                        //                 round.add(g);
                        //               //  System.out.println(g.getDeparture()+" "+a+"\n"+g.getArrival()+" "+d);
                        //             }
                                    
                        //         }
                            
                        //     }
                        //     System.out.println(round);



                }
        }
}