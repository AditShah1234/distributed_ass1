package org.example.controller;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.time.Duration;
import java.time.Instant;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;

public class thread_client implements Runnable {
    private Thread t;
    private String threadName;
    private String url;
    int n,n1;
    private Instant start_now,end_now;
    private Duration timeElapsed;

    thread_client( String name, String url, Integer n,Integer n1) {
        threadName = name;
        this.url =url;
        this.n =n;
        this.n1=n1;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );

        try {
            HttpClient client = new HttpClient();
            client.start();
            start_now = Instant.now();
            Request request = client.POST(url);
            request.param("name","artist900");
            request.param("track","wew");
            request.param("album","wdfwr");
            request.param("track_num","21");
            request.param("num_review","12");
            request.param("num_copy_sold","1211");
            request.param("year","2011");
//            request.param("artist_name","artist900");
//            request.param("track_title","wew");
//            request.param("album","wdfwr");
//            request.param("track_number","21");
//            request.param("reviews_count","12");
//            request.param("copies_sold","1211");
//            {
//                "artist_name": "string",
//                    "copies_sold": 0,
//                    "reviews_count": 0,
//                    "track_number": 0,
//                    "track_title": "string",
//                    "year": 0
//            }
            ContentResponse response = request.send();
            String res = new String(response.getContent());
            System.out.println(res);
            for ( int i =0;i<n;i++) {


                Request request_get = client.newRequest(url);
                request_get.param("artist_all","true");
                ContentResponse response_get = request_get.send();
                assertThat(response_get.getStatus(), equalTo(200));
                String responseContent = IOUtils.toString(response_get.getContent());
                System.out.println(responseContent+ Integer.toString(i) );
            }

            for ( int i =0;i<n1;i++) {


                Request request_get = client.newRequest(url);
                request_get.param("name","udito");
                ContentResponse response_get = request_get.send();
                assertThat(response_get.getStatus(), equalTo(200));
                String responseContent = IOUtils.toString(response_get.getContent());
                System.out.println(responseContent+ Integer.toString(i) );
            }

            end_now = Instant.now();

            client.stop();
            timeElapsed = Duration.between(start_now, end_now);

            timeElapsed = timeElapsed.dividedBy(n+1+n1);
            System.out.println("Creating " +  threadName +"executed success");
        }catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }



    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
    public void join() throws InterruptedException {
        t.join ();
    }

    public Duration getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(Duration timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public Thread getT() {
        return t;
    }

    public String getThreadName() {
        return threadName;
    }

    public String getUrl() {
        return url;
    }

    public int getN() {
        return n;
    }

    public Instant getStart_now() {
        return start_now;
    }

    public Instant getEnd_now() {
        return end_now;
    }



}

