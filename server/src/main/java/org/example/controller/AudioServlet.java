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

@WebServlet(name = "audio", value = "audio")
public class AudioServlet extends HttpServlet {

	/*
	 * ConcurrentHashMap is thread safe;
	 */

	ConcurrentHashMap<String, Audio> audioMasterDB = new ConcurrentHashMap<>();
	ConcurrentHashMap<String, HashSet<String>> audioNameDB = new ConcurrentHashMap<>();
	ConcurrentHashMap<String, HashSet<String>> audioTrackDB = new ConcurrentHashMap<>();
	ConcurrentHashMap<String, HashSet<String>> audioAlbumDB = new ConcurrentHashMap<>();
	private long total_copies_sold_all = 0;
	private int last_records = 0;
	private HashSet<String> union = new HashSet<>();
	private HashSet<String> name_record = new HashSet<>();
	private HashSet<String> track_record = new HashSet<>();
	private HashSet<String> album_record = new HashSet<>();
	/*
	 * simply emulation of in memory database;
	 * 
	 * @Override public void init() throws ServletException { audioDB.put("id_1",
	 * "artist_name_1"); audioDB.put("id_2", "artist_name_2"); audioDB.put("id_3",
	 * "artist_name_3"); audioDB.put("id_4", "artist_name_4"); audioDB.put("id_5",
	 * "artist_name_5"); audioDB.put("id_6", "artist_name_6");
	 * 
	 * }
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String track = request.getParameter("track");
		String album = request.getParameter("album");
		String artist_all = request.getParameter("artist_all");
		Gson gson = new Gson();

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println(name+track+album+artist_all);
		if (name == null && track == null && album == null && artist_all == null) {
			JsonElement element = gson.toJsonTree(audioMasterDB);
			JsonElement elementN = gson.toJsonTree(audioNameDB);
			JsonElement elementT = gson.toJsonTree(audioTrackDB);
			JsonElement elementA = gson.toJsonTree(audioAlbumDB);
			out.println("GET RESPONSE IN JSON - all elements " + element.toString()+ " total sale " + String.valueOf(total_copies_sold_all));

			out.flush();
		} else if (artist_all != null) {
			if (artist_all.equals("true")) {
			out.println("GET RESPONSE IN JSON - all elements " + audioNameDB.keySet().toString()+ " total sale " + String.valueOf(total_copies_sold_all));

			out.flush();
			}
		} else {

			if (name != null) {
				name_record = audioNameDB.get(name);

			}
			if (track != null) {
				track_record = audioTrackDB.get(track);
			}
			if (album != null) {
				album_record = audioAlbumDB.get(album);
			}
			// System.out.println(name+track+album+name_record.toString()+track_record.toString()+album_record.toString());

			union.addAll(name_record);
			union.addAll(track_record);
			union.addAll(album_record);

			if (name == null) {
				name_record.addAll(union);
			}

			if (track == null) {
				track_record.addAll(union);
			}
			if (album == null) {
				album_record.addAll(union);
			}

			HashSet<String> intersection = new HashSet<String>(name_record); // use the copy constructor
			System.out.print(intersection.toString() + "name_record");
			intersection.retainAll(track_record);
			System.out.print(intersection.toString() + "track_record");
			intersection.retainAll(album_record);
			System.out.print(intersection.toString());
			String id = intersection.stream().findFirst().get();

			if (id != null) {
				Audio audio = audioMasterDB.get(id);

				out.println("GET RESPONSE IN JSON - single element: " + gson.toJson(audio)+ " total sale " + String.valueOf(total_copies_sold_all));
				out.flush();
			} else {
				out.println("GET RESPONSE IN JSON resource not found");
				out.flush();
			}

		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String track = request.getParameter("track");
		String album = request.getParameter("album");
		String track_num = request.getParameter("track_num");
		String num_review = request.getParameter("num_review");
		String num_copy_sold = request.getParameter("num_copy_sold");
		String year = request.getParameter("year");
		last_records += 1;

		Long tmp = Long.parseLong(num_copy_sold);
		total_copies_sold_all += tmp;

		String id = String.valueOf(last_records);
		Audio audio = new Audio(id, name, track, album, track_num, num_review, num_copy_sold,year);

		audioMasterDB.put(id, audio);

		if (audioNameDB.containsKey(name)) {
			// HashSet<String> given_name_record =new HashSet<>();
			// given_name_record = audioNameDB.get(name);

			// given_name_record.add(id);
			// audioNameDB.put(name, given_name_record);
			audioNameDB.get(name).add(id);

		} else {

			audioNameDB.put(name, new HashSet<>());
			audioNameDB.get(name).add(id);

		}
		if (audioTrackDB.containsKey(track)) {
			audioTrackDB.get(track).add(id);

		} else {
			audioTrackDB.put(track, new HashSet<>());
			audioTrackDB.get(track).add(id);
		}
		if (audioAlbumDB.containsKey(album)) {
			audioAlbumDB.get(album).add(id);

		} else {
			audioAlbumDB.put(album, new HashSet<>());
			audioAlbumDB.get(album).add(id);
		}
		// System.out.print(audioNameDB.toString());

		response.setStatus(200);

		response.getOutputStream().println("POST RESPONSE: Audio " + name + " is added to the database. " + id
				+ " total sale " + String.valueOf(total_copies_sold_all));
	}
}
