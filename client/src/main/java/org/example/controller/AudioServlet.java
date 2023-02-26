package org.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

import org.example.model.Audio;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;


@WebServlet(name = "test", value = "test")
public class AudioServlet extends HttpServlet {



	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getParameter("url");
		Integer no_gets = Integer.valueOf(request.getParameter("no_gets"));
		Integer no_clients = Integer.valueOf(request.getParameter("no_clients"));

		Gson gson = new Gson();

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");



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
		ArrayList<Integer> time_dif = new ArrayList<>();
		for (int i = 0; i < no_clients; i++) {
//			System.out.println(clients.get(i).getTimeElapsed().toMillisPart());
			time_dif.add(clients.get(i).getTimeElapsed().toMillisPart());
		}


		out.println(gson.toJson(time_dif));
		out.flush();




	}


}
