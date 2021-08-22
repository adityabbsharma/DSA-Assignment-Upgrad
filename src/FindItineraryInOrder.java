/*
* Find Itinerary in Order
Description
Given a list of tickets in pairs as source city and destination city, find the itinerary in order
* using the given list.

Note that the given list of tickets is non-cyclic and there is one ticket from each city except the
* destination city.

Input Format:

The first line contains an integer N representing the number of tickets.

For the next N lines, each line contains a ticket representing the source city and the destination city.

Output Format:

Print ‘Invalid Input’ if the start city is null, else print city in an itinerary in order, a pair in each
* line as shown below:

Bangalore->Ranchi

Ranchi->Jamshedpur

Sample Test Cases:

Input:

4

Bangalore Ranchi

Jamshedpur Kolkata

Ranchi Jamshedpur

Kolkata Varanasi

Output:

Bangalore->Ranchi

Ranchi->Jamshedpur

Jamshedpur->Kolkata

Kolkata->Varanasi

Input:

4

Chennai Bangalore

Bombay Delhi

Goa Chennai

Delhi Goa


Output:

Bombay->Delhi

Delhi->Goa

Goa->Chennai

Chennai->Bangalore
* */
import java.util.*;
public class FindItineraryInOrder {
    public static void findItinerary(Map<String, String> tickets) {
        // Write code here
        StringBuilder source= new StringBuilder();
        StringBuilder destination= new StringBuilder();
        for(String string:tickets.keySet()){
            if(!tickets.containsValue(string))
                source.append(string);
        }

        int size = tickets.size();
        String nextDestination,nextSource=source.toString();
        for(int i=0;i<size;i++){
            nextDestination = tickets.get(nextSource);
            System.out.println(nextSource+"->"+nextDestination);
            nextSource = nextDestination;
        }

    }

    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            tickets.put(sc.next(),sc.next());
        }
        findItinerary(tickets);
    }
}
