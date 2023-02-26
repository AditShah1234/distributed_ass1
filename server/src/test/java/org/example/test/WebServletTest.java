package org.example.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.junit.jupiter.api.Test;

class WebServletTest {

	

	@Test
	void testAudioGet() throws Exception {
		String url = "zaudio";
		HttpClient client = new HttpClient();
		client.start();
		Request request_get = client.newRequest(url);
		request_get.param("artist_all", "true");
		ContentResponse response_get = request_get.send();
		assertThat(response_get.getStatus(), equalTo(200));
		String responseContent = IOUtils.toString(response_get.getContent());
		System.out.println(responseContent);
		client.stop();
	}

	@Test
	void testAudioPost() throws Exception {

		String url = "http://204.216.108.46:8080/audio";
		HttpClient client = new HttpClient();
		client.start();

		Request request = client.POST(url);

		request.param("name", "artist1000");
		request.param("track", "wew");
		request.param("album", "wdfwr");
		request.param("track_num", "21");
		request.param("num_review", "12");
		request.param("num_copy_sold", "1211");
		request.param("year","2011");

		ContentResponse response = request.send();
		String res = new String(response.getContent());
		System.out.println(res);
		client.stop();
	}
	@Test
	void testAudio() throws Exception {
		String url = "http://204.216.108.46:8080/audio";
		Scanner sc = new Scanner(System.in); // System.in is a standard input stream
		System.out.print("Enter how many client to be created");
		int no_clients = sc.nextInt();
		
		System.out.println();
		
		System.out.print("Enter how many Get to be created in each client ");
		int no_gets = sc.nextInt();
		sc.close();
		
		
		
		
		List<thread_client> clients = new ArrayList<>();
		for (int i = 0; i < no_clients; i++) {
			thread_client R1 = new thread_client(Integer.toString(i), url, no_gets);
			R1.start();
			clients.add(R1);
		}
		for (int i = 0; i < no_clients; i++) {
			try {
				clients.get(i).join();
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted");
			}
		}
		for (int i = 0; i < no_clients; i++) {
			System.out.println(clients.get(i).getTimeElapsed().toMillisPart());
		}
//		Instant end_now = Instant.now();
//		Duration timeElapsed = Duration.between(start_now, end_now); 
 
//		System.out.println(timeElapsed.dividedBy(no_clients*no_gets).toNanos()+" ns");

		

	}

}
